# Two pointers 

Template:

- one/two to record the insertion position
- one for iterating





## 2 heads

#### 283 move zeroes

—> move all 0 to the end

—> maintain non-zeros' order

—> in place 

—> ⬇minimize # operations



##### Flash:

- while(start<end) swap start and end?

Nope. you should not change the original order of the non-zeros.

- So we cannot swap. 
- Why not try Replace? ( 👍)

(record the insert position index.)

- Swap really does not work? [Combine swap and two pointer]

both pointers start from 0. One is to traverse, one is to record non-zero (insert position).  if non-zero, swap (actually nothing changes.) When zeroes, the latter one stays there and waiting for swapping. Then it is good. and continues swapping each time.



## 3 pointers

#### 75 sort colors

—> count sort ( O(n)) but two pass

—> can you only one pass and constant space?

##### Flash:

- Swap, ***two pointers record the insert position,*** one iterating.



# Transformation

## consider groups

#### 273 integer to english words

Flash:

- Similar to the roman number problem.
- divide cases into groups. and then convert.



## consider digits

#### 67 add binary

##### Flash:

—> cannot directly transform back to integer, overflow!!!

—> use stringbuilder compute "carry" and "sum"

—> from stringbuilder to string costs time, can we directly use char[] to construct string? this is faster! —> which means add char in place! 



#### 43 multiply strings

—> cannot use built-in BigInteger library

—> cannot convert inputs to integer!!!! (see the above one. 67 —> actually will overflow, it does not work)

##### Flash:

- similar to ***67***
- but need some ***tricks*** — connect results from single two digits to the corresponding positions in final results
- convert string to charArray and then visit it is ***much faster*** than call string.charAt every time!



## choose a good base

#### 168 excel sheet column title

##### Flash:

```java
s = (char) (n%26 + 64) + s; 
n = n/26;
```

I used this 👆 and i got stuck at "26 Z AZ " and other test cases

but if you change like this: 👇

```Java
s = (char) ((n-1)%26 + 65) + s; 
n = (n-1)/26;
```

Remember "0" is important! 

when you are converting, it's always from 0 and not include the base!



大厂喜欢玩算法和oop，小厂喜欢问基础知识，网上自行准备java面试经典50问