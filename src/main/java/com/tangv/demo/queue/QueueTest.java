package com.tangv.demo.queue;

import java.util.*;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/8/10 9:48 下午
 */
public class QueueTest {

    public static void printQ(Queue queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove()+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0;i< 10;i = i+2) {
            queue.offer(i);
        }
        QueueTest.printQ(queue);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Random random = new Random();
        for (int i = 0;i<10;i++) {
            priorityQueue.offer(random.nextInt(i+10));
        }
        QueueTest.printQ(priorityQueue);
        List<Integer> list = Arrays.asList(17, 45, 2, 34, 67, 45, 12, 43, 3, 4, 34, 34, 5, 89, 10, 14, 12, 12);
        priorityQueue = new PriorityQueue<>(list);
        QueueTest.printQ(priorityQueue);
        ArrayList diffNo = QueueTest.getDiffNo(5);
        System.out.println(diffNo);
    }

    public static ArrayList getDiffNo(int n) {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        int num = 0;
        boolean[] bool = new boolean[n];
        for (int i = 0;i < n;i++) {
            do {
                num = random.nextInt(n);
            }while (bool[num]);
            bool[num] = true;
            list.add(num);
        }
        return list;
    }
}
