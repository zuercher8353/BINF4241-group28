#Assignment 5

##Task1
no bugs were found in Task 1


##Task2
###GameBoardTest:
4 Tests failed: 

####markTwice

This test checks if a mark can be set at a given position. If the board at that position is empty
a new mark should be set and true should be returned. Otherwise (if board at that position is occupied)
false should be returned and we can't set a mark.

The method mark() in the class GameBoard should return true if a mark can be set at a given position and 
false otherwise.
Switched lines 71 and 74.
 
####markOnBoard 

This test checks if a mark could be set on the board. 

The test failed because marks couldn't be at the beginning. Fixing the test markTwice also
fixed this test. (Switched lines 71 and 74 in mark().)

####getOpenPositions

This test sets a mark at position 0,0 and adds all empty fields to a list. After that it checks if the
method getOpenPositions() returns the same list. 

The method getOpenPositions() should iterate through all columns but the for loop starts at col = 1 
and it therefore skips the first column (indexes of the columns are 0,1,2).
Changing col = 1 to col = 0 in line 99 fixes the code. 

####getOpenPositionsAll

This test adds all fields of the board into a list (there is no mark set). After that it checks if the 
method getOpenPositions() returns the same list. 

Same problem as in getOpenPositions. Changing col = 1 to col = 0 in line 99 in getOpenPositions()
fixed the code. 

###TicTacToeGameStateTest:
7 Tests failed:

###startingPlayerIsX  

This test checks if the starting player has the mark "X". 

When first calling the method getCurrentPlayer() it should return "X". Instead of just returning the
current player it also always set it to "O".
Deleting lines 82 and 83 fixed the problem.

###switchPlayer

This test checks if switching the player works. It failed because getCurrentPlayer() always returned
"O". 
Deleting lines 82 and 83 in getCurrentPlayer() fixed the problem.

###hasWinCol

This test checks if the marks in a column are the same so that the player can win. 

It failed because the method hasWin() returned "false" instead of "true" when a column was complete.
Changing "false" to "true" in line 103 fixed the code.

###hasWinRow

This test checks if the marks in a row are the same so that the player can win. 

It failed because the method hasWin() returned "false" instead of "true" when a row was complete.
Changing "false" to "true" in line 103 fixed the code.

###isOverWin

This test calls the isOver() method which calls the hasWin() method to check if either one of the 
players has won. 

Fixing the problem in hasWinCol or hasWinRow fixes also this one.

###hasWinDiagonal

This test checks if a player can win by setting marks in the diagonal. 

It failed because the method completesDiagonal() checks the wrong fields. After getting the mark 
from the center of the board it should check if the fields in the edges of the board have the same 
mark. But the method checked the field 1,2 (which is not in a diagonal) instead of the field 2,2.
Changing board.getMark(1,2) in line 158 to board.getMark(2,2) fixes the problem.

###getAvailableStatesLastOne

