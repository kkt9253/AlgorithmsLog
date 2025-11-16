import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    static int h, w;
    static int result;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        int[] height = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        // left 최대 벽
        int[] left = new int[w];
        left[0] = height[0];
        for (int i = 1; i < w; i++) {
            left[i] = Math.max(height[i], left[i-1]);
        }

        // right 최대 벽
        int[] right = new int[w];
        right[w - 1] = height[w - 1];
        for (int i = w-2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }

        // left & right 벽 중 작은거로부터 가둬진 현재 블록의 빗물 깊이
        for (int i = 0; i < w; i++) {
            result += Math.min(left[i], right[i]) - height[i];
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
