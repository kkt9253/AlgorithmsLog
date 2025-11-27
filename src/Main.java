import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

    static class Thing implements Comparable<Thing> {
        int m, v;
        Thing(int s, int e) {
            this.m = s;
            this.v = e;
        }

        @Override
        public int compareTo(Thing o) {
            return Integer.compare(this.v, o.v);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Thing> things = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            things.add(new Thing(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        things.sort(Comparator.naturalOrder());

        ArrayList<Integer> bags = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }
        bags.sort(Comparator.naturalOrder());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;
        int idx = 0;
        for (int i = 0; i < bags.size(); i++) {
            while (idx < n && things.get(idx).m <= bags.get(i)) {
                pq.offer(things.get(idx).v);
                idx++;
            }
            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        bw.write(result + "\n");
        bw.close();
    }
}

