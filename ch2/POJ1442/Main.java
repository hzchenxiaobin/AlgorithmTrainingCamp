package ch2.POJ1442;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(), n = scanner.nextInt();
        int[] addArr = new int[m];
        for (int i = 0; i < m; i++) {
            addArr[i] = scanner.nextInt();
        }
        int[] getArr = new int[n];
        for (int i = 0; i < n; i++) {
            getArr[i] = scanner.nextInt();
        }

        PriorityQueue<Integer> minQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>();
        int i = 0;
        int getIndex = 0;
        int minQueueSize = i + 1;
        for (int addIndex = 0; addIndex < m; addIndex++) {
            int val = addArr[addIndex];
            if (maxQueue.size() > 0 && val > maxQueue.peek()) {
                maxQueue.offer(val);
            } else minQueue.offer(val);

            while(minQueue.size() < minQueueSize && !maxQueue.isEmpty()) {
                minQueue.offer(maxQueue.poll());
            }
            while(minQueue.size() > minQueueSize) {
                maxQueue.offer(minQueue.poll());
            }

            if (addIndex + 1 >= getArr[getIndex]) {
                System.out.println(minQueue.peek());
                getIndex++;
                i++;
                minQueueSize++;
            }
        }

    }
}
