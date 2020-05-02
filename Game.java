/**
Final Project: Tic Tac Toe
BY: Zack Beucler
Due: Dec. 2nd, 2019

Game.java

*/


import java.util.Random;
import java.util.Scanner;

public class Game{


	/**
		Constructor for the Game class
		@param player1Name => Name of player 1 as a string
		@param player2Name => Name of player 2 as a string
		@param gameBoard => 2d array that acts as a game board
		*/
	public Game(String player1Name, String player2Name, String[][] gameBoard){
		String player1 = player1Name;
		String player2 = player2Name;
		String[][] board = gameBoard;
	}


	/**
		playerSymbol Method
		@method playerSymbol => Asks the player what symbol (X or O) they want to play with. Returns the player's symbol when finished

		@param playerName => The current player's name as a string
		*/
	public String playerSymbol(String playerName){
		System.out.println(playerName + "\'s Turn");
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please Input Which Symbol you'd like (X or O)>> ");
		String playerSymbol1 = myScanner.nextLine();
		String playerSymbol = playerSymbol1.toUpperCase(); // convert everything to uppercase
		if (playerSymbol.equals("X")){
	        System.out.println("you choose: " + playerSymbol);
	        return playerSymbol;
		}
		else if(playerSymbol.equals("O")){
	        System.out.println("you choose: "+ playerSymbol);
	        return playerSymbol;
		}
		else{
			System.out.println("You have entered a wrong value: " + playerSymbol);
			System.out.println("Please try again");
			System.out.println(); // spacing
			playerSymbol(playerName);
		}
		return "None";
	}


	/**
		placePiece Method
		@method placePiece => Places the current player's piece in the specific position to the 2d array. Returns an updated array

		@param board => the 2d array being used in the game
		@param position => the place on the 2d array where the player wants to put their piece
		@param symbol => Current player's symbol
		*/
	public String[][] placePiece(String[][] board, String position, String symbol){
		if (position.equals("1")){
			board[0][0] = symbol;}
		else if (position.equals("2")){
			board[0][1] = symbol;}
		else if (position.equals("3")){
			board[0][2] = symbol;}
		else if (position.equals("4")){
			board[1][0] = symbol;}
		else if (position.equals("5")){
			board[1][1] = symbol;}
		else if (position.equals("6")){
			board[1][2] = symbol;}
		else if (position.equals("7")){
			board[2][0] = symbol;}
		else if (position.equals("8")){
			board[2][1] = symbol;}
		else if (position.equals("9")){
			board[2][2] = symbol;}

		return board;
	}


	/**
		checkMove Method
		@method checkMove => Check's if a player's move is valid. Return true if valid, false if invalid

		@param board => the 2d array being used in the game
		@param position => the place on the 2d array where the player wants to put their piece
		*/
	public boolean checkMove(String board[][], String position){
		if (position.equals("1")){
			if (board[0][0].equals("X") || board[0][0].equals("O")){
				return false;}
		}
		else if (position.equals("2")){
			if (board[0][1].equals("X") || board[0][1].equals("O")){
				return false;}
		}
		else if (position.equals("3")){
			if (board[0][2].equals("X") || board[0][2].equals("O")){
				return false;}
		}
		else if (position.equals("4")){
			if (board[1][0].equals("X") || board[1][0].equals("O")){
				return false;}
		}
		else if (position.equals("5")){
			if (board[1][1].equals("X") || board[1][1].equals("O")){
				return false;}
		}
		else if (position.equals("6")){
			if (board[1][2].equals("X") || board[1][2].equals("O")){
				return false;}
		}
		else if (position.equals("7")){
			if (board[2][0].equals("X") || board[2][0].equals("O")){
				return false;}
		}
		else if (position.equals("8")){
			if (board[2][1].equals("X") || board[2][1].equals("O")){
				return false;}
		}
		else if (position.equals("9")){
			if (board[2][2].equals("X") || board[2][2].equals("O")){
				return false;}
		}
		return true;// position open
	}


	/**
		continuePlay Method
		@method continuePlay => Asks the player if they want to play the game again. Returns true if yes, false if no
		*/
	public boolean continuePlay(){
		boolean choice = true;

		Scanner myScanner = new Scanner(System.in);
		System.out.println("Do you want to play Tic Tac Toe? (Yes / No)>> ");
		String playAgain1 = myScanner.nextLine();

		String playAgain = playAgain1.toUpperCase(); // convert everything to uppercase

		if (playAgain.equals("YES")){
			System.out.println("Lets Play!");
			choice = true;
		}
		else if (playAgain.equals("NO")){
			System.out.println("Thanks for playing!");
			choice = false; // quit the program

		}
		else{
			System.out.println("Incorrect statement entered. Please try again");
			System.out.println();
			continuePlay(); // recursive
		}
		return choice;
	}


