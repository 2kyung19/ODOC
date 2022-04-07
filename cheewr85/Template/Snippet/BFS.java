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
        bfs(v);
    }


    // 너비 우선 탐색 방식
    public static void bfs(int v) {
        // 인접한 노드를 체크하기 위한 큐 선언
        Queue<Integer> que = new LinkedList<Integer>();

        // 해당 정점에 대해 queue에다가 넣음
        que.add(v);
        // 해당 정점은 큐에 넣은 것은 방문한 것이므로 visit에 true를 주고 출력을 바로 함
        visit[v] = true;
        System.out.print(v + " ");

        // 인접한 노드가 없을 때까지 큐를 탐색함
        while(!que.isEmpty()) {

            // 큐에 맨 위의 값을 temp에 저장
            int temp = que.peek();
            // 해당 값을 탐색할 것이므로 poll로 꺼냄
            que.poll();
            // 해당 temp 노드 기준으로 인접 노드 탐색 시작
            // 인접노드를 큐에 넣고 탐색하는 것이므로 시작 노드만 들어갔다면 인접 행렬의 길이만큼 반복해서 BFS 탐색 계속함
            for(int i = 1; i < arr.length; i++) {
                // 인접한 노드가 있는 것과 아직 방문하지 않았다면
                // 이미 한 번 제대로 BFS 탐색을 하면 반복문은 계속 되지만 visit 함수는 true 처리되어 있어서 반복문만 돌고 if문에 조건이 맞지 않을 것임
                if(arr[temp][i] == 1 && visit[i] == false) {
                    // 인접 노드 저장하는 큐에 넣고 방문 체크를 하고 출력함
                    que.add(i);
                    visit[i] = true;
                    System.out.print(i + " ");
                }
            }
            // 위의 방식을 큐에 노드가 없을 때까지 반복하면서 탐색을 함
        }
    }

}