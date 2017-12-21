#### 新定义comparator来自定义排序 

- Arrays. sort (array, new Compartator<...>()) 

  【252 meeting rooms】

- ​

#### 新定义的class

- 不要加public 

  【252 meeting rooms】

- 要放外面啊

- 不要两个不同的solution文件都定义一个相同的new class啊，一个solution建了就可以了

#### 自定义的priority queue的compare

- 【253 meeting rooms II — Solution2】

#### Array -> arraylist

- Arrays.asList(nums[i],nums[low],nums[high])

#### list内嵌list

- List<List<Integer>> res = new ArrayList<>();

#### break是跳出for 循环 continue是这次跳出 然后继续循环

#### 连续几个if记得不要忘了else！是if else if else if。。

#### Stack 新建

- Stack<Integer> points = new Stack<Integer>();

#### 字符串cp要用 equals 不要用 ==！！！

#### 遍历字符串数组 

- for(String ccc: ops){}

#### arraylist 的 2维数组

ArrayList[] graph = new ArrayList[numCourses];

        for (int i = 0; i < numCourses ; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        (int)graph[i].get(j) //从Integer变成int


        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length ; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
#### regular expression —regx

https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html

#### string to char array

       for(char c : word.toCharArray()){}
       // directly go to locate it
       word.charAt(0)

#### string length vs. array length

```
word.length()
array.length
```

#### 数一个数的二进制有多少个1

    public int hammingDistance(int x, int y) {   
       int b= (x ^ y);
        int c=0;
        while(b>0) {
            c+=1;
            b&=(b-1);
        }
        return c;
    }
####  数据范围判断 if 条件 while 条件都写前面

```
return (Integer.bitCount(n) == 1 && n > 0);
return (n > 0 && Integer.bitCount(n) == 1 );
```

#### bit manipulation 歧义 运算符顺序

 ```
return (n> 0 && (n & (n-1)) == 0 );
return ( n>0 && n & (n-1 == 0));
 ```

#### object 新建了之后没有new 则是null  被new了之后是size==0

#### 遍历map set里面的元素：

```
Iterator<Integer> iter = num.iterator();
            while(iter.hasNext()){
                sum.add(iter.next()+number);
            }
```

#### String split 

```
String[] splitS = s.split(" ");
//这只是按一个空格分隔！！！多个空格也要分呀！！所以用
String[] splitS = s.split(" +");
```

#### Map Entry 遍历 hashmap

```
for(Map.Entry<Integer,Integer> entry : res.entrySet()){
            min = Math.min(min,wall.size()-entry.getValue());
        }
```

- 554

#### 实现stack

不要用stack 是个古老的类 用deque来实现吧

```
Deque<TreeNode> stack = new ArrayDeque<>();
stack.push(root);
TreeNode node = stack.pop();
```

- 236

#### arraylist/ linkedlist插入值插到前面或特定位置

```
res.add(0, root.val);
```

