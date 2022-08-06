import java.util.*;
import java.io.*;

public class Main {

    public static int[] solution(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int target = arr[i];
            int j = i - 1;

            while (j >= 0 && target < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = target;
        }
        return arr;
    }


}