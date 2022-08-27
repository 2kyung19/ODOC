## Union & Find
- 상호 배타적 집합(Disjoint-set)을 표현하는데 자주 쓰는 그래프 알고리즘

- 여러 노드가 존재할 때, 두 개의 노드를 선택해서 현재 두 노드가 서로 같은 그래프에 속하는지 판별하는 알고리즘

- Union의 경우 x와 y가 포함되어 있는 집합을 합치는 연산이고 Find의 경우 x가 어떤 집합에 포함되어 있는지 찾는 연산임

- 그래서 이를 예제문제 코드로 보면 아래와 같음

```java
import java.util.*;

public class Main {

    static int[] unf;

    public static int Find(int v) {
        // 해당하는 학생 인덱스 번호와 비교함, 이 때 처음에는 if 조건문에서 걸려서 인덱스 번호 값 즉 집합번호를 그대로 리턴함
        if (v == unf[v]) return v;
        // 초기 이후 값은 인덱스번호와 해당하는 집합번호가 달라져 있기 때문에 아래의 조건을 만족함
        // 그래서 인덱스 1값이 1이었다가 1-2가 되어서 2가 된 경우 결국 아래의 조건대로라면 집합번호가 같게 리턴되게 됨
        // 근데 인덱스 번호와 값에 대해서 처리하기 때문에 결국 1-2-3의 친구에서 2-3의 값이 같은데 1은 집합번호가 달라서 아래와 같이 리턴처리를 함 그럼 같은 값을 가짐(경로를 압축시킬 수 있음)
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b) {
        // 친구관계가 맞는지 확인하는 함수
        int fa = Find(a);
        int fb = Find(b);
        // Union으로 넘어온 것이 친구관계인 것이므로 우선 unf에서의 집합번호를 찾아보고 다르면 같게 통일해줌(친구관계이므로)
        if (fa!=fb) unf[fa] = fb;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n+1];
        for (int i = 1; i <= n; i++) unf[i]=i;
        for (int i = 1; i <= m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // a,b를 한 집합으로 만드는 의미를 가짐
            Union(a, b);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = Find(a);
        int fb = Find(b);
        if (fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }

}
```