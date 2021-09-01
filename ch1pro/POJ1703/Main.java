package ch1pro.POJ1703;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int n = scanner.nextInt(), m = scanner.nextInt();
            UnionFind unionFind = new UnionFind(2 * n);
            for (int j = 0; j < m; j++) {
                String command = scanner.next();
                int x = scanner.nextInt(), y = scanner.nextInt();
                if (command.equals("D")) {

                    unionFind.union(x, y + n);
                    unionFind.union(x + n, y);
                }

                if (command.equals("A")) {
                    if(unionFind.find(x) == unionFind.find(y + n)
                            || unionFind.find(x + n) == unionFind.find(y)) {
                        System.out.println("In different gangs.");
                    } else if(unionFind.find(x) == unionFind.find(y)
                            || unionFind.find(x + n) == unionFind.find(y + n)) {
                        System.out.println("In the same gang.");
                    } else {
                        System.out.println("Not sure yet.");
                    }
                }
            }
        }
    }


    static class UnionFind {
        int[] fa;

        int n;

        public UnionFind(int n) {
            this.n = n;
            fa = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                fa[i] = i;
            }
        }

        public int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }

            return fa[x];
        }

        public void union(int x, int y) {
            int a = find(x), b = find(y);
            if (a != b) {
                fa[a] = b;
            }
        }
    }
}
