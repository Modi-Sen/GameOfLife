

import java.util.*;
import java.util.stream.LongStream;

public class GameOfLife {

    public int[][] process(int[][] input, long maxValue) {
        /*
        int M = 5, N = 5;

        // Initializing the grid.
        int[][] grid = {
                { 0, 0, 0, 0 ,0},
                { 0, 0, 0, 0, 0},
                { 0, 1, 1, 1, 0},
                { 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0}
        };
         */
        long[] row = LongStream.rangeClosed(0, maxValue).toArray();
        int M = row.length;
        long[] col = LongStream.rangeClosed(0, maxValue).toArray();
        int N = col.length;
        long[][] grid = new long[M][N];

        // set the value
        /*
        {1, 2}, input[0][0] = 1, input[0][1] = 2
        {2, 2}, input[1][0] = 2, input[1][1] = 2
        {3, 2}  input[2][0], input[2][1] = 2 */
        // grid[1][2] = 1
        for (int i = 0; i <= input[0].length; i++) {
            grid[input[i][1]][input[i][0]] = 1;
        }

//        System.out.println("Original Generation");
        System.out.println("Input");
        displayTheGrid(input);
        return nextGeneration(grid, M, N);
    }

    private void displayTheGrid(int[][] grid) {
        // Displaying the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Function to print next generation
    private int[][] nextGeneration(long grid[][], int M, int N) {
        long[][] future = new long[M][N];
        List<String> outputStr = new LinkedList<>();

        // Loop through every cell
        for (int l = 0; l < M; l++) {
            for (int m = 0; m < N; m++) {
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        if ((l + i >= 0 && l + i < M) && (m + j >= 0 && m + j < N))
                            aliveNeighbours += grid[l + i][m + j];

                // The cell needs to be subtracted from
                // its neighbours as it was counted before
                aliveNeighbours -= grid[l][m];

                // Implementing the Rules of Life

                // Cell is lonely and dies
                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;

                    // Cell dies due to over population
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;

                    // A new cell is born
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3)) {
                    future[l][m] = 1;
                    outputStr.add(m + "," + l);
                }

                // Remains the same
                else {
                    future[l][m] = grid[l][m];
                    if (future[l][m] == 1) {
                        outputStr.add(m + "," + l);
                    }
                }
                // System.out.println("Next Generation");
            }
        }
        System.out.println("Output");
        int [][] outputParse = outputStr
                .stream()
                .map(ele -> Arrays.stream(ele.split(",")).mapToInt(Integer::parseInt).toArray())
                .toArray(int[][]::new);
        displayTheGrid(outputParse);
        return outputParse;
    }
}