/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Nov 30, 2017
 Problem:    My calendar I
 Difficulty: Medium
 Notes:

Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.

Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)

For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.

Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
Example 1:
MyCalendar();
MyCalendar.book(10, 20); // returns true
MyCalendar.book(15, 25); // returns false
MyCalendar.book(20, 30); // returns true
Explanation: 
The first event can be booked.  The second can't because time 15 is already booked by another event.
The third event can be booked, as the first event takes every time less than 20, but not including 20.
Note:

The number of calls to MyCalendar.book per test case will be at most 1000.
In calls to MyCalendar.book(start, end), start and end are integers in the range [0, 10^9].
*/


// 149 ms, very fast 
class MyCalendar {
    List<int[]> schedule;

    public MyCalendar() {
        schedule = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] s : schedule){
            if(Math.max(start,s[0]) < Math.min(end,s[1])) return false;
        }
        schedule.add(new int[] {start,end});
        return true;
    }

}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */


// 163 ms slower than directly use the iterator
class MyCalendar {
    List<int[]> schedule;

    public MyCalendar() {
        schedule = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int i = 0; i < schedule.size(); i++){
            int[] s = schedule.get(i);
            if(Math.max(start,s[0]) < Math.min(end,s[1])) return false;
        }
        schedule.add(new int[] {start,end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

//compare difference between ArrayList and LinkedList
// compare difference between iterator and use the index to iterate

// this one will TLE
class MyCalendar {
    List<int[]> schedule;

    public MyCalendar() {
        schedule = new LinkedList<>();
    }
    
    public boolean book(int start, int end) {
        for(int i = 0; i < schedule.size(); i++){
            int[] s = schedule.get(i);
            if(Math.max(start,s[0]) < Math.min(end,s[1])) return false;
        }
        schedule.add(new int[] {start,end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */


// this one is 186ms slower but works
class MyCalendar {
    List<int[]> schedule;

    public MyCalendar() {
        schedule = new LinkedList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] s : schedule){
            if(Math.max(start,s[0]) < Math.min(end,s[1])) return false;
        }
        schedule.add(new int[] {start,end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
