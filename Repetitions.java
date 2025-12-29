import java.util.*;

public class Repetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int n = s.length();
        int maxLen = 1;
        int currMax = 1;
        char maxC = s.charAt(0);
        for (int i = 1;i < n;i++) {
            if (maxC == s.charAt(i)) {
                currMax++;
            } else {
                maxC = s.charAt(i);
                currMax = 1;
            }

            maxLen = Math.max(maxLen, currMax);
        }

        System.out.println(maxLen);

        sc.close();
    }
}