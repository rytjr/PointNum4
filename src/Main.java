import java.net.Inet4Address;
import java.nio.Buffer;
import java.util.*;
import java.io.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int N1, N2, N3;
    static int[] list;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
    static int count = 1;

    public static void main(String[] args) throws IOException{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N1 = Integer.parseInt(st.nextToken());
        N2 = Integer.parseInt(st.nextToken());
        N3 = Integer.parseInt(st.nextToken());

        list = new int[N1 + 1];

        for(int i = 0; i <= N1; i++) {
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < N2; i++) {
            st = new StringTokenizer(bf.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            arr.get(n1).add(n2);
            arr.get(n2).add(n1);
        }

        for(int i = 1; i <= N1; i++) {
            Collections.sort(arr.get(i), Collections.reverseOrder());
        }

        bfs(N3);

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <N1 + 1; i++) {
            sb.append(list[i]).append("\n");
        }
        System.out.print(sb);

    }

    public static void bfs(int start) {

        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        list[start] = count;

        while(!que.isEmpty()) {
            int num = que.poll();
            for(int i = 0; i < arr.get(num).size(); i++) {
                if(list[arr.get(num).get(i)] == 0) {
                    list[arr.get(num).get(i)] = ++count;
                    que.offer(arr.get(num).get(i));
                }
            }
        }
    }

}