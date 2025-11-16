import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n, m, r;
    static int[][] arr = new int[304][304];

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            solve();
        }

        for (int k = 0; k < n; k++) {
            for (int j = 0; j < m; j++) {
                System.out.print(arr[k][j] + " ");
            }
            System.out.println();
        }
    }

    static void solve() {
        int[][] temp = new int[n+4][m+4];
        for (int i = 0; i < Math.min(n, m) / 2; i++) {

            // down
            for (int j = i; j < n-i-1; j++) {
                temp[j+1][i] = arr[j][i];
            }

            // right
            for (int j = i; j < m - i - 1; j++) {
                temp[n-i-1][j+1] = arr[n-i-1][j];
            }

            // left
            for (int j = n-i-1; j > i; j--) {
                temp[j-1][m-i-1] = arr[j][m-i-1];
            }

            // up
            for (int j = m - i - 1; j > i; j--) {
                temp[i][j - 1] = arr[i][j];
            }
        }
        // copy
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = temp[i][j];
            }
        }
    }
}
