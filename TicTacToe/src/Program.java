import java.lang.Math;
import java.util.Scanner;


// **IMPORTANT NOTE**: If console dimensions are changed, then the console text may not
// be formatted properly. For the best experience, please maximize the width of the console.


public class Program {
  public static void main(String[] args) {
    // TODO: Fix formatting of printBoard's output for boards with length greater than 3
    // TODO: Once someone has won, show the players how the player won (block out the slots that made a player won using the "☀️" character)
    // TODO: Welcome the users with their names and call them by their names instead of "player 1" and "player 2"
    // TODO: Use servers to create games and match players based on ip (? not sure how to do this yet)
    // TODO: Implement GUI
    // TODO: Allow user to choose what symbol they want to use in the game
    // TODO: Create option to view instructions on how to play tic tac toe and use this program
    System.out.println("**IMPORTANT NOTE**: If the console's dimensions are changed, then the "
    		         + "game may not be formatted properly. For the best experience, please maximize "
    		         + "the width of the console. Thank you and enjoy!");
    System.out.println("Check out the project on Repl.it at: https://replit.com/@NehaMetlapalli/Tic-Tac-Toe#Main.java");
    System.out.println("\n------------------------------------------------------\n");
    System.out.println("Welcome to tic tac toe. ❌ plays first, and ⭕️ plays second. "
    				 + "May the best player win, and good luck!");
    Scanner scan = new Scanner(System.in);
    System.out.print("\nPlease enter the length of the tic tac toe board to begin: ");
    int length = scan.nextInt();
    if (length < 3) {
      System.out.println("\nError: length is less than minimum length of 3. Defaulting length of "
      				   + "the tic tac toe board to 3...");
      length = 3;
    }
    TicTacToe board = new TicTacToe(length);
    board.printBoard();
    int turn = 0;
    int iterations = 1;
    String symbol;
    while(!board.isGameOver() && iterations <= Math.pow(length, 2)) {
      turn %= 2;
      if (turn == 0) {
        symbol = "❌";
      } else {
        symbol = "⭕️";
      }
      System.out.print("Player " + (turn + 1) + "'s turn.\nEnter a slot number to place " + symbol + " in: ");
      int slot = scan.nextInt();
      int invalidSlot = 0;
      while (board.getSlot(slot) != null) {
        invalidSlot++;
        System.out.print("Error: slot already used. Please enter a new slot number to place " + symbol + " in: ");
        slot = scan.nextInt();
      }
      if (invalidSlot > 0) {
        System.out.print("\033[" + (invalidSlot) + "A");
      }
      board.setSlot(slot, turn);
      System.out.print("\033[" + (4 + length * 2 - 1) + "A\r\033[J");
      board.printBoard();
      turn++;
      iterations++;
    }
    if (board.isGameOver()) {
      System.out.println("Player " + turn + " won.");
    } else {
      System.out.println("Draw - neither player won.");
    }
    System.out.println("GAME OVER");
  }
}