/*
Convert BST to array and ArrayList
*/

/* to ArrayList */
public ArrayList<Integer> bstToArrayList(Node node, ArrayList<Integer> al)
{ 
   if(node == null)
      return al;
   bstToArrayList(node.left, al);
   al.add(node.value);
   bstToArrayList(node.right, al);
   return al;
}


/* to arrar
 NOTE: it would be better to convert to ArrayList first, then copy to array
*/

int size = countNodes(root, 0);
int arr = new int[size];
int index = 0;  // global index, increase with the dfs from left to right, min to max

void bstToArray(Node node){
  if(node == null)
       return;

  bstToArray(node.left);
  array[index++] = node.value; // index++ while traversing min to max
  bstToArray(node.right);
}

