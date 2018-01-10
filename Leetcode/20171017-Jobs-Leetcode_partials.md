#### 新定义comparator来自定义排序 

- Arrays. sort (array, new Compartator<...>()) 

  【252 meeting rooms】

```java
Arrays.sort(envelopes, (int[] a, int[] b) -> a[0] - b[0]);

Arrays.sort(envelopes, new Comparator<int[]>(){
        public int compare(int[] arr1, int[] arr2){
            if(arr1[0] == arr2[0])
                return arr2[1] - arr1[1];
            else
                return arr1[0] - arr2[0];
       } 
    });

Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                if(a[0] > b[0]) return 1;
                else if (a[0] < b[0]) return -1;
                else return a[1]-b[1];
            }
        });
```

#### 新定义的class

- 不要加public 

  【252 meeting rooms】

- 要放外面啊

- 不要两个不同的solution文件都定义一个相同的new class啊，一个solution建了就可以了

#### 自定义的priority queue的compare

- 【253 meeting rooms II — Solution2】

```java
Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {return i1.start - i2.start;}
        });
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2) {return i1.end - i2.end;}
        });
```



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

#### int[] is object

```
int[] inorderLeft = new int[i],  preorderLeft = new int[i]
不能写成
int[] inorderLeft = new int[i], preorderLeft = inorderLeft
```

不要贪一时方便 这样写 这两个数组怎么改都会变成一样的！

#### is it character or digit?

```
if(!Character.isLetterOrDigit(iChar))
```

#### backtracking template

```Java
public class Solution {
    public List<List<String>> partition(String s) {
       List<List<String>> res = new ArrayList<List<String>>();
       List<String> list = new ArrayList<String>();
       dfs(s,0,list,res);
       return res;
    }
    
    public void dfs(String s, int pos, List<String> list, List<List<String>> res){
        if(pos==s.length()) res.add(new ArrayList<String>(list));
        else{
            for(int i=pos;i<s.length();i++){
                if(isPal(s,pos,i)){
                    list.add(s.substring(pos,i+1));
                    dfs(s,i+1,list,res);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
```

#### StringBuilder reverse

```
String pair = new StringBuilder(cur.substring(j+1)).reverse().toString();
```

- 336

#### create string from char[]

```
char[] sc = s.toCharArray();
return new String(sc);
```

#### matrix 要扫附近8个时

```java
int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
for(int[] dir : dirs){
                    int x = i + dir[0];
                    int y = j + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && (board[x][y] == 1 || board[x][y] == 2)){
                        cnt++;
                    }
                }


//OR
public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
            for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
```

#### Arrays.binarySearch

```Java
for(int[] e: envelopes) {
            int index = Arrays.binarySearch(dp,0,size,e[1]);
            if(index < 0) index = -(index+1);
            dp[index] = e[1];
            if(index == size) size++;
        }
```

返回的是 if not contained -(insertionpoint+1) 

if contained, index.