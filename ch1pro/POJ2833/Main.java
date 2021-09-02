package ch1pro.POJ2833;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());

            int n1 = scanner.nextInt(), n2 = scanner.nextInt(), n = scanner.nextInt();
            double sum = 0.0;
            for(int i=0;i<n;i++) {
                int val = scanner.nextInt();
                minQueue.offer(val);
                while (minQueue.size() > n1) {
                    minQueue.poll();
                }
                maxQueue.offer(val);
                while (maxQueue.size() > n2) {
                    maxQueue.poll();
                }
                sum += val;
            }

            while(minQueue.size() > 0) {
                sum -= minQueue.poll();
            }

            while(maxQueue.size() > 0) {
                sum -= maxQueue.poll();
            }
            System.out.println(sum / (n - n1 - n2));
        }
    }
}
