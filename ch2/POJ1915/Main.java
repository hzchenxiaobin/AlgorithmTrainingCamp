package ch2.POJ1915;

import java.util.*;

public class Main {
    private static int[][] DIRECTIONS = new int[][]{{-2,-1},{-1,-2},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        for(int i=0;i<num;i++) {
            int l = scanner.nextInt();
            Node from = new Node(scanner.nextInt(), scanner.nextInt());
            Node to = new Node(scanner.nextInt(), scanner.nextInt());
            System.out.println(bfs(from, to, l));
        }
    }

    private static int bfs(Node from, Node to, int l) {
        Set<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        if(nodeEquals(from, to)) return 0;
        set.add(from);
        queue.offer(from);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                Node node = queue.poll();
                for(int[] direction : DIRECTIONS) {
                    int newX = node.x + direction[0];
                    int newY = node.y + direction[1];

                    if(newX < 0 || newX >= l || newY < 0 || newY >= l) continue;
                    Node newNode = new Node(newX, newY, node.step + 1);
                    if(nodeEquals(newNode, to)) return newNode.step;
                    //没有进入队列的加到队列，已经进入过队列的不再进入队列
                    if(!set.contains(newNode)) {
                        queue.offer(newNode);
                        set.add(newNode);
                    }
                }
            }
        }

        return 0;
    }

    private static boolean nodeEquals(Node node1, Node node2) {
        return node1.x == node2.x && node1.y == node2.y;
    }

    public static class Node {
        int x;
        int y;

        int step;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
