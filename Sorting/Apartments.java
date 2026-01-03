package Sorting;
import java.io.*;
import java.util.*;

public class Apartments {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();



        long[] a = new long[n];
        for (int i = 0;i < n;i++) {
           a[i] = fs.nextLong();
        }

        long[] b = new long[m];
        for (int i = 0;i < m;i++) {
           b[i] = fs.nextLong();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        // out.println(Arrays.toString(a));
        // out.println(Arrays.toString(b));

        int i = n - 1, j = m - 1;
        int cnt = 0;

        while (i >= 0 && j >= 0) {
            if (Math.abs(a[i] - b[j]) <= k) {
                cnt++;
                i--;
                j--;
            } else if (b[j] < a[i] - k){
                i--;
            } else if (b[j] > a[i] + k) {
                j--;
            }
        }

        out.println(cnt);

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