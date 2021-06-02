# Lab 3

| Outline | Value |
| ------------- | ------------- |
| Course  | SEG 3503  |
| Date  | Summer 2021 |
| Professor  | Andrew Forward, aforward@uottawa.ca  |
| Student 1  | Mahdi Chiboub #300094626 |
| Student 2  | Mary Mousa #300110697  |



**Exercice 1**

Pour executer jacoco, on a fait la commande: ./bin/run
Avant d'ajouter des tests, c'était ceci les résultats de départs.
![image](https://user-images.githubusercontent.com/54963309/120418728-0e8e0600-c32f-11eb-9c38-8d70c57b6eca.png)


Après des ajouts dans les tests, soit:

1- Ajout de tests pour vérification de la méthode toString(), alors on a écris une date et on a vérifié si c'est le bon output qui va sortir en String.

2- Ajout de tests pour setMonth(), mais on n'atteint pas le coverage maximale puisque on peut pas avoir plus que 12 et moins que 1 en même lieu.

3- LeapYear(), on choisit annee divisible par 400.

4- isThirtyDayMonth() manquait le mois de seotembre qui est 30 jours.

5- On a aussi ajouté des tests dans la méthode equals() pour tester si ce n'est pas la même date, ou pas même mois ou pas même année.

6- On verifie avec des mauvaises entrées setDay() que la réponse est fausse si on entre un jour plus que 30, plus que 29 en février et plus que 30 pour les mois moins que 31.

7- EndOfMonth(), on a ajouté des tests, mais pas full covergae puisque en février il n'y a pas plus que 28 jours dans les années non leap alors il fallait que ca soit le premier mars mais ce test n'a pas passé, ce qui cause que il y a missed branch dans les résultats finaux.


<img src="https://user-images.githubusercontent.com/54963309/120503522-5fcee180-c391-11eb-950a-450f76486211.png"  width="700" height="600">
<img src="https://user-images.githubusercontent.com/54963309/120503639-79702900-c391-11eb-9c13-1ec872966383.png"  width="700" height="600">
<img src="https://user-images.githubusercontent.com/54963309/120419729-fe772600-c330-11eb-8269-e90a9082dae3.png"  width="700" height="600">


**Exercice 2**

Pour la réfactoration du code, on a modifié la méthode setDate(), en reduisant les exemptions, soit en jumellant deux exceptions enesmeble. Puisque on ne peut pas avoir un mois moins que 1 jour et plus que 31 jours. De la même manière, on a jumelé les leap year ensemble soit on ne peut pas avoir plus que 28 ou 29 jours pour le mois de fevrier.

![image](https://user-images.githubusercontent.com/54963309/120502548-850f2000-c390-11eb-9005-61e8927fa3fc.png)
 
Après la réfraction du code et l'ajout des tests, on obtient un très meilleur pourcentage, soit on est allé de 70 coverage jusqua 98 coverage.
![image](https://user-images.githubusercontent.com/54963309/120520725-23f04800-c3a2-11eb-9755-056ec40f9b76.png)


