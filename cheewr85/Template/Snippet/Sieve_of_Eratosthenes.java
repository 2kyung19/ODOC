import java.io.*;
import java.util.*;



public class Main {

    // 소수 판별을 할 배열
    public static boolean[] prime;

    public static void main(String[] args) throws Exception {
        // 입력받은 최대 숫자만큼 배열 크기 할당(그만큼 수를 소수 판별함)
        prime = new boolean[10000];
        get_prime();

        

    }

    public static void get_prime() {
        // true 소수 아님, false = 소수
        prime[0] = prime[1] = true;

        // 제곱근 전까지 체크할 필요 없으므로 해당 값 전까지 체크
        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            // 만약 이미 true 즉, 체크가 됐다면 무시하고 넘김
            if(prime[i]) continue;
            // 체크된 값이 아니라면 그 값에 배수를 true로 만듬
            for(int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }


}