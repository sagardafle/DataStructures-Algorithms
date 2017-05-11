/**
 * Given nxn board place n queen on this board so that they dont attack each other. One solution is to find
 * any placement of queens which do not attack each other.
 * 
 * columnsarr.length == GRID SIZE
 * columnsarr[r] = c says that row r has a queen at column c. 
 */ 
import java.util.ArrayList;

public class NQueensProblem {
    public static int GRID_SIZE = 4;


    public static void placeQueens(int row, Integer[] columnsarr, ArrayList < Integer[] > results) {
        if (row == GRID_SIZE) { // Found valid placement
            results.add(columnsarr.clone());
        } else {
            for (int queen = 0; queen < GRID_SIZE; queen++) {
                if (checkValid(columnsarr, row, queen)) {
                    System.out.println("Placing Queen at row: "+row+ " and column: "+row);
                    columnsarr[row] = queen; // Place queen at this row
                    placeQueens(row + 1, columnsarr, results); //Proceed to further row.
                }
            }
        }
    }
    
    
    /* Check if (row1, column1) is a valid spot for a queen by checking if there
     * is a queen in the same column or diagonal. We don't need to check it for queens
     * in the same row because the calling placeQueen only attempts to place one queen at
     * a time. We know this row is empty. 
     */
    public static boolean checkValid(Integer[] columnsarr, int row1, int column1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int column2 = columnsarr[row2];
            
            /* Check if (row2, column2) invalidates (row1, column1) as a queen spot.
               Two cases for this*/

            /* Case-1: Check if rows have a queen in the same column */
            if (column1 == column2) {
                return false;
            }

            /* Case-2: Check diagonals: if the distance between the columnsarr equals the distance
             * between the rows, then they’re in the same diagonal. */
            int columnDistance = Math.abs(column2 - column1);
            int rowDistance = row1 - row2; // row1 > row2, so no need to use absolute value
            if (columnDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }
    
     public static void main(String[] args) {
        ArrayList < Integer[] > results = new ArrayList < Integer[] > ();
        Integer[] columnsarr = new Integer[GRID_SIZE];
        clear(columnsarr);
        placeQueens(0, columnsarr, results);
        printBoards(results);
        System.out.println(results.size());
    }

    public static void clear(Integer[] columnsarr) {
        for (int i = 0; i < GRID_SIZE; i++) {
            columnsarr[i] = -1;
        }
    }

    public static void printBoard(Integer[] columnsarr) {
        drawLine();
        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < GRID_SIZE; j++) {
                if (columnsarr[i] == j) {
                    System.out.print("Q|");
                } else {
                    System.out.print(" |");
                }
            }
            System.out.print("\n");
            drawLine();
        }
        System.out.println("");
    }

    private static void drawLine() {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < GRID_SIZE * 2 + 1; i++)
            line.append('-');
        System.out.println(line.toString());
    }



    public static void printBoards(ArrayList < Integer[] > boards) {
        for (int i = 0; i < boards.size(); i++) {
            Integer[] board = boards.get(i);
            printBoard(board);
        }
    }

   
}