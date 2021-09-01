package ch1pro.POJ1988;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        UnionFind unionFind = new UnionFind(30000);
        for (int i = 0; i < p; i++) {
            String command = scanner.next();
            if(command.equals("M")) {
                int x = scanner.nextInt(), y = scanner.nextInt();
                unionFind.union(x, y);
            }

            if(command.equals("C")) {
                System.out.println(unionFind.getNum(scanner.nextInt()));
            }
        }

    }

    static class UnionFind {
        int[] fa;

        int[] d;

        int[] cnt;

        int n;

        public UnionFind(int n) {
            this.n = n;
            fa = new int[n + 1];
            d = new int[n + 1];
            cnt = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                fa[i] = i;
                d[i] = 0;
                cnt[i] = 1;
            }
        }

        public int find(int x) {
            int fx = fa[x];
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
                d[x] += d[fx];
            }

            return fa[x];
        }

        public void union(int x, int y) {
            int a = find(x);
            int b = find(y);
            fa[a] = b;
            d[a] = cnt[b];
            cnt[b] += cnt[a];
        }

        public int getNum(int x) {
            find(x);
            return d[x];
        }
    }
}
