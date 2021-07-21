# Lab 7

| Outline | Value |
| ------------- | ------------- |
| Course  | SEG 3503  |
| Date  | Summer 2021 |
| Professor  | Andrew Forward, aforward@uottawa.ca  |
| Student 1  | Mahdi Chiboub #300094626 |
| Student 2  | Mary Mousa #300110697  |


### Premièrement, on a compilé avec: javac -encoding UTF-8 --source-path src -d dist src/*.java 
### Ensuite, on a run avec: java -cp ./dist Main

![Screen Shot 2021-07-21 at 11 04 03 AM](https://user-images.githubusercontent.com/54963309/126512390-0e5b63bf-e4c6-437c-937b-abe36b803424.jpg)

### Par la suite, on a utilisé cette commande pour voir les erreurs détectés sur spotbugs:

![Screen Shot 2021-07-21 at 11 05 38 AM](https://user-images.githubusercontent.com/54963309/126512454-cf7f5789-9bef-4057-89fc-21a641e46a0e.jpg)


## Erreurs:

### 1- Comparison of String parameter using == or !=

Pour résoudre cette erreur, il faut remplacer ( s == "" ) par equals. Comme vous pouvez voir l'erreur est alors résolu.


### 2- Certain swing methods needs to be invoked in Swing thread
J'ai pas résolu cette erreur. Swing method isVisible() is not thread-safe in Java, so it might cause deadlock or some threading issues.


### 3- Could be refactored into a named static inner class

### 4- Boxing/unboxing to parse a primitive
Erreur:
num1 = Double.valueOf( input ).doubleValue();
num2 = Double.valueOf( input ).doubleValue();         
num3 = Double.valueOf( input ).doubleValue();         

Solution:
num1 = Double.parseDouble(input);
num2 = Double.parseDouble(input);
num3 = Double.parseDouble(input);


### 5- Boxing/unboxing to parse a primitive
Erreur:
answer = Double.valueOf(s).doubleValue();
Solution:

### 6 à 11 - Unread field: should this field be static?
Erreur:
 private final int   ADD=1,
Solution:
 private final static  int  ADD=1,
### 12- Method uses the same code for two branches
Solution:
Au lieu d'avoir le code réécris deux fois, l'écrire une seule fois après l'initialisation.
### 13 - Switch statement found where default case is missing
Solution:
Ajouter un default: après le dernier break;
### 14 à 16 - Condition has no effect
Erreur:
 if ( i <= 2 )
        getContentPane().add( buttons[i] );
    else if ( i >= 3 && i <= 7)
        getContentPane().add( buttons[i] );
    else if ( i >=8 && i <= 12 )
        getContentPane().add( buttons[i] );
    else if ( i >= 13 && i <= 17 )
        getContentPane().add( buttons[i] );
    else
        getContentPane().add( buttons[i] );

Solution:
Toute cette partie du code est inutile.
### 17- Condition has no effect
Erreur:
else if (morenums)
Solution:
else --- Faut enlever le if à l'intérieur du else.
