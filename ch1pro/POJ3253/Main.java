package ch1pro.POJ3253;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int val = scanner.nextInt();
            priorityQueue.offer(val);
            sum += val;
        }
        int result = 0;
        while (priorityQueue.size() > 1) {
            result += sum;
            sum -= priorityQueue.poll();
        }

        System.out.println(result);
    }
}
