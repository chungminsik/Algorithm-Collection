package algorithm.그래프와순회;

import java.util.*;

public class DFS와BFS {

    private static int rows;
    private static int cols;

    public static void main(String[] args) {

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numIsland(grid));
    }

    public static int numIsland(char[][] grid){
        rows = grid.length;
        cols = grid[0].length;
        int count = 0;

        //그리드를 차례로 탐색
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++; //dfs 재귀에 빠저나오면 섬하나를 찾은 것이다.
                }
            }
        }

        return count;
    }

    public static void dfs(char[][] grid, int i, int j){

        //좌표가 격자를 벗어나거나 현재 셀이 0일 경우 갈 곳 없음
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0'){
            return;
        }

        //현재 좌표를 0으로 물로 바꿔서 재방문 못하게 하기
        grid[i][j] = '0';

        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}

class NQueen{ }
