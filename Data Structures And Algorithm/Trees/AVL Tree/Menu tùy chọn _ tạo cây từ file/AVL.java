// AVL extends BST: https://www.happycoders.eu/algorithms/avl-tree-java/
import java.util.* ;

public class AVL 
{
    public Node root;

    // lay chieu cao
    public int getHeight(Node node) 
    {
        if(node == null)    return -1 ;

        return node.height ;
    }

    // cap nhat lai chieu cao sau khi thuc hien can bang
    public void updateHeight(Node node) 
    {
        int leftChildHeight  = getHeight(node.left) ;
        int rightChildHeight = getHeight(node.right) ;

        node.height = Math.max(leftChildHeight, rightChildHeight) + 1;
    }

    // lay chi so can bang
    public int getBalance(Node node) 
    {
        if(node == null)    return 0 ;

        return getHeight(node.right) - getHeight(node.left);
    }

    // can bang lai cay sau khi them, xoa
    public Node reBalance(Node node) 
    {
        /*
          * case 1: node's balance < -1 && left's balance <= 0 -> right rotation node
          * case 2: node's balance < -1 && left's balance > 0 -> left rotation left && right rotation node
          * case 3: node's balance >  1 && right's balance >= 0 -> left rotation node
          * case 4: node's balance >  1 && right's balance < 0 -> right rotation && left rotation node
        */

        // Left is heavier
        if(getBalance(node) < -1) 
        {   
            // case 1 -> rotate right
            if(getBalance(node.left) <= 0)  node = rotateRight(node);   
            
            // case 2  -> rotate left-right
            else 
            {                               
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }
      
        // Right is heavier
        else if(getBalance(node) > 1) 
        {
            // case 3 -> rotate left
            if(getBalance(node.right) >= 0)      node = rotateLeft(node);
            
            // case 4 -> rotate right-left
            else 
            {                                
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }
      
        return node;
    }

    // quay phai
    public Node rotateRight(Node node) 
    {
        Node leftChild = node.left ;

        node.left = leftChild.right ;
        leftChild.right = node ;

        updateHeight(node) ;
        updateHeight(leftChild) ;

        return leftChild ;
    }

    // quay trai
    public Node rotateLeft(Node node) 
    {
        Node rightChild = node.right;

        node.right = rightChild.left;
        rightChild.left = node;

        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    public Node add(Node node, int key) 
    {
        if(node == null)            return new Node(key); 
        
        if(key < node.value)        node.left = add(node.left, key);
        else if(key > node.value)   node.right = add(node.right, key);
        else return node ;

        updateHeight(node);
        
        return reBalance(node);
    }

    // su dung cho ham remove()
    public Node removeMin(Node x) 
    {
        if(x.left == null)     return x.right;
        
        x.left = removeMin(x.left);

        return x;
    }

    public Node remove(Node node, int key) 
    {
        if(node == null)     return null;
           
        int cmp = ((Integer)key).compareTo((Integer)node.value);

        if(cmp < 0)       node.left = remove(node.left, key);
        else 
            if(cmp > 0)   node.right = remove(node.right, key);
            else 
            {
                // TH1: node co 1 con hoac ko co con
                if (node.right == null)     return node.left;
                if (node.left == null)      return node.right;
                    
                // TH2: node co 2 con
                Node t = node;

                node = getMin(t.right);
                node.right = removeMin(t.right);

                // thay the node
                node.left = t.left;
            }
        
        updateHeight(node);
        return reBalance(node);
    }

    public boolean search(Node node, int key)
    {
        if(node == null) 
            return false ;  // Not found !

        if(key == node.value)     return true ;
        else if(key < node.value) return search(node.left, key) ;
        else                      return search(node.right, key) ; 
    }

    // lay phan tu nho nhat
    public Node getMin(Node node) 
    {
        if(node == null)       return null;

        if(node.left == null)  return node;     
        else                   return getMin(node.left);     
    }

    // lay phan tu lon nhat
    public Node getMax(Node x) 
    {
        if(x == null)           return null;

        if(x.right == null)     return x;   
        else                    return getMax(x.right);
    }

    // using NLR
    public void print(Node node) 
    {
        if (node != null) 
        {
            System.out.print(node.value + " ");
            print(node.left);
            print(node.right);
        }
    }
    
    /* print ra hinh mot cai cay
    public <T extends Comparable<?>> void printNode(Node root) 
    {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private <T extends Comparable<?>> void printNodeInternal(List<Node> nodes, int level, int maxLevel) 
    {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<Node>();

        for (Node node : nodes) 
        {
            if (node != null) 
            {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } 
            else 
            {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }

        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) 
        {
            for (int j = 0; j < nodes.size(); j++) 
            {
                printWhitespaces(firstSpaces - i);

                if (nodes.get(j) == null) 
                {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)  System.out.print("/");
                else                            printWhitespaces(1);
                
                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null) System.out.print("\\");
                else                            printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private void printWhitespaces(int count) 
    {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private <T extends Comparable<?>> int maxLevel(Node node) 
    {
        if (node == null)   return 0;
            
        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private boolean isAllElementsNull(List list) 
    {
        for(Object object : list) 
            if (object != null)
                return false;

        return true;
    }
    */
}
