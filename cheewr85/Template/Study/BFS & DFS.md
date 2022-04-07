## BFS & DFS
- 직관적으로 그림으로 이해하면 아래와 같음

![one](/cheewr85/img/Template/997C3C3E5BD01AF41D.gif)

### DFS(Depth-First Search)
- 깊이 우선 탐색으로 루트 노드(혹은 다른 임의의 노드)에서 다음 분기(branch)로 넘어가기 전에, 해당 분기(branch)를 모두 탐색하는 방법, 탐색 후에는 다시 원점으로 돌아가 다른 분기를 탐색함

- 재귀 혹은 스택으로 자기 자신을 호출하는 순환 알고리즘임

```java
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
```

- 인접 리스트 방식은 조금 다름

```java
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
        for(int i = 1; i < arr[v].size(); i++) {
        	int y = arr[v][i];
            if(visit[i] == false) {
                dfs(y);
            }
        }
    }
```

### BFS(Bread-First Search)
- 너비 우선 탐색으로 루트 노드(혹은 다른 임의의 노드)에서 시작한 인접 노드를 먼저 탐색하는 방법

- 재귀적으로 동작하지 않고 방문한 노드들을 차례로 저장한 후 꺼낼 수 있는 큐 자료구조를 활용하여서 탐색을 함

```java
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
```

- 인접리스트는 조금 다름

```java
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
            for(int i = 1; i < arr[v].size(); i++) {
                // 인접한 노드가 있는 것과 아직 방문하지 않았다면
                // 이미 한 번 제대로 BFS 탐색을 하면 반복문은 계속 되지만 visit 함수는 true 처리되어 있어서 반복문만 돌고 if문에 조건이 맞지 않을 것임
                int y = arr[v][i];
                if(visit[y] == false) {
                    // 인접 노드 저장하는 큐에 넣고 방문 체크를 하고 출력함
                    que.add(y);
                    visit[y] = true;
                    System.out.print(y + " ");
                }
            }
            // 위의 방식을 큐에 노드가 없을 때까지 반복하면서 탐색을 함
        }
    }
```

