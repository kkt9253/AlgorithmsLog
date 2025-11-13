import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n, m;
    static int[] d = new int[104];
    // 초, 움직임 횟수, 현재 위치
    static int[][][] dp = new int[104][34][2];

    static int min = (int)-1e9;

    public static void main(String[] args) throws IOException {

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < 104; i++) {
            for (int j = 0; j < 34; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        dp[0][0][0] = 0;
        dp[0][1][1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k < 2; k++) {
                    int stay = dp[i - 1][j][k];
                    int move = (j > 0 ? dp[i-1][j-1][k^1] : min);
                    dp[i][j][k] = Math.max(stay, move) + (d[i-1]-1 == k ? 1 : 0);
                }
            }
        }

        int val = -1;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < 2; j++) {
                val = Math.max(val, dp[n][i][j]);
            }
        }
        bw.write(String.valueOf(val));

        br.close();
        bw.flush();
        bw.close();
    }
}
