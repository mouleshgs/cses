import java.io.*;
import java.util.*;

public class TwoSets {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        long n = fs.nextLong();

        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();

        long total = n * (n + 1) / 2;

        if (total % 2 != 0) {
            out.println("NO");
        } else {
            long target = total / 2;
            for (int i = (int)n;i > 0;i--) {
                if (target >= i) {
                    target -= i;
                    a.add(i);
                } 

                if (target == 0) break;
            }

            for (int i = 1;i <= n;i++) {
                if (!a.contains(i)) {
                    b.add(i);
                }
            }

            out.println("YES");
            out.println(a.size());
            for (int x : a) {
                out.print(x + " ");
            }
            out.println();
            out.println(b.size());
            for (int x : b) {
                out.print(x + " ");
            }

        }

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