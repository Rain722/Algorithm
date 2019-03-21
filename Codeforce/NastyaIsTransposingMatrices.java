import java.util.Arrays;
import java.util.Scanner;

public class NastyaIsTransposingMatrices {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n=cin.nextInt(), m=cin.nextInt();
        Pair[][] a = new Pair[2][n*m];
        for (int i=0; i<2; i++) {
            for (int r=0; r<n; r++) {
                for (int c=0; c<m; c++) {
                    a[i][r*m+c]=new Pair(r+c, cin.nextInt());
            }
          }
        }
        for (Pair[] pairs:a) {
            Arrays.sort(pairs);
        }
        for (int i=0; i<n*m; i++) {
            if (a[0][i].first != a[1][i].first || a[0][i].second != a[1][i].second) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    private static class Pair implements Comparable<Pair> {
        int first, second;

        public Pair(int first, int second) {
            this.first=first;
            this.second=second;
        }
        @Override
        public int compareTo(Pair o) {
            return first == o.first ? second-o.second : first-o.first; 
        }
    }
}