	/**
		getPlayerMove Method
		@method getPlayerMove => Asks the player where they want to put their piece on the board

		@param board => the 2d array being used in the game
		*/
	public String getPlayerMove(String[][] board){
		Scanner myScanner = new Scanner(System.in);
		System.out.println("Please input where you want to place your piece [1-9]>> ");
		String position = myScanner.nextLine();

		Boolean validMove = checkMove(board, position); // check if the player's move is valid

		if (validMove == true){
			return position;}
		else{
			System.out.println("Your turn has been skipped."); // if move not valid, skip their turn
			getPlayerMove(board);}
		return "None";
	}


	/**
		gameEnded Method
		@method gameEnded => check if the board is full. Return true if board is full, False if board is not full

		@param board => the 2d array being used in the game
		*/
	public boolean gameEnded(String board[][]){
		for(int i=0; i<board.length; i++) {
		        for(int j=0; j<board[i].length; j++) {
					if (board[i][j].equals(" ")){
						return false; // there are still open spots on the board
					}
		        }
			}
		return true; // game has ended
	}


	/**
		randPickPlayer Method
		@method randPickPlayer => pick a random player to start the game. Returns the random player's name as a string

		@param player1Name => Name of player 1 as a string
		@param player2Name => Name of player 2 as a string
		*/
	public String randPickPlayer(String player1name, String player2Name){
		String player1 = player1name;
		String player2 = player2Name;
		Random r = new Random();
		//System.out.println(r.nextInt((2 - 1) + 1) + 1);
		if (r.nextInt((2 - 1) + 1) + 1 == 1){
			return player1;
		}
		return player2;
	}


	/**
		drawBoard Method
		@method drawBoard => draw the game board in the terminal / shell

		@param board => the 2d array being used in the game
		@param currentPlayer => the current player's name as a string
		*/
	public void drawBoard(String[][] board, String currentPlayer){
		clearScreen();
		if (!board[0][0].equals("1")){
			System.out.println("\t\t\t" + currentPlayer + "\'s turn");
		}
		System.out.println();
	    System.out.println("###################################################");
	    System.out.println("\t\t\t" + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
	    System.out.println("\t\t\t" + "----------");
	    System.out.println("\t\t\t" + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
	    System.out.println("\t\t\t" + "----------");
	    System.out.println("\t\t\t" + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
	    System.out.println("###################################################");
		System.out.println();
	}


	/**
		checkWinner Method
		@method checkWinner => Check the board to see if X or O has won the game

		@param board => the 2d array being used in the game
		*/
	public String checkWinner(String[][] board){
		// X horizontal
		if (board[0][0].equals("X") && board[0][1].equals("X") && board[0][2].equals("X")){
			return "X";}
		else if (board[1][0].equals("X") && board[1][1].equals("X") && board[1][2].equals("X")){
			return "X";}
		else if (board[2][0].equals("X") && board[2][1].equals("X") && board[2][2].equals("X")){
			return "X";}
		//X vertical
		else if (board[0][0].equals("X") && board[1][0].equals("X") && board[2][0].equals("X")){
			return "X";}
		else if (board[0][1].equals("X") && board[1][1].equals("X") && board[2][1].equals("X")){
			return "X";}
		else if (board[0][2].equals("X") && board[1][2].equals("X") && board[2][2].equals("X")){
			return "X";}
		// X cross
		else if (board[0][0].equals("X") && board[1][1].equals("X") && board[2][2].equals("X")){
			return "X";}
		else if (board[0][2].equals("X") && board[1][1].equals("X") && board[2][0].equals("X")){
			return "X";}
		////////////////////////////////////////////
		// O horizontal
		if (board[0][0].equals("O") && board[0][1].equals("O") && board[0][2].equals("O")){
			return "O";}
		else if (board[1][0].equals("O") && board[1][1].equals("O") && board[1][2].equals("O")){
			return "O";}
		else if (board[2][0].equals("O") && board[2][1].equals("O") && board[2][2].equals("O")){
			return "O";}
		// O vertical
		else if (board[0][0].equals("O") && board[1][0].equals("O") && board[2][0].equals("O")){
			return "O";}
		else if (board[0][1].equals("O") && board[1][1].equals("O") && board[2][1].equals("O")){
			return "O";}
		else if (board[0][2].equals("O") && board[1][2].equals("O") && board[2][2].equals("O")){
			return "O";}
		// O cross
		else if (board[0][0].equals("O") && board[1][1].equals("O") && board[2][2].equals("O")){
			return "O";}
		else if (board[0][2].equals("O") && board[1][1].equals("O") && board[2][0].equals("O")){
			return "O";}
	////////
	    else {
			return "None";} // nobody has won yet
	}


	//clears entire terminal screen
	/**
		taken from: https://stackoverflow.com/questions/2979383/java-clear-the-console

		clearScreen Method
		@method clearScreen => clears the terminal / shell. Sumilates inputting "clear" into the terminal
	*/
	public static void clearScreen() {
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	}

}
