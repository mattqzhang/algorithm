/*
In order print two BST tree
we can do it by in-order print each tree, then merge sort. But the iterative way is better (true in-order)
*/

void printTwoBST(Node root1, Node root2){

  Stack<Node> stack1 = new Stack<Node>();
  Stack<Node> stack2 = new Stack<Node>();  
  Node cur1 = root1;
  Node cur2 = root2;

  while(true){
    while(cur1 != null){
      stack1.push(cur1);
      cur1 = cur1.left;
    }
    while(cur2 != null){
      stack2.push(cur2);
      cur2 = cur2.left;
    }        
    
    if(stack1.empty() && stack2.empty())
       break;
         
    cur1 = stack1.peek();
    cur2 = stack2.peek();
    Node next;
    if(cur2 == null || cur1.val < cur2.val){
      next = stack1.pop();
      cur1 = next.right;
    } else {
      next = stack2.pop();
      cur2 = next.right;
    }

    System.out.println(next.val + ", ");
  }
}

