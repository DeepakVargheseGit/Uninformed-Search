DEEPAK VARGHESE 

The programming language used is Java.


Code Structure

1)The code starts with the input arguments being passed and the input text file being read and stored in data list.

2)Then the source is used to create the node using class state_node and added to the fringe.

3)Then the data is removed from fringe and added to present_state and also added to state_visited.

4)Using present_state we check the data list and get the child nodes from it and create them and calculates the cost as well.

5)The loop continues for different nodes and checks if present in state_visited or not.

6)Once goal state is reached or not found the final cost and route is shown . A recursive function is used to display the cost.

7)The Cost_Comparator class helps in calculating the optimal path cost.


Compilation Instructions

javac find_route.java
java find_route input.txt source destination


References 

1) https://www.w3resource.com/java-tutorial/arraylist/arraylist_sort.php

2) https://www.tutorialspoint.com/java/lang/float_compare.htm

3) https://beginnersbook.com/2013/12/java-arraylist/

4) https://www.youtube.com/watch?v=3RNYUKxAgmw 

5) http://www.baeldung.com/java-stringtokenizer



