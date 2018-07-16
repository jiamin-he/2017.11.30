/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Jul 03, 2018
 Problem:    Find Median from Data Stream
 Difficulty: Hard
 Notes:

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

For example,
[2,3,4], the median is 3

[2,3], the median is (2 + 3) / 2 = 2.5

Design a data structure that supports the following two operations:

void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
Example:

addNum(1)
addNum(2)
findMedian() -> 1.5
addNum(3) 
findMedian() -> 2
*/

class MedianFinder {
    PriorityQueue<Integer> large;
    PriorityQueue<Integer> small;
    int size;

    /** initialize your data structure here. */
    public MedianFinder() {
		// 直接设置的是最小堆 （k th max）
        large = new PriorityQueue<>();
        small = new PriorityQueue<>(new Comparator<Integer>(){
           public int compare(Integer i1, Integer i2) {
               // 正常是前面减后面！！！（特殊是后面减前面；
			   // 这样设置的是最大堆（k th min）
			   return i2-i1;
           } 
        });
        size = 0;
    }
    
    public int getSize(){
        return size;
    }
    
    public void addSize(){
        size++;
    }
    
    public void addNum(int num) {
        if(!large.isEmpty() && num >= large.peek()){
            large.offer(num);  
        } 
        else {
            small.offer(num);   
        }
        addSize();
        int size = getSize();
        if(large.size()>=size/2 && small.size()>=size/2) return;
        if(large.size()> small.size()) {
            int temp = large.poll();
            small.offer(temp);
        } else {
            int temp = small.poll();
            large.offer(temp);
        }
    }
    
    public double findMedian() {
        double median = 0;
        int size = getSize();
        if(size%2==0) {
			// 记住这里是2.0！！！！写2导致结果不对！！！
            median = (large.peek()+small.peek())/2.0;
        } else {
            if(large.size()>small.size()) median = large.peek();
            else median = small.peek();
        }
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */