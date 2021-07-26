public class TicTacToe {
  private String[][] rows;
  private int[] rowX, rowO, colX, colO;
  private int length;

  // Default constructor
  public TicTacToe() {
    this(3);
  }

  // Constructor: create TicTacToe object with side length of length
  public TicTacToe(int length) {
    this.length = length;
    rows = new String[length][length];
    rowX = new int[length];
    rowO = new int[length];
    colX = new int[length];
    colO = new int[length];
  }

  // Set a specific slot to match a player's move
  public void setSlot(int slot, int player) {
    if (player == 0) {
      // Player 1 uses "X"
      rows[(slot - 1) / length][(slot - 1) % length] = "❌";
      rowX[(slot - 1) / length]++;
      colX[(slot - 1) % length]++;
    } else { // player == 1
      // Player 2 uses "O"
      rows[(slot - 1) / length][(slot - 1) % length] = "⭕️";
      rowO[(slot - 1) / length]++;
      colO[(slot - 1) % length]++;
    }
  }

  // Get the character at a specific slot
  public String getSlot(int slot) {
    return rows[(slot - 1) / length][(slot - 1) % length];
  }

  // Print the board to the console
  public void printBoard() {
    System.out.println();
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        if (rows[i][j] == null) {
          System.out.print(" " + (length * i + j + 1) + " ");
        } else {
          System.out.print(rows[i][j] + " ");
        }
        if (j < length - 1) {
          System.out.print("|");
        }
      }
      if (i < length - 1) {
        System.out.print("\n");
        for (int j = 0; j < length; j++) {
          System.out.print("---");
          if (j < length - 1) {
            System.out.print("+");
          }
        }
        System.out.print("\n");
      }
    }
    System.out.println("\n");
  }

  // Check if any of the players have won yet
  public boolean isGameOver() {
    int leftDiag = 1;
    int rightDiag = 1;
    for (int i = 0; i < length; i++) {
      // Check horizontal and vertical
      if (rowX[i] == length || rowO[i] == length || colX[i] == length || colO[i] == length) {
        return true;
      }
    }
    // Check diagonal
    for (int i = 0; i < length - 1; i++) {
      if (rows[i][i] != null && rows[i][i] == rows[i + 1][i + 1]) {
        leftDiag++;
      }
      if (rows[i][length - 1 - i] != null && rows[i][length - 1 - i] == rows[i + 1][length - 2 - i]) {
        rightDiag++;
      }
    }
    if (leftDiag == length || rightDiag == length) {
      return true;
    }
    return false;
  }

  public int getLength() {
    return length;
  }
}