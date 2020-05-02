/**
Final Project: Tic Tac Toe
BY: Zack Beucler
Due: Dec. 2nd, 2019

Main.java

*/

import java.util.Scanner;

public class Main{
	public static void main(String[] args){

		System.out.println(); // spacing
		System.out.println(); // spacing

		System.out.println("\t\t\tTIC TAC TOE"); // Title

		// get player1 name
		System.out.println("Player 1");
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please Input your name>> ");
		String player1 = myScanner.nextLine();
		System.out.println();// spacing
		// get player2 name
		System.out.println("Player 2");
		System.out.println("Please Input your name>> ");
		String player2 = myScanner.nextLine();

		// a test board to show all the numeric value of the spots on the board
		String[][] tboard = {{"1", "2", "3"},
		                     {"4", "5", "6"},
		                     {"7", "8", "9"}};
		// the actual board for playing the game
		String[][] board = {{" ", " ", " "},
		                    {" ", " ", " "},
		                    {" ", " ", " "}};

		// create a new Game instace for the current game
		Game newGame = new Game(player1, player2, board);



		while (true){
			// if the user doesn't want to play
			if (!newGame.continuePlay()){
				System.exit(0); // terminate the program
			}
			else{

				// show the example board
				newGame.drawBoard(tboard,null);

				// get a random player to start the game
				String firstTurn = newGame.randPickPlayer(player1, player2);
				System.out.println(); // spacing
				if (firstTurn.equals(player1)){
					System.out.println("First turn randomly goes to>> " + player1 );
					System.out.println(); // spacing

				}
				else{
					System.out.println("First turn randomly goes to>> " + player2 );
					System.out.println(); // spacing

				}

				String firstMarker; // initalizing these variables to allow use outside of the loops
				String player2Symbol; // ^^
				String player1Symbol; // ^^

				// if player1 starts the game
				if (firstTurn.equals(player1)){
					// ask player1 what symbol they want
					player1Symbol = newGame.playerSymbol(player1);

					if (player1Symbol.equals("X")){
						firstMarker = "X"; // player1 is X
						player2Symbol = "O"; // player2 is O
					}
					else{
						firstMarker = "O"; // player1 is O
						player2Symbol = "X"; // player2 is X
					}
				}
				else{
					// ask player2 what symbol they want
					player2Symbol = newGame.playerSymbol(player2);

					if (player2Symbol.equals("X")){
						firstMarker = "X"; // player2 is X
						player1Symbol = "O"; // player1 is O
					}
					else{
						firstMarker = "O"; // player2 is O
						player1Symbol = "X"; // player1 is X
					}
				}
				System.out.println();// spacing
				System.out.println("Player1 symbol>> " + player1Symbol); // tell playerss what symbol they have
				System.out.println("Player2 symbol>> " + player2Symbol);
				System.out.println(); // spacing
			  System.out.println("First player to go: " + firstTurn + "\nFirst marker to go: " + firstMarker);
				System.out.println();

				String currentMarker = firstMarker; // first player's symbol/marker
				String currentPlayer = firstTurn; // first player's name


				while (true){
					// draw the board
					newGame.drawBoard(board, currentPlayer);

					// get the current player's move
			    String playerMove = newGame.getPlayerMove(board);
					newGame.placePiece(board, playerMove, currentMarker);

					if (newGame.gameEnded(board)){ // check if the board is full
						System.out.println("No more valid moves");
						newGame.drawBoard(board, currentPlayer);
						break;
					}

					// find if x or o won the game
			        String winningMarker = newGame.checkWinner(board);

					String winningPlayer;
					if (winningMarker.equals("None")){ // if nobody has won yet
						if(currentPlayer.equals(player1)){
							currentPlayer = player2; // switch turns
						}
						else{
							currentPlayer = player1; // switch turns
						}
						if(currentMarker.equals("X")){
							currentMarker = "O"; // change marker
						}
						else{
							currentMarker = "X"; // change marker
						}
					}
					else{ // if someone has won
						if(winningMarker.equals(currentMarker)){
							winningPlayer = currentPlayer; // current player has won
						}
						else{
							if(currentPlayer.equals(player1)){
								winningPlayer = player2; // player 2 has won
							}
							else{
								winningPlayer = player1; // player 1 has won
							}
						}
						newGame.drawBoard(board, winningPlayer); // print out board
						System.out.println(winningPlayer + " Won the Game! Congrats!!!");
						break; // end program
					}
				System.out.println(currentPlayer + " will place " + currentMarker + " next");
				}
			}
		}
	}
}
