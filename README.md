# Paint-Project

MMADI Soufeïli


BLOT Arthur  
LUCAS Linda


# TP de commande numérique direct de dispositifs  

 
<!-- < insérer les commentaires ici >
On utilise le language ***Markdown*** pour rédiger ce document.
"<br/>" est la commande pour les retour à la ligne. 
-->
 
 On aura besoin des documentations suivantes : 
 > documentation 1 : https://github.com/blart45/TP_PAPA/tree/main/Documentation/PowerModule_documentation_hacheur.pdf <br/>
 > documentation 2 : https://github.com/blart45/TP_PAPA/tree/main/Documentation/um2505-stm32g4_documentation.pdf <br/>
 > documentation 3 : https://github.com/blart45/TP_PAPA/tree/main/Documentation/um2570-description-of-HAL-functions.pdf 

## SOMMAIRE

1. Mise en place <br/>
2. Creation des PWMs <br/>
3. Lancement du moteur <br/>
	A. Au lancement du code <br/>
	B. Avec le blue button <br/>
	C. Avec l'UART <br/>
	D. Premiers essais <br/>
	E. Changement de la vitesse avec la console <br/>
4. Capteurs de courant et position <br/>
	A. Mesure de courant
	
---

## 1. Mise en place 

On doit s'assurer que les pins des de la carte STM et du hacheur correspondent. On voit sur la figure suivante les pins utilisés sur la carte en surligné : 

<figure>
    <img src="https://github.com/blart45/TP_PAPA/blob/main/capture/figure5.png"
         alt="figure 1" 
	 height="300" 
	 width="300"
    <figcaption>figure 1 : Documentation STM32G4 </figcaption>
<figure> <br/>
	
	
Elles correspondent aux pins du hacheur comme suit : <br/>
	pin 11 = TOP Y <br/>
	pin 12 = TOP R <br/>
	pin 30 = BOT Y <br/>
	pin 31 = BOT R <br/>
	pin 33 = RESET

On a regardé la documentation 1 pour faire correspondre les fonctions du hacheur aux fonctions de la carte. 
	
<figure>
    <img src="https://github.com/blart45/TP_PAPA/blob/main/capture/figure8.png"
         alt="figure 1" 
	 height="300" 
	 width="300">
    <figcaption>figure 2 : Documentation Hacheur </figcaption>
<figure> 
	
On a donc fait les branchements précédents comme suit : 

<figure>
    <img src="https://github.com/blart45/TP_PAPA/blob/main/capture/figure6.png"
         alt="figure 1" 
	 height="300" 
	 width="300">
    <figcaption>figure 3 : Documentation du PCB </figcaption>
<figure> <br/>

---

## 2. Creation des PWMs

Réalisation des 4 PWM pour initialiser le moteur à l'aide des commandes suivantes : 

On commence par créer les 4 PWM sur le Timer 1 à partir des channels 1 et 2, contenant CH1, CH1N et CH2, CH2N (respecctivement). On utilise pour cela: 

```
void initMotor(void){  
	HAL_TIM_PWM_Start(&htim1, TIM_CHANNEL_1);  
	HAL_TIM_PWM_Start(&htim1, TIM_CHANNEL_2);  
	HAL_TIMEx_PWMN_Start(&htim1, TIM_CHANNEL_1);  
	HAL_TIMEx_PWMN_Start(&htim1, TIM_CHANNEL_2); /* Function for the complementary*/  
}
``` 
 > On a utilisé extern pour redéfinir &htim1 dans motor.c

Ensuite on doit définir les valeurs de PSC et ARR pour passer de 170 Mhz à 16 kHz. On trouve : 
PSC = 11-1, et ARR = 1024-1. demi période de 16 kHz

 > On a choisit de garder 170 Mhz comme horloge de référence pour les calucls futurs qui demanderont la puissance du procésseur. 
 
On visualise les PWM pour vérifier qu'elles ont bien les caractéristiques demandés. On voit sur la figure 1 que CH1 et CH2 ont bien les formes demandés correspondant à des complémentaires décalés.  

<figure>
    <img src="https://github.com/blart45/TP_PAPA/blob/main/capture/figure1.jpg"
         alt="figure 1" 
	 height="300" 
	 width="300">
    <figcaption>figure 1 : CH1 et CH2 </figcaption>
<figure> 

On voit de même pour CH1 et CH1N. 

<figure>
    <img src="https://github.com/blart45/TP_PAPA/blob/main/capture/figure11.jpg"
         alt="figure 2"
	 height="300" 
	 width="300">
    <figcaption>figure 4 : CH1 et CH1N </figcaption>
<figure> 

