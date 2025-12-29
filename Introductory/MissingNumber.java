package Introductory;
import java.util.*;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();

        long[] arr = new long[n];
        long sum = 0;
        for (int i = 0;i < n-1;i++) {
            arr[i] = sc.nextLong();
            sum += arr[i];
        }

        long total = ((long)n * (n+1)) / 2;

        System.out.println(total - sum);

        sc.close();
    }
}