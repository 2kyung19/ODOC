import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.*;

public class Main {

    public static int[][] arr;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 정점의 수, 간선의 수, 탐색을 시작할 정점 번호 입력받음
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 인접행렬을 체크위해 정점의 수대로 초기화
        arr = new int[n+1][n+1];

        for(int i = 1; i <= m; i++) {
            // 간선이 연결하는 두 정점 번호 입력받음(양방향 그래프인 경우)
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        // 방문 여부 체크하는 함수 초기화
        visit = new boolean[n+1];
        dfs(v);
    }

    // 깊이 우선 탐색 방식
    public static void dfs(int v) {
        // 방문된 점을 출력하므로 true로 변경 후 출력함
        visit[v] = true;
        System.out.print(v + " ");

        // 인접행렬 길이만큼 재귀를 했다면 탐색을 다 한 것이므로 해당 부분 탐색 종료함
        if(v == arr.length) {
            return;
        }

        // visit 배열에서 1~5의 정점에서 방문하지 않으면 false이므로 방문하지 않은 경우 dfs 탐색을 다시 함
        // 여기서 연결된 정점이 아니어도 지나가고 방문했어도 지나감, 결정적으로 해당 정점 번호 기준으로 연결된 것만 찾게끔 하게 되어있음
        for(int i = 1; i < arr.length; i++) {
            if(arr[v][i] == 1 && visit[i] == false) {
                dfs(i);
            }
        }
    }

}