A l'aide de la video suivante : https://www.youtube.com/watch?v=rDaC2N-33Oo
On a calculé les temps morts. On a trouvé qu'il fallait un dead time de 202. 
On effectue donc les changements nécessaire dans le timer 1: 

<figure>
    <img src="https://github.com/blart45/TP_PAPA/blob/main/capture/figure4.png"
         alt="figure 4"
	 height="300" 
	 width="300">
    <figcaption>figure 5 : Configuration du Timer1 </figcaption>
<figure> <br/>
	 
 
 On a bien les PWMs demandés. 

 ---
 
 ## 3. Lancement du moteur
	
On veut maintenant faire tourner le moteur à partir des PWMs générés qui commande le hacheur. La documentation 1 p 16, celle du hacheur, requiert d'effectuer un reset des paramètres du hacheur au lancement par une impulsion d'au moins 2 us. 
 
 ### A. Au lancement du code
	
Dans un premier temps on implémente une impulsion de 1 ms dans la fonction initMotor : 

```	
	HAL_GPIO_WritePin(ISO_RESET_GPIO_Port, ISO_RESET_Pin, SET);
	HAL_Delay(1);
	HAL_GPIO_WritePin(ISO_RESET_GPIO_Port, ISO_RESET_Pin, RESET);
``` 
Lors de l'initialisation, on passe la pin du reset à 1. On attend 1 ms. Et on la remet à 0. Cette procédure permet d'envoyer une impulsion à la carte du hacheur et ainsi de le remettre à 0. On voit bien sur le hacheur que les erreurs due aux surtension/surcourant ont disparus. 
 
 ### B. Avec le blue button (EXTI)
	
De la même manière, on souhaite pouvoir effectuer ce RESET avec le blue button. On va donc chercher dans /Drivers/STM32G4xx_HAL_Driver/Src/stm32g4xx_hal_gpio.c la fonction void HAL_GPIO_EXTI_Callback. Cette fonction est ici en "weak" on peut donc la définir dans un autre fichier. La fonction définie dans l'autre fichier prendra le dessus. </br>
On ajoute donc le code suivant au fichier motor.c : 
```	
	void HAL_GPIO_EXTI_Callback(uint16_t GPIO_Pin){
	HAL_GPIO_WritePin(ISO_RESET_GPIO_Port, ISO_RESET_Pin, SET);
	HAL_Delay(1);
	HAL_GPIO_WritePin(ISO_RESET_GPIO_Port, ISO_RESET_Pin, RESET);
}
```
Maintenant, lorsque l'on appuie sur le blue button on effectue un RESET similaire à celui de l'initialisation. 
 
 ### C. Avec l'UART

Enfin on ajoute également les 3 lignes de la partie A au code de la fonction motorPowerOn() dans le fichier motor.c. Ainsi lorsque l'on tape "power on" dans la console de l'UART, on effectue également un RESET comme précédement. On a maintenant 3 manières différentes d'effectuer un RESET des paramètres du hacheur. 
 
 ### D. Premiers essais
 
Dans un premier temps, en commandant directement les PWMs avec le fichier .ioc, on lance le moteur avec un rapport cyclique de 100% pour CH1 ( 0% pour CH2) et inversement. Le moteur devrait tourner à pleine vitesse dans un sens pour 100% et dans l'autre pour 0%. Cependant, comme on a un fort appel de courant le hacheur enclenche la sécurité "HIGH HALL CURRENT". On place maintenant la PWM à 50% pour chacun des deux channels. Comme attendu le moteur ne tourne pas puisque les deux se compensent. Enfin, on effectue un essai avec 70/30. Le moteur ne démarre pas toujours à cause des surcourants. On va devoir augmenter progressivement la vitesse afin d'éviter les surcourants. </br>
	
 ### E. Changement de la vitesse avec la console
	
On ajoute le code suivant :
```
	void motorSetSpeed(int speed){
	HAL_GPIO_TogglePin(LED_GPIO_Port, LED_Pin); // just for test, you can delete it
	// TIM1->CCR1=speed
	__HAL_TIM_SET_COMPARE(&htim1,TIM_CHANNEL_1,speed);
	// TIM1->CCR1=1023-speed
	__HAL_TIM_SET_COMPARE(&htim1,TIM_CHANNEL_2,1023-speed);
}
```
On utilise la console avec la commande motorSetSpeed(540), avec 540 correspondant à un rapport cyclique proche de 512 la valeur pour 50%. En effectuant, un blue button reset le moteur se met bien à tourner ! 
 
 ---

 ## 4. Capteurs de courant et position
 
 ### A. Mesure de courant

 ---
 
 Fin du rapport
