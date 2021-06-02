Lab 3

| Outline | Value |
| ------------- | ------------- |
| Course  | SEG 3503  |
| Date  | Summer 2021 |
| Professor  | Andrew Forward, aforward@uottawa.ca  |
| Student 1  | Mahdi Chiboub #300094626 |
| Student 2  | Mary Mousa #300110697  |



Question 1

Pour executer jacoco, on a fait la commande: ./bin/run
Avant d'ajouter des tests, c'était ceci les résultats de départs.
![image](https://user-images.githubusercontent.com/54963309/120418728-0e8e0600-c32f-11eb-9c38-8d70c57b6eca.png)


Après des ajouts dans les tests, soit:

1- Ajout de tests pour vérification de la méthode toString, alors on a écris une date et on a vérifié si c'est le bon output qui va sortir en String.

2- Ajout de tests pour setMonth() mais en février il n'y a pas plus que 28 jours dans les années non leap alors il fallait que ca soit le premier mars mais ce test n'a pas passé, ce qui cause que il y a missed branch dans les résultats finaux.

3- LeapYear(), on choisit annee divisible par 400.

4- isThirtyDayMonth manquait le mois de seotembre qui est 30 jours.

5- On a aussi ajouté des tests dans la méthode equals pour tester si ce n'est pas la même date, ou pas même mois ou pas même année.

6- On verifie avec des mauvaises entrées que la réponse est fausse si on entre un jour plus que 30, plus que 29 en février et plus que 30 pour les mois moins que 31.

![image](https://user-images.githubusercontent.com/54963309/120419729-fe772600-c330-11eb-8269-e90a9082dae3.png)
