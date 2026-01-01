import java.io.*;
import java.util.*;

public class CreatingString {

    static List<String> ans = new ArrayList<>();

    static void solve(char[] arr, boolean[] used, StringBuilder sb) {

        if (sb.length() == arr.length) {
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (used[i]) continue;

            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            sb.append(arr[i]);

            solve(arr, used, sb);

            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        String s = fs.next();

        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        solve(arr, new boolean[arr.length], new StringBuilder());

        StringBuilder output = new StringBuilder();
        output.append(ans.size()).append('\n');

        for (String str : ans) {
            output.append(str).append('\n');
        }

        out.println(output.toString());

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