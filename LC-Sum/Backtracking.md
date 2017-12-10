一般回溯的问题有三种：

1. Find a path to success 有没有解
2. Find all paths to success 求所有解
   - 求所有解的个数
   - 求所有解的具体信息
3. Find the best path to success 求最优解



理解回溯：给一堆选择, 必须从里面选一个. 选完之后我又有了新的一组选择. This procedure is repeated over and over until you reach a final state. If you made a good sequence of choices, your final state is a goal state; if you didn't, it isn't.

回溯可以抽象为一棵树，我们的目标可以是找这个树有没有good leaf，也可以是问有多少个good leaf，也可以是找这些good leaf都在哪，也可以问哪个good leaf最好，分别对应上面所说回溯的问题分类。
good leaf都在leaf上。good leaf是我们的goal state，leaf node是final state，是解空间的边界。



如果一个问题的子问题和自身类似，只是规模和条件上发生变化，那么一套代码就可以解决二者，这就是递归。如果一个问题的解存在于一个可以深度遍历的解空间中，通过深度优先遍历找到解的过程就是回溯。
回溯有的时候可以用递归解决