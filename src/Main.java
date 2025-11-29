import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        arr.sort(Comparator.naturalOrder());
        int x = Integer.parseInt(br.readLine());

        int result = 0;
        int p1 = 0; int p2 = n-1;
        while (p1 < p2) {
            int sum = arr.get(p1) + arr.get(p2);
            if (sum == x) {
                result++;
                p1++; p2--;
            } else if (sum < x) {
                p1++;
            } else {
                p2--;
            }
        }

        bw.write(result + "\n");
        bw.close();
    }
}

/*
8
1 9 2 8 4 7 3 6
10
 */