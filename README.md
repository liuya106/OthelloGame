# OthelloGame
An othello game with simple UI and different opponent strategies to be chosen, written in Java.

-----------------------------------------------------------------------------------------------------
Before running this program, make sure:
right click on a project-> build path->configure build path-> source: make sure the standard build source for this projects is ./src. Apply this setting.

-----------------------------------------------------------------------------------------------------
If cant find javafx:
right click the project-> build path->configure build path->libraries section->add external JARs: add all javafx jar on your computer(all javafx jars was attached in OthelloGame)

THEN

right click the OthelloApplication in src/ca.utoronto.utm.othello.viewcontroller-> run as->run configuration->argument -> VM argument, type in:
--module-path  javafx-sdk-11.0.2/lib --add-modules=javafx.controls 
 modify the path to correct path to the lib of javafx on your computer

-----------------------------------------------------------------------------------------------------
run OthelloApplication as above configuration to run the program
Enjoy ur game!!
