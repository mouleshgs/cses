package Sorting;
import java.io.*;
import java.util.*;

public class NestedRangeCheck {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt();

        int[][] arr = new int[n][3];
        for (int i = 0;i < n;i++) {
            arr[i][0] = fs.nextInt();
            arr[i][1] = fs.nextInt(); 
            arr[i][2] = i;
        }

        Arrays.sort(arr, (a, b) -> (a[0] != b[0]) ? Integer.compare(a[0], b[0]) : Integer.compare(b[1], a[1]));

        int minEnd = Integer.MAX_VALUE;

        int[] contains = new int[n];

        for (int i = n-1; i >= 0;i--) {
            if (arr[i][1] >= minEnd) {
                contains[arr[i][2]] = 1;
            }

            minEnd = Math.min(minEnd, arr[i][1]);
        }

        int maxEnd = Integer.MIN_VALUE;

        int[] contained = new int[n];

        for (int i = 0;i < n;i++) {
            if (arr[i][1] <= maxEnd) {
                contained[arr[i][2]] = 1; 
            }

            maxEnd = Math.max(maxEnd, arr[i][1]);
        }

        for (int v : contains) {
            out.print(v + " ");
        }
        out.println();

        for (int v : contained) {
            out.print(v + " ");
        }

        out.println();

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