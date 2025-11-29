import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10004];
        int min = 10004;
        for (int i = 0; i < n; i++) {
            int a = (int) Math.round((Double.parseDouble(br.readLine())) * 100);
            if (min > a) min = a;
            arr[a]++;
        }
        int cnt = 0;
        for (int i = min; cnt < 5; i++) {
            while (arr[i] != 0) {
                cnt++;
                arr[i]--;
                System.out.println(i / 100 + "." + (i % 100 < 10 ? "0"+ i % 100 : i % 100 / 10));
                if (cnt >= 5) break;
            }
        }
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