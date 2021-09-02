package ch1pro.POJ2431;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node();
            node.dis = scanner.nextInt();
            node.add = scanner.nextInt();
            list.add(node);
        }
        list.sort((node1, node2) -> node2.dis - node1.dis);
        int l = scanner.nextInt(), p = scanner.nextInt();
        int pos = p;
        int index = 0;
        int result = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        while (pos < l) {
            while (index < list.size() && l - pos <= list.get(index).dis) {
                priorityQueue.offer(list.get(index).add);
                index++;
            }
            if (priorityQueue.isEmpty()) {
                System.out.println(-1);
                return;
            }
            pos += priorityQueue.poll();
            result++;
        }

        System.out.println(result);
    }

    static class Node {
        int dis;
        int add;
    }
}
