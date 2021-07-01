# Lab 5

| Outline | Value |
| ------------- | ------------- |
| Course  | SEG 3503  |
| Date  | Summer 2021 |
| Professor  | Andrew Forward, aforward@uottawa.ca  |
| Student 1  | Mahdi Chiboub #300094626 |
| Student 2  | Mary Mousa #300110697  |


# Partie 1

Premièrement, on a commencé par implémenter trois méthodes stab qui génére un grade aléatoirement, soit pourcentage_grade, letter_grade et numeric_grade. Voici l'implémentation.
![Screen Shot 2021-06-29 at 2 20 21 PM](https://user-images.githubusercontent.com/54963309/123848204-6fd0d700-d8e5-11eb-9247-b4c769d5ce9b.jpg)

Ensuite, lorsqu'on lance le serveur phoenix, on peut générer des notes aléatoirement. En voici un exemple.
![Screen Shot 2021-06-29 at 2 21 45 PM](https://user-images.githubusercontent.com/54963309/123848269-88d98800-d8e5-11eb-8c18-561ec8863914.jpg)


Ensuite, pour faire fonctionner le code comme prévu, on a ajouté le code de notre devoir 2 au lieu du code aléatoire, on a observé la page de Grade sur notre local host et on a remarqué que rien s'est produit lorsque on a entré des données, aucun résultat n'est apparu. Mais sur notre terminal, on a eu un erreur d'arithmétque qui explique pourquoi rien ne s'est produit.

![Screen Shot 2021-06-29 at 2 56 28 PM](https://user-images.githubusercontent.com/54963309/123852637-89285200-d8ea-11eb-8683-b8410eea3fec.jpg)



En effet, nous pouvons expliquer l'erreur de l'arithmétique qui est à cause que les nombres sont des chaînes plutôt que des entiers, ce qui cause cette erreur lorsqu'ils sont transmis aux méthodes de Grades.Calculator. Car la méthode de Grades.Calculator prend des entiers pour calculer le note finale.





# Partie 2
![image](https://user-images.githubusercontent.com/54963309/124068754-13ff6e80-da09-11eb-9225-a06040e8fad9.png)

Après l'implémentation des quatres tests:
![image](https://user-images.githubusercontent.com/54963309/124076540-65f9c180-da14-11eb-9a57-2e4de207984d.png)

Après la modification de la méthode isMentionned:
![Screen Shot 2021-07-01 at 2 19 52 AM](https://user-images.githubusercontent.com/54963309/124078850-5da28600-da16-11eb-8c21-831431ac5cf2.jpg)

