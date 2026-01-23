package Sorting;
import java.io.*;
import java.util.*;

public class sumOfThree {

    static class Pair {
        long val;
        int idx;

        Pair(long val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt();

        long x = fs.nextLong();
        
        Pair[] arr = new Pair[n];

        for (int i = 0;i < n;i++) {
            long val = fs.nextLong();
            arr[i] = new Pair(val, i);
        }
        
        Arrays.sort(arr, (a, b) -> Long.compare(a.val, b.val));

        for (int k = 0;k < n-2;k++) {
            int i = k+1;
            int j = n-1;
            
            while (i < j) {
                // out.println(arr[i] + arr[j] + arr[k]);
                if (arr[i].val + arr[j].val + arr[k].val == x) {
                    out.println((arr[k].idx+1) + " " + (arr[i].idx+1) + " " + (arr[j].idx+1));
                    out.flush();
                    return;
                }

                if (arr[i].val + arr[j].val + arr[k].val < x) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        out.println("IMPOSSIBLE");

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