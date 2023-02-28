// Tham khao src ko dung de quy + hay hon:
// https://www.happycoders.eu/algorithms/binary-search-tree-java/

public class BinarySearchTree
{
    // properties
    public Node root ;
    // private int size = 0 ;

    // constructor mac dinh se duoc tao tu dong
    public BinarySearchTree()
    {
        this.root = null ;
    }

    public boolean isEmpty()
    {
        return this.root == null ;
    }

    public Node getRoot()
    {
        return root ;
    }

    /* check if this is a binary search tree
    public boolean isBST(Node root, Integer min, Integer max) 
    {
        if (root == null) return true;
            
        if(root.getValue() >= min && root.getValue() <= max
            && isBST(root.getLeft(), min, root.getValue()) 
            && isBST(root.getRight(), root.getValue(), max))
            return true;
        
        return false;
    }*/

    public void add(int key) 
    {
        root = add(root, key) ;  // ham de quy phu tro (su dung overload)
    }

    public Node add(Node root, int key) 
    {
        if(root == null)              return new Node(key);
        else if(root.value > key)     root.left = add(root.left, key) ; 
        else if(root.value < key)     root.right = add(root.right, key) ; 
        else                          System.out.println(key + " is already exist !\n") ;

        return root;
    }

    // used for remove()
    public int findMaxLeft(Node root) 
    {
        if (root.right != null)    return findMaxLeft(root.right) ;
        else                       return root.value ;    
    }

    public void remove(int key) 
    {
        remove(root, key);
    }

    public Node remove(Node root, int key) 
    {
        if(root == null)   return null;
            
        else if(key < root.value)     root.left = remove(root.left, key) ;  
            
        else if(key > root.value)     root.right = remove(root.right, key) ;
             
        else
            // TH1: co 2 con ben trai va phai
            if(root.left != null && root.right != null) 
            {
                int leftMax = findMaxLeft(root.left) ;

                root.value = leftMax ;  
                root.left = remove(root.left, leftMax) ;

                return root;
            }
           
            // TH2: co 1 dua con ben trai
            else if(root.left != null)    return root.left ;
            
            // TH3: co 1 dua con ben phai
            else if(root.right != null)   return root.right ;
                
            // TH 4: vo sinh
            else                          return null ;
        
        return root;
    }

    // xoa Node co value lon nhat
    public void removeMax()
    {
        remove(findMaxNode(root).value) ;
    }

    // xoa Node co value nho nhat
    public Node removeMin(Node root)
    {
        if (root.left == null)  return root.right;
 
        root.left = removeMin(root.left);
 
        return root ;
    }

    public boolean search(Node root, int key)
    {
        
        /* if(!isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
        {
            System.out.println("This is not a BST !\n") ;
            return false ;
        }*/

        if(root == null) return false ;  // Not found !

        if(key == root.value)     return true ;
        else if(key < root.value) return search(root.left, key) ;
        else                      return search(root.right, key) ; 
    }

    public void NLR(Node root)  // pre-order
    {
        if(isEmpty())       System.out.println("Empty BST !\n") ;

        if(root == null)    return ;  // finished

        System.out.print(root.value + " ") ;
        NLR(root.left) ;
        NLR(root.right) ;
    }

    public void LRN(Node root)  // post-order
    {
        if(isEmpty())       System.out.println("Empty BST !\n") ;

        if(root == null)    return ;  // finished

        LNR(root.left);
        LNR(root.right);
        System.out.print(root.value + " ");  
    }

    // in cac phan tu trong cay theo thu tu tang dan
    public void LNR(Node root)  // in-order
    {
        if(isEmpty())       System.out.println("Empty BST !\n") ;

        if(root == null)    return ;  // finished

        LNR(root.left);
        System.out.print(root.value + " ");
        LNR(root.right);
        
    }

    // in cac phan tu trong cay theo thu tu giam dan
    public void RNL(Node root)  
    {
        if(isEmpty())       System.out.println("Empty BST !\n") ;

        if(root == null)    return ;  // finished

        RNL(root.right);
        System.out.print(root.value + " ");
        RNL(root.left);
    }

    // tim Node co value lon nhat trong cay
    public Node findMaxNode(Node root) 
    {
        if(root.right == null) return root ;
        
        return findMaxNode(root.right) ;
    }

    // tim Node co value nho nhat trong cay
    public Node findMinNode(Node root) 
    {
        if (root.left == null) return root ;

        return findMinNode(root.left) ;
    }

    // lay chieu cao cua cay
    public int getHeight()
    {
        return getHeight(root) ;
    } 

    public int getHeight(Node root)
    {
        if(root == null)    return 0 ;
        
        return 1 + Math.max(getHeight(root.left), getHeight(root.right)) ;
    }

    // tinh tong cac phan tu trong cay
    public int sum()
    {
        return sum(root) ;
    }

    public int sum(Node root)
    {
        if(root == null)    return 0 ;

        return root.value + sum(root.left) + sum(root.right) ;
    }
}