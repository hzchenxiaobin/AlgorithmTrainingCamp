package ch1pro.HDU4006;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), k = scanner.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<n;i++) {
            String command = scanner.next();
            if(command.equals("I")) {
                priorityQueue.offer(scanner.nextInt());
                while (priorityQueue.size() > k) {
                    priorityQueue.poll();
                }
            }

            if(command.equals("Q")) {
                System.out.println(priorityQueue.peek());
            }
        }
    }
}
