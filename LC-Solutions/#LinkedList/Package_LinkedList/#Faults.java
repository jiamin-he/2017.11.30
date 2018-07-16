/*
 Author:     Jiamin, hejiamin1995@gmail.com
 Date:       Sep 16, 2017
 Problem:    Linked List
 Notes:

*/


// 要导入这些 电脑才能跑
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//iterator的next是个函数，linkedlist的next是个值
System.out.println(i.next);
### error: cannot find symbol
            System.out.println(i.next);
                                ^
  symbol:   variable next
  location: variable i of type Iterator
//修正
System.out.println(i.next());

// list是个抽象的类
List<String> list2 = new List<>();
### error: List is abstract; cannot be instantiated
// 修正
List<String> list2 = new ArrayList<>();


// 右边是个object 左边是个linkedlist 的string类 左右类型不匹配
LinkedList<String> list3 = new LinkedList<>();
list3 = list.clone();
// 修正



//Iterator 要在前面加一句
Iterator i = list.iterator();
### error: cannot find symbol
        Iterator i = list.iterator();
        ^
  symbol:   class Iterator
  location: class Iterate

//修正
// --> import java.util.*;

 