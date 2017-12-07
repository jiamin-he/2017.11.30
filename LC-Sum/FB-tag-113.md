# Two pointers 

## 2 heads

#### 283 move zeroes

—> move all 0 to the end

—> maintain non-zeros' order

—> in place 

—> ⬇minimize # operations



##### Flash:

—> while(start<end) swap start and end?

Nope. you should not change the original order of the non-zeros.

—> So we cannot swap. 

—> Why not try Replace? ( 👍)

(record the insert position index.)

—> Swap really does not work? [Combine swap and two pointer]

both pointers start from 0. One is to traverse, one is to record non-zero (insert position).  if non-zero, swap (actually nothing changes.) When zeroes, the latter one stays there and waiting for swapping. Then it is good. and continues swapping each time.



# Transformation

## consider groups

#### 273 integer to english words

Flash:

Similar to the roman number problem.

divide cases into groups. and then convert.







大厂喜欢玩算法和oop，小厂喜欢问基础知识，网上自行准备java面试经典50问