# Arrays and Strings 

#### Hash Tables 

---



- a shocking number of interview problems can be solved with hash tables. SO —>

  ⚠️ parctice both USING and IMPLEMENTING hash tables.



#### ArrayList

---



- dynamically resizing array
- is an array that resizes itself as needed while still providing ***O(1)*** access.
- typical implementation: when it is full, it will ***doubles in size***. Each doubling takes ***O(n)*** time buthappens so rarely that its amortized(分摊下来的) time is still ***O(1)***.  
- ​




#### StringBuffer / StringBuilder

---

- each time you append a string to sth., you create ***a copy*** of it and run through all characters to copy them over.



# Linked Lists

Linked Lists questions are quite common. From simple (delete a node in a linked list) to much more challenging. 

You should be able to manipulate a linked list in the simplest ways.

You should be able to easily write these 👇 codes prior to your interview.

⚠️ when you are discussing a linked list in an interview, make sure to understand whether it's a ***single / doubly*** linked list!!!!

- create a linked list
- delete a node from a singly linked list
- ….



# Stacks and Queues

Implementing a stack / a queue:



# Trees and Graphs

These questions come in one of two forms:

- implement a tree/ find a node/ delete a node/ other well known algorithm
- implement a modification of a known algorithm

⚠️ Understand the important tree algorithms!!!!!

⚠️Not all binary trees are binary search trees!!!! (when given a ***binary tree*** question, don't assume that it is a ***"binary search tree"*** !! ask and confirm!!! A BINARY TREE means a tree with no particular ordering on the nodes.)

Must-know: (tree)

- In-order
- Pre-order
- Post-order
- Insert Node

⚠️ Balancing and deletion of binary search trees are rarely asked, but you might want to have some idea how they work. it can set you apart from other candidates.

Must-know: (graph)

- BFS: searching a node and its siblings before going to any children.
- DFS: searching a node and all its children before proceeding to its siblings.