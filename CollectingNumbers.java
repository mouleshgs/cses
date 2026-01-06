import java.io.*;
import java.util.*;

public class CollectingNumbers {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int[] pos = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int x = fs.nextInt();
            pos[x] = i;
        }

        int rounds = 1;
        for (int i = 2; i <= n; i++) {
            if (pos[i] < pos[i - 1]) {
                rounds++;
            }
        }

        System.out.println(rounds);
    }

    // Fast input reader
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in;

        FastScanner(InputStream in) {
            this.in = in;
        }

        int read() throws IOException {
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
                c = read();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = read();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
