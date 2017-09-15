# dominos_project1_cs351_mfaltas
1) How to use the program
The controller class instantiates a new game and that in turn instantiates the other classes. 
The conrtroller has the main class and controler the GUI elements.
The main menu has two buttons: The donate button and the start game button.
Once the game has started, the player selects a domino by clicking on one of the domino buttons and then clicks to place left or right.
The player can draw from the boneyard at their own discretion.
One could skip their turn if they have at least 7 dominos or if there are no dominos left in the boneyard.
The winning player is the one with no dominos in their hand.

2) A list of any testing and/or debugging tools in the project and now to use them.
The only debugging tools including are print out statements and they only utilize the command line. 
Comment them out to exclude them from running.

3)Who did what parts of the program and what parts (if any) are by a third party
I, Mina Faltas, did 100% of the project.

4)A list of known bugs.

Bug#1: The left side of the dominos on the board could be a little misplaced.
Bug#2: The left side could slightly change positions once a domino is placed on the right side.
Bug#3: The AI is not declared winner at all times. A problem exists with the AI's hand detection.
Bug#4: The dominos displayed on the board could go over the desired area for the board.
Bug#5: In case of maximizing the window to full screen, the dominos are not quite placed in the center and could get misaligned.
