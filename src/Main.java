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

        AllLayerRotation();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }

    static void AllLayerRotation() {
        for (int i = 0; i < Math.min(n, m) / 2; i++) {
            layerRotation(i);
        }
    }

    static void layerRotation(int layer) {
        int top = layer;
        int bottom = n - 1 - layer;
        int left = layer;
        int right = m - 1 - layer;
        int layerLen = 2*((bottom - top+1) + (right - left+1)) - 4;
        int[] line = new int[layerLen];

        // 1차원에 2차원 넣기
        // left col
        int idx = 0;
        for (int i = top; i < bottom; i++) {
            line[idx++] = arr[i][left];
        }
        // bottom row
        for (int i = left; i < right; i++) {
            line[idx++] = arr[bottom][i];
        }
        // right col
        for (int i = bottom; i > top; i--) {
            line[idx++] = arr[i][right];
        }
        // top row
        for (int i = right; i > left; i--) {
            line[idx++] = arr[top][i];
        }

        // 1차원 line에서 반시계로 당겨서 해당 인덱스의 값을 arr에 넣어주기
        idx = 0;
        int rot = r%layerLen;
        // left col
        for (int i = top; i < bottom; i++) {
            arr[i][left] = line[(idx++ - rot + layerLen) % layerLen];
        }
        // bottom row
        for (int i = left; i < right; i++) {
            arr[bottom][i] = line[(idx++ - rot + layerLen) % layerLen];
        }
        // right col
        for (int i = bottom; i > top; i--) {
            arr[i][right] = line[(idx++ - rot + layerLen) % layerLen];
        }
        // top row
        for (int i = right; i > left; i--) {
            arr[top][i] = line[(idx++ - rot + layerLen) % layerLen];
        }
    }
}
