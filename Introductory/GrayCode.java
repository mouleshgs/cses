package Introductory;
import java.io.*;
import java.util.*;

public class GrayCode {

    // public static void solve(int idx, int n, StringBuilder ans, List<String> res) {
    //     if (idx == n) {
    //         res.add(ans.toString());
    //         return;
    //     }

    //     ans.append("0");
    //     solve(idx+1, n, ans, res);
    //     ans.deleteCharAt(ans.length() - 1);

    //     ans.append("1");
    //     solve(idx+1, n, ans, res);
    //     ans.deleteCharAt(ans.length() - 1);
    // }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int n = fs.nextInt();
        int limit = 1 << n;

        for (int i = 0; i < limit; i++) {
            int gray = i ^ (i >> 1); // gray code formual = i ^ (i >> 1)
            out.println(toBinary(gray, n));
        }

        out.flush();
    }

    static String toBinary(int x, int n) {
        String s = Integer.toBinaryString(x);
        while (s.length() < n) {
            s = "0" + s;
        }
        return s;
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