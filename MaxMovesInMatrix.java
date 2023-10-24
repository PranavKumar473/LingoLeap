package lipoLeap;


	
	
import java.util.Scanner;

public class MaxMovesInMatrix {
    public static int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        int maxMoves = 0;

        for (int col = 1; col < n; col++) {
            for (int row = 0; row < m; row++) {
                dp[row][col] = 1;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) {
                            continue;
                        }
                        int newRow = row + i;
                        int newCol = col - 1;
                        if (newRow >= 0 && newRow < m && newCol >= 0) {
                            if (grid[newRow][newCol] < grid[row][col]) {
                                dp[row][col] = Math.max(dp[row][col], dp[newRow][newCol] + 1);
                            }
                        }
                    }
                }
                maxMoves = Math.max(maxMoves, dp[row][col]);
            }
        }

        return maxMoves;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows (m): ");
        int m = scanner.nextInt();
        System.out.print("Enter the number of columns (n): ");
        int n = scanner.nextInt();

        if (m < 2 || n < 2 || m > 1000 || n > 1000 || m * n < 4 || m * n > 105) {
            System.out.println("Invalid input. Please ensure that m and n meet the constraints.");
            return;
        }

        int[][] grid = new int[m][n];

        System.out.println("Enter the matrix elements row by row:");

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
                if (grid[i][j] < 1 || grid[i][j] > 106) {
                    System.out.println("Invalid input. Matrix elements should be between 1 and 106.");
                    return;
                }
            }
        }

        int result = maxMoves(grid);
        System.out.println("Maximum moves: " + result);

        scanner.close();
    }
}



