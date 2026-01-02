package Introductory;
import java.io.*;
import java.util.*;

public class ChessBoard {

    static char[][] board = new char[8][8];
    static int count = 0;
    static boolean[] occCol = new boolean[8];
    static boolean[] dig1 = new boolean[16];
    static boolean[] dig2 = new boolean[16];

    public static void dfs(int row) {
        if (row == 8) {
            count++;
            return;
        }

        for (int c = 0;c < 8;c++) {
            if (board[row][c] == '*') continue;

            if (occCol[c] || dig1[row - c + 7] || dig2[row + c]) continue;

            occCol[c] = dig1[row - c + 7] = dig2[row + c] = true;

            dfs(row+1);

            occCol[c] = dig1[row - c + 7] = dig2[row + c] = false;
        }
    }
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);

        for (int i = 0;i < 8;i++) {
            board[i] = fs.next().toCharArray();
        }

        dfs(0);
        out.println(count);

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

