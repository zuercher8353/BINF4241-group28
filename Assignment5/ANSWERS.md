#Assignment 5

##Task1
no bugs were found in Task 1


##Task2
#####GameBoardTest:
4 Tests fail: 

markTwice and markOnBoard fail because the method mark() in
the class GameBoard returns true when the field at the coordinates (input)
is already occupied by a player. Switched lines
71 and 74.

getOpenPositions and getOpenPositionsAll fail because
the method getOpenPositions() should iterate through
all columns but the for loop starts at col = 1 and therefore
skips the first column (indexes of the columns are 0,1,2).
Changing col = 1 to col = 0 in line 99 fixes the code. 

#####TicTacToeGameStateTest:
7 Tests fail:

getAvailableStatesLastOne

startingPlayerIsX and switchPlayer fail because the method
getCurrentPlayer() in the class TicTacToeGameState sets the 
current player always to O which then returns O.
Changed the method such that it only return the current player
without setting it to O first.

isOverWin, hasWinCol and hasWinRow fail because the method
hasWin() in the class TicTacToeGameState returns false if the row
or the column are complete.
Changed return to true in that case.

hasWinDiagonal fails because the return statement in the method completesDiagonal()
is (board.getMark(0, 0) == center && center == board.getMark(1, 2))
|| (board.getMark(0, 2) == center && center == board.getMark(2, 0));
board.getMark(1,2) is not in the diagonal. Changing it to getMark(2,2) fixes
the code.