import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
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

        st = new StringTokenizer(br.readLine());
        int left = Integer.parseInt(st.nextToken());
        Stack<Integer> stk = new Stack<>();
        for (int i = 1; i < w; i++) {
            int curH = Integer.parseInt(st.nextToken());
            if (left > curH) {
                stk.push(curH);
            } else {
                while (!stk.isEmpty()) {
                    result += left - stk.pop();
                }
                left = curH;
            }
        }
        int right = 0;
        if (!stk.isEmpty()) {
            right = stk.pop();
        }
        while (!stk.isEmpty()) {
            int curH = stk.pop();
            if (curH < right) {
                result += Math.min(left, right) - curH;
            } else if (curH > right) {
                right = curH;
            }
        }

        bw.write(result + "\n");
        bw.flush();
    }
}
