Authors (alphabetical order):

£ukasz Birunt
Jaros³aw Ko³aczek
Stefan Turakiewicz



About the program:

We have written a small hair salon simulator. 5 threads simulating hairdressers
(named Irka, Mirka, Eliza, Andzela and Buazej) work there simultaneously cutting
customers' hair.
Class named ConsumerCreator adds new customers (with random name and hair length) to the
BlockingQueue until it reaches the hardcoded customers limit. Then the hairdressers
poll them and cut.
Actually before they start cutting, they welcome customers and perform a small talk
if they know them already (if customers name exists as a key in the ConcurrentHashMap
interactions database).
When the job is done, hairdressers go home and the hair salon is then closed.



How to run it:

1) Extract HairSalon.jar from the .zip package
2) Hold shift and click right mouse button in empty place in the folder where HairSalon.jar is
3) Choose 'Open command window here' from the context menu
4) Write 'java -cp HairSalon.jar hairSalon.Work' in the command window and click enter
