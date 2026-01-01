import java.io.*;
import java.util.*;

public class PalindromeReorder {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        String s = fs.next();

        int n = s.length();

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'A']++;
        }

        int count = 0;

        int oddCh = 'A';

        for (int i = 0;i < 26;i++) {
            if (freq[i] % 2 != 0) {
                count++;
                oddCh = i;
                if (count > 1) {
                    out.println("NO SOLUTION");
                    out.flush();
                    return;
                }
            }
        }

        char[] ans = new char[n];
        int k = 0;

        for (int i = 0; i < 26; i++) {
            int cnt = freq[i] / 2;
            for (int j = 0; j < cnt; j++) {
                ans[k] = (char)(i + 'A');
                ans[n - k - 1] = (char)(i + 'A');
                k++;
            }
        }

            if (count == 1) {
                ans[n / 2] = (char)(oddCh + 'A');
            }

            out.println(String.valueOf(ans));
        


        out.flush();
    }


    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c, sign = 1;
            long val = 0;
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        String next() throws IOException {
            int c;
            StringBuilder sb = new StringBuilder();
            do {
                c = readByte();
            } while (c <= ' ');

            while (c > ' ') {
                sb.append((char) c);
                c = readByte();
            }
            return sb.toString();
        }

        String nextLine() throws IOException {
           int c;
           StringBuilder sb = new StringBuilder();
           while (true) {
               c = readByte();
               if (c == -1) return sb.toString();
               if (c != '\n' && c != '\r') break;
           }

           while (c != -1 && c != '\n' && c != '\r') {
               sb.append((char) c);
               c = readByte();
           }
           return sb.toString();
        }
    }
}