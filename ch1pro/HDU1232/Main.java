package ch1pro.HDU1232;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) break;
            int m = scanner.nextInt();
            UnionFind unionFind = new UnionFind(n);

            for (int i = 0; i < m; i++) {
                unionFind.union(scanner.nextInt(), scanner.nextInt());
            }
            System.out.println(unionFind.getNum());
        }
    }

    static class UnionFind {
        int[] fa;
        int n;

        public UnionFind(int n) {
            this.n = n;
           fa = new int[n + 1];
           for(int i=1;i<=n;i++) {
               fa[i] = i;
           }
        }

        public  int find(int x) {
            if(x != fa[x]) {
                fa[x] = find(fa[x]);
            }

            return fa[x];
        }

        public void union(int x, int y) {
            int a = find(x);
            int b = find(y);
            if(a != b) {
                fa[b] = a;
            }
        }

        public int getNum() {
            int result = 0;
            for(int i=1; i<=n;i++) {
                if(i == fa[i]) result++;
            }
            return result - 1;
        }
    }
}
