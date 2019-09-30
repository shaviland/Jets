## JETS Application

### Week Three Weekend Homework

### Overview

The program has an AirFiled class that holds a fleet of jets that's read from jets.txt.

User is prompted select from the following menu:

************* Menu *************
1. List fleet
2. Fly all jets
3. View fastest jet
4. View jet with longest range
5. Load all Cargo Jets
6. Dogfight!
7. Add a jet to Fleet
8. Remove a jet from Fleet
9. Quit

List fleet: lists all jets in the AirFiled prints out the model, speed, range, and price of each jet. (There must be at least 5 jets stored when the program starts).

Fly all jets: calls the fly() method on the entire fleet of jets. fly() prints out the jet details and the amount of time the jet can fly until it runs out of fuel (based on speed and range).

View Fastest Jet and View Jet with longest range: The view fastest jet and longest range options both print out all of the information about a jet.

Load All Cargo Jets and Dogfight!: calls the loadCargo() and fight() methods respectively depending on if the plane is
a cargo plane or fighter jet.

Add a jet to the Fleet: prompts the user to add plane details and adds the plane to the list.

Remove a jet from Fleet: prompts the user to select a jet to remove from the list.

quit: exits the program and updates jets.txt.

###Technologies/ Topics applied

Abstract Class and inheritance for all of the similar Jet traits
Array List to store the jets
IO streams to read and write data to files in binary and text formats.
For Each loop to cycle through the fleet to call certain methods
Interfaces to add abstract methods to certain classes of JETS

### Lessons Learned
using IO streams to read and then write txt files are very particular in regards to format. If there is an extra space or character out of place then it doesn't read back in correctly.

In order to create a buildable list of jets, I had to instantiate a new copy of the list and then add the new jet to that list.

Calling class specific methods, I had to use a for each loop to cycle through the fleet until there was a match for the method.
