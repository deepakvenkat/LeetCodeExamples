package com.company;

public class Grid {
    public void markVisitedIsland(char[][] grid,int row,int col) {
        if (row < 0 || col < 0) {
            return;
        }
        if (row >= grid.length || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        markVisitedIsland(grid, row + 1, col);
        markVisitedIsland(grid, row - 1, col);
        markVisitedIsland(grid, row, col + 1);
        markVisitedIsland(grid, row, col - 1);
    }
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    result +=1;
                    markVisitedIsland(grid, i, j);
                }
            }
        }
        return result;
    }
}
