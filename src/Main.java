import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        PriorityQueue<Double> pq = new PriorityQueue<>((x, y) -> (int) (y - x));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            double a = Double.parseDouble(br.readLine());
            if (pq.size() == 5) {
                pq.offer(a);
                pq.poll();
            } else {
                pq.offer(a);
            }
        }
        ArrayList<Double> arr = new ArrayList<>(pq);
        arr.sort(Comparator.naturalOrder());
        for (Double v : arr) {
            bw.write(v + "\n");
        }
        bw.close();
    }
}

/*
8
95.6
74.3
88.2
53.1
92.7
67.9
88.2
45.5
 */