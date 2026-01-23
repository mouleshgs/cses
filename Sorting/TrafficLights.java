package Sorting;
import java.io.*;
import java.util.*;

public class TrafficLights {

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        int x = fs.nextInt();
        int n = fs.nextInt();

        /*
            0, 2 2
            2, 3 1 
            3, 6 3
            6, 8 2

            3 1
            2 2

            TLE due to the java performance we can't do anything
            
        */

        long[] arr = new long[n];
        for (int i = 0;i < n;i++) {
           arr[i] = fs.nextLong();
        }

        TreeSet<Integer> pos = new TreeSet<>();
        TreeMap<Integer, Integer> len = new TreeMap<>();

        pos.add(0);
        pos.add(x);
        len.put(x, 1);


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int p = (int) arr[i];

            int left = pos.lower(p);
            int right = pos.higher(p);

            int old = right - left;
            len.put(old, len.get(old) - 1);
            if (len.get(old) == 0) len.remove(old);

            int a = p - left;
            int b = right - p;

            len.put(a, len.getOrDefault(a, 0) + 1);
            len.put(b, len.getOrDefault(b, 0) + 1);

            pos.add(p);

           sb.append(len.lastKey()).append(" ");
        }

       out.println(sb.toString());

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