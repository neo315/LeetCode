import java.util.PriorityQueue;
import java.util.Collections;
class MedianFinder { 
    private int initialSize = 10; 
    private final PriorityQueue<Integer> minHeap =  new PriorityQueue<Integer>(initialSize); 
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(initialSize, Collections.reverseOrder()); 
    // Adds a number into the data structure. 
    public void addNum(int num) { 
        if (minHeap.isEmpty() && maxHeap.isEmpty()) { 
            maxHeap.offer(num); 
        } 
        else if (minHeap.isEmpty()) { 
            if (num > maxHeap.peek()) { 
                minHeap.offer(num); 
            } 
            else { 
                maxHeap.offer(num); 
            } 
        } 
        else { 
            if (num >= minHeap.peek()) { 
                minHeap.offer(num); 
            }
            else { 
                maxHeap.offer(num); 
            } 
        } 
        balance(); 
        return; 
    } 
    private void balance() { 
        while (minHeap.size() - 1 > maxHeap.size()) { 
            maxHeap.offer(minHeap.poll()); 
        } 
        while (maxHeap.size() > minHeap.size()) { 
            minHeap.offer(maxHeap.poll()); 
        } 
    } 
    // Returns the median of current data stream 
    public double findMedian() { 
        if (minHeap.size() == maxHeap.size()) { 
            return (minHeap.peek() + maxHeap.peek()) / 2.0; 
        } 
        else if (minHeap.size() > maxHeap.size()){ 
            return minHeap.peek(); 
        } 
        else { 
            return maxHeap.peek(); 
        } 
    }
    public static void main(String[] args) {
        MedianFinder s = new MedianFinder();
        s.addNum(-1);
        System.out.println(s.findMedian());
        s.addNum(-2);
        System.out.println(s.findMedian());
        s.addNum(-3);
        System.out.println(s.findMedian());
        s.addNum(-4);
        System.out.println(s.findMedian());
        s.addNum(-5);
        System.out.println(s.findMedian());
    }
}
 
// Your MedianFinder object will be instantiated and called as such: 
// MedianFinder mf = new MedianFinder(); 
// mf.addNum(1); 
// mf.findMedian();