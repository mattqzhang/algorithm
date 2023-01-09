/*
Find common nodes in two BST
*/

// Function to print common elements in given two trees
static void printCommon(Node root1, Node root2) {
    Stack<Node> stack1 = new Stack<Node>();
    Stack<Node> s1 = new Stack<Node>();
    Stack<Node> s2 = new Stack<Node>();

    while (true) {
        // push the left nodes of first tree in stack s1, top of stack is the smallest value 
        if (root1 != null) {
            s1.push(root1);
            root1 = root1.left;
        }

        // push the right nodes of second tree in stack s2, top of stack is the smallest value 
        else if (root2 != null) {
            s2.push(root2);
            root2 = root2.left;
        }

        // Both root1 and root2 are NULL here
        else if (!s1.isEmpty() && !s2.isEmpty()) {
            root1 = s1.peek();
            root2 = s2.peek();

            // If current keys in two trees are same
            if (root1.key == root2.key) {
                System.out.print(root1.key + " ");
                s1.pop();
                s2.pop();

                // move to the inorder successor, go back to top of loop to push to stack
                // if any of the right is empty, it'll skip to pop from stack head
                root1 = root1.right;
                root2 = root2.right;
            } else if (root1.key < root2.key) {
                // If Node of first tree is smaller than that of second tree,
                // then we discard it from stack and look for the the inorder successors
                // If root1 has right child, then the successor is in its right tree,
                //      and we go back to top of loop, to push them to stack.
                // else if right is null, we will go to the stack top, which is root1's parent node
                s1.pop();
                root1 = root1.right;

                // root2 is set to NULL, because we don't need new nodes from s2
                root2 = null;
            } else if (root1.key > root2.key) {
                s2.pop();
                root2 = root2.right;
                root1 = null;
            }
        }

        // Both roots and both stacks are empty
        else break;
    }
}
