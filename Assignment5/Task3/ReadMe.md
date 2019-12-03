##Task 3

####1 Identify how the system should behave: 

 The program should only accept input that are syntactically correct (syntactically not correct inputs should not be accepted by the program), the input must be of the following form:
 
 Inputs to set up game : 
 
 If the user gets asked for the number of players only inputs between 2 and 10 should be accepted. 
 Playernames should have a max length of 20 characters and only consist of letters from A-Z or special characters like ö,ä...
 The Score to win must be a integer number. 

 "Color" + "Card typ" e.g. Blue1 or BlackWild
 
 In case that a player plays his second last card he should add Uno to his input:
 
 "Color" + "Card typ" + "Uno" eg. RedSkipUno
 
 In case that the user can't play a card or don't want to play a card he can give the input "Draw"
  
 The accepted colors are : Green, Red, Blue, Yellow, Black 
 
 The accepted card types for all colors beside black are: 0,1,2,3,4,5,6,7,8,9, Draw2, Skip, Reverse.
 For the color black the accepted card types are: Wild and WildDraw4. 
 
 If a player wants to catch somebody that didn't shout Uno he can give the input "Uno" + "Player name" (e.g. UnoMarc) of the player 
 that didn't shout uno. This must happen before the next player has taken his turn. 
 
 The syntactic check happens in the the main class in the function ScanAndValidateInput(): , as long as the user doesn't give a 
 syntactically correct input he gets asked again to give an input by displaying the output: "The given input is symentically not correct."
 
 If the user has given an syntactically correct input, the input string gets precessed by the main function 
 checkSemanticalCorrect() for it's semantical correctness. 
 
 
 ##### Inputs that are only accepted during the game is running: 
 
 If one of the inputs in this section is given this things get checked and this actions performed:
 It gets checked if the game is running, for this the Game function
 gameRunning() gets called and if it returns true, the further checks of this section get performed.
 Else the Output "The game is not running" gets displayed, after that the user must give another input.
 
 If the input is a card that the user wants to play this things get checked and this actions performed:
 
 - Does the player have the (by the input) specified card in his hand.
   For this the Game function returnHandCardsActivPlayer() gets called.
   If the specified card is in the returned ArrayList the next check gets performed else
   the Output "Your don't have the card that you wanna play" gets displayed, after that the user
   must give another input. 
   
- Is it allowed to lay down this card according to the Unorules. For this the Game function
  playCardIfLegal(String) gets called which checks if playing the card is legal
  , if it is legal the card gets played and true gets returned. Else the function returns false
  and the Output "Your not allowed to play this card" gets displayed, after that the user
  must give another input. 
  
If the ending uno or the command Uno is given this things get checked and this actions performed:

  - It gets checked if the player has only one card by calling the Game function checkUNO() gets called to check
  if the player has only one card the same function is used to check if a player has forgot to say Uno.
  If the function returns falls an approproit output gets displayed.   
  
 If the input is draw this things get checked and this actions performed:
 
 The Game function drawCards("activePlayer") is called. 
 
 
##### Inputs that are only accepted during the game is not running: 
 
 This are the inputs number of players, playernames or Score to win. If one of this inputs is given the it gets checked if the game is 
 not running by for this the Game function gameRunning() gets called and if it return is false the main function calls the appropriat  Game function
 Game function. Else the output "The game is running, command not allowed" gets displayed.
 
 If the inputs are semantically or syntactically not corrected the program display an appropriat error message and the actions
 of the input want get performed. If the input is correct the main functions performes the actions specified by the input by using
 functions of the game class. 
 
 At the beginning of the Game the following outputs get displayed:
 
 - "Enter number of players" 
 - "Enter playerX name"
 - "Enter score to win"
 Before every turn the command: "playername it is your turn, specified the card that you want to play" gets displayed. 
 Further his hand cards get displayed in the format specified above. As soon as a player played all his card the message: "playername
 one this round gets displayed", if a player wins the whole game the output "playername wins the game" is displayed. 
 
 All the above listed Outputs are expected aswell as appropriat error messages. Any internal outputs that are not necessary for the user
 shouldn't be displayed. It shouldn't happen that the user doesn't receive any kind output
 (errormessage or new command what he has to do) at all. 
 
  
  
  
  

 
 
 
 
 
 
 
