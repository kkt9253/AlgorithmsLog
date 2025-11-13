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
    // 초, 움직임 횟수, 현재 위치
    static int[] d = new int[104];
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

        bw.write(String.valueOf(solve(0, 0, 0)));

        br.close();
        bw.flush();
        bw.close();
    }

    static int solve(int second, int cnt, int position) {
        if (second >= n) {
            return 0;
        }
        if (dp[second][cnt][position] != -1) {
            return dp[second][cnt][position];
        }

        if (cnt < m) {
            return dp[second][cnt][position] = Math.max(solve(second+1, cnt, position), solve(second+1, cnt+1, position^1)) + (d[second]-1 == position ? 1 : 0);
        } else {
            return dp[second][cnt][position] = solve(second+1, cnt, position) + (d[second]-1 == position ? 1 : 0);
        }
    }
}