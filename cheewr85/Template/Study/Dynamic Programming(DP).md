## Dynamic Programming(동적 프로그래밍)
- DP 문제의 구성은 2가지를 거의 무조건 충족함

- 최적 부분 구조 : 큰 문제를 작은 문제로 나누고 작은 문제의 답을 모아서 큰 문제를 해결

- 중복되는 부분 문제 : 동일한 작은 문제를 반복적으로 해결함

- 즉 위의 두 조건을 만족하는 것이 사실상 점화식이 형성되어서 반복적으로 계산이 되면서 결과에 도출한다고 볼 수 있음

- 이 부분에 대해서 재귀형식으로 풀지 반복문의 형식으로 풀지 정할 수 있음(1463번 문제를 기준으로 알아봄)

### Memorization(재귀형식)
- 재귀형식으로 풀기 때문에 조료조건이 있는 상태에서 재귀함수로 받은 값에 대해서 작은 문제로 쪼개서 깊이 있게 들어감

- 1463 문제의 경우 3가지 연산을 통해서 1을 만드는 것인데 이를 재귀함수로 표현해서 경우의 수를 나누어 1이 되는 경우까지 재귀함수를 들어가고 종료조건까지 들어간 뒤 마지막 return을 계속 함으로써 해당 값에 대해서 저장하고 연산에 활용함(연산 자체는 동일함)

```java
import java.util.*;
import java.io.*;

public class Main {

    static Integer[] dp;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        System.out.print(recur(N));

    }

    static int recur(int N) {
        // null인 경우 즉, 아직 1이 되는 경우의 수를 체크하지 않는 상황일 때
        if(dp[N] == null) {
         // N 기준으로 각각 경우에 따라 DP로 저장된 최솟값을 가지고 확인해서 최솟값을 찾고 그 최솟값에 1을 더한 것이 현재 N의 개수가 되므로 +1을 한 것임
            // 6으로 나누어 떨어질 경우
            if(N % 6 == 0) {
                // 3으로 나누는 경우, 2로 나누는 경우, 1을 빼는 경우 모두 재귀호출을 하여서 최솟값으로 DP를 갱신함
                dp[N] = Math.min(recur(N-1), Math.min(recur(N / 3), recur(N / 2))) + 1;
            }
            // 3으로만 나누어 떨어질 경우
            else if(N % 3 == 0) {
                // 3으로 나누는 경우와 1을 뺴는 경우 재귀호출을 하여서 최솟값으로 DP를 갱신함
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }
            // 2로만 나누어 떨어질 경우
            else if(N % 2 == 0) {
                // 2로 나누는 경우와 1을 뺴는 경우의 수를 재귀호출 하여서 최솟값으로 DP를 갱신함
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }
            // 2와 3으로 나누어 떨어지지 않는 경우
            else {
                dp[N] = recur(N - 1) + 1;
            }
        }
        return dp[N];
    }

}
```

### Tabulation(반복문 형식)
- 초기화 작업은 재귀함수를 활용하여도 똑같이 초기화를 하지만 반복문의 경우 규칙이 있는 점화식을 만들어 그 연산을 원하는 범위까지 지속적으로 반복하는 방식임

- 1463의 경우도 반복문으로 아래와 같이 풀 수 있음

```java
import java.io.*;
import java.util.*;



public class Main {

    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N+1];

        // 0과 1은 1이 되는 경우가 없음
        dp[0] = dp[1] = 0;
        for(int i = 2; i <= N; i++) {
            // 우선 1을 뺀 경우 먼저 생각, 이러면 dp[3]인 경우 3에서 1을 빼면 2가 되는데 1을 뺀 경우만 +1을 하고 최솟값은 dp[2]가 됨, 이미 최소값이 저장되어 있으므로
            dp[i] = dp[i-1] + 1;
            // 2를 나누고, 3을 나눈 경우도 마찬가지 나눈 행위에 대해 +1을 하고 2를 나누고 3을 나눴을 때의 dp값이 최소이므로 해당 값을 활용해서 더함
            // 그리고 1을 뺀 경우와 비교하기 위해서 Math.min 사용함
            if(i%2==0) dp[i] = Math.min(dp[i], dp[i/2] + 1);
            if(i%3==0) dp[i] = Math.min(dp[i], dp[i/3] + 1);
        }

        System.out.println(dp[N]);
    }


}
```

### 정리
- DP문제라면 규칙성이 나온 순간 필연적으로 중복되는 구조가 발생함, 이를 그래서 DP배열을 만들어서 그 값을 담을 수 있음

- 거의 필연적으로 규칙성과 특징이 존재함, 요구 조건대로 경우의 수를 아래와 같이 따져보면 그 규칙이 보이고 이를 통해 점화식을 만들 수 있으며 이를 반복문 혹은 재귀형식으로 설계하여 값을 도출할 수 있음

![one](/cheewr85/img/Template/nine.png)

![one](/cheewr85/img/Template/ten.png)

![one](/cheewr85/img/Template/eleven.png)

- 결국 원하고자 하는 답을 찾는데 있어서 위와 같이 규칙성과 점화식이 형성되고 저대로 계산하면서 DP에 맞게 계산되다가 마지막에 원하는 값이 나오는 구조임

- 그러니 규칙성과 직접 그 구조를 잘 생각해야함