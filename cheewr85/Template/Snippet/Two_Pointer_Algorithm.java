import java.util.*;
import java.io.*;

public class Main {

/**
 * 11728 문제 코드가 투 포인터 알고리즘을 잘 나타내서 정리함
 * i, j의 시작점을 0으로 초기화 함 그리고 비교를 통해서 해당 i,j에 인덱스를 조건에 따라 더함
 * 마지막에 남는 것에 대해서는 크기까지 남은 것을 추가하면 됨(해당 문제는 순서가 보장됐으므로)
 * 이 투포인터 알고리즘을 활용하는 방식은 문제에 따라 방식이 다를 뿐 원리는 유사하므로 그대로 가져옴
 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // A,B 배열의 크기 입력받음
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 입력받은 크기대로 A,B를 초기화하고 결과 배열은 A+B의 합으로 함, 합칠 것이므로
        int[] A = new int[N];
        int[] B = new int[M];
        int[] result = new int[N+M];

        // A 입력받고 정렬함
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        // B 입력받고 정렬함
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);

        // 투포인터 알고리즘(두 배열의 원소를 서로 비교하기 위해서 각각 인덱스 값 정의)
        int i = 0;
        int j = 0;
        int k = 0;

        // 두 배열의 원소를 서로 비교해 작은 것을 새로운 배열에 담음
        while (i < N && j < M) {
            if (A[i] > B[j]) {
                result[k++] = B[j++];
            } else {
                result[k++] = A[i++];
            }
        }

        // 어느 한 쪽이 남은 것이 있다면 남은 것은 새로운 배열에 담음(순서를 보장하기 때문에)
        while (j < M) {
            result[k++] = B[j++];
        }
        while (i < N) {
            result[k++] = A[i++];
        }

        StringBuilder sb = new StringBuilder();
        // 결과값 만들어서 출력
        for (int p = 0; p < result.length; p++) {
            sb.append(result[p]).append(" ");
        }
        System.out.println(sb);


    }



}