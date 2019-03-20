import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Matrix {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n, m;
        n=cin.nextInt();
        m=cin.nextInt();
        int matrix[][]= new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                matrix[i][j]=cin.nextInt();
            }
        }
        Solution slu=new Solution();
        int ans[][]=slu.updateMatrix(matrix);
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.printf("%d%c", matrix[i][j], j==(m-1)?'\n':' ');
            }
        }
    }
}

class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                    if(matrix[i][j]==0) {
                        queue.offer(new int[]{i, j});
                    } else {
                        matrix[i][j]=0x3f3f3f3f;
                    }
            }
        }
        int[][] dirs={{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()) {
            int now[]=queue.poll();
            int x=now[0], y=now[1];
            for(int[] nxt:dirs) {
                int nx=nxt[0]+x;
                int ny=nxt[1]+y;
                if(nx<0||nx>=n||ny<0||ny>=m||matrix[nx][ny]<(matrix[x][y]+1)) continue;
                matrix[nx][ny]=matrix[x][y]+1;
                queue.add(new int[]{nx, ny});
            }
        }
        return matrix;        
    }
}
