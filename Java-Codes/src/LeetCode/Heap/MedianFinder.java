package LeetCode.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 *
 * The median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.
 *
 * Find median in a running stream
 */

public class MedianFinder {

    Queue<Integer> maxHeap;
    Queue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    void balance() {
        while (maxHeap.size() - minHeap.size() > 1) {
            int n = maxHeap.poll();
            minHeap.add(n);
        }
        while (minHeap.size() > maxHeap.size()) {
            int n = minHeap.poll();
            maxHeap.add(n);
        }
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || maxHeap.peek() > num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        balance();
    }

    public double findMedian() {
        if (maxHeap.isEmpty())
            return 0;
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        double x = medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        medianFinder.addNum(6);
        medianFinder.addNum(8);
        medianFinder.addNum(5);
        double y = medianFinder.findMedian(); // return 2.0
        System.out.println(x + " " + y);
    }

}
