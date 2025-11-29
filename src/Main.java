import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Line {
        int start, end;

        public Line(int a, int b) {
            start = a;
            end = b;
        }
    }
    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lines.add(new Line(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()
                    )));
        }
        lines.sort(Comparator.comparingInt(x -> x.start));

        int result = 0;
        int curL = lines.get(0).start;
        int curR = lines.get(0).end;
        for (int i = 1; i < n; i++) {
            int nextL = lines.get(i).start;
            int nextR = lines.get(i).end;

            if (curR >= nextL) {
                if (curR < nextR) {
                    curR = nextR;
                }
            } else {
                result += curR - curL;
                curL = nextL;
                curR = nextR;
            }
        }
        result += curR - curL;
        bw.write(result + "\n");
        bw.close();
    }
}

/*
5
0 2
1 5
3 7
8 10
6 9
 */