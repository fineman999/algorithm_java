package org.leetcode.snakes_and_ladders;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int snakesAndLadders(int[][] board) {

        int n = board.length;
        int[] nBoard = setNBoard(board, n);

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        q.add(1);
        visited[1] = true;

        return run(q, nBoard, visited, n);
    }

    private int run(Queue<Integer> q, int[] nBoard, boolean[] visited, int n) {
        int steps = 0;
        while(!q.isEmpty()){
            steps++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int square = q.poll();
                for(int j = 1; j <= 6; j++) {
                    int next_square = square + j;
                    if (nBoard[next_square] != -1) next_square = nBoard[next_square];
                    if (visited[next_square]) continue;

                    if (next_square == n * n) return steps;
                    visited[next_square] = true;
                    q.offer(next_square);
                }
            }
        }
        return -1;
    }

    private int[] setNBoard(int[][] board, int n) {
        int[] nBoard = new int[n * n + 1];
        int cnt = 1;
        boolean isEven = true;
        for(int i = n - 1; i >= 0; i--) {
            if (isEven) {
                for(int j = 0; j < n; j++) nBoard[cnt++] = board[i][j];
            }else {
                for(int j = n - 1; j >= 0; j--) nBoard[cnt++] = board[i][j];
            }
            isEven = !isEven;
        }

        return nBoard;
    }
}
