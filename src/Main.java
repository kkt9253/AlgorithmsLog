import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {

    static class Thing {
        int m, v;
        Thing(int s, int e) {
            this.m = s;
            this.v = e;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] visited = new boolean[300004];

    public static void main(String[] args) throws Exception {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Thing> things = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            things.add(new Thing(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        things.sort((x, y) -> x.v != y.v ? y.v - x.v : y.m - x.m);

        ArrayList<Integer> bags = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }
        bags.sort(Comparator.naturalOrder());

        int result = 0;
        for (int i = 0; i < bags.size(); i++) {
            for (int j = 0; j < things.size(); j++) {
                if (visited[j] || things.get(j).m > bags.get(i)) continue;
                visited[j] = true;
                result += things.get(j).v;
                break;
            }
        }

        bw.write(result + "\n");
        bw.close();
    }
}

