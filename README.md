Lab 2

| Outline | Value |
| ------------- | ------------- |
| Course  | SEG 3503  |
| Date  | Summer 2021 |
| Professor  | Andrew Forward, aforward@uottawa.ca  |
| Team  | Mahdi Chiboub #300094626 & Mary Mousa #300110697  |



Question 1


| Cas de Test  | Résultats Escomptés |Résultats actuels | Verdict|
| ------------- | ------------- |------------- |------------- |
| 1  | demande d'inscription acceptée  |Congratulations !. You are now a member of our site..  |Pass  |
| 2  | demande d'inscription acceptée  |Wrong Email format  |Fail  |
| 3  |demande d'inscription acceptée  |Wrong FirstName format & Wrong LastName format  |Fail |
| 4  |demande d'inscription acceptée |Congratulations Bond James!. You are now a member of our site.. |Pass |
| 5  |Err1: Wrong UserName format |Size of UserName must be between 6 and 12, Wrong UserName format  |Fail |
| 6  | Err1: Wrong UserName format |Wrong UserName format, Size of UserName must be between 6 and 12, Wrong Email format   |Fail  |
| 7  | Err1: Wrong UserName format  |Size of UserName must be between 6 and 12, Wrong FirstName format, Wrong LastName format  |Fail  |
| 8  | Err1: Wrong UserName format  |Wrong UserName format |Pass  |


Question 2:

Pour compilation du programme:

javac -encoding UTF-8 --source-path src -d dist src/*.java

Pour compilation des tests:

javac -encoding UTF-8 --source-path test -d dist -cp dist:lib/junit-platform-console-standalone-1.7.1.jar test/*.java


Pour run les tests:

java -jar lib/junit-platform-console-standalone-1.7.1.jar --class-path dist --scan-class-path