public class AVL_Tree{
    public static void main(String[] args) {
        
    }
}
class AvlTree{
    public long data;
    public AVL_Tree left;
    public Avl_Tree right;
    public int height=0;

    //The Function that Returns the Height of an AVL Node
    int Height (AVL_Tree p){
        if(p==null)
        return -1;
        else
        {
            return p.height;
        }
    }
    //The Addition Function For the AVL Tree
    public Avl_Tree insert(Avl_Tree p, int x){
        if(p==null){
            p=new AVL_Tree();
            p.data = x;
        }
        else{
            if(x<p.data){
                p.left = insert(p.left,x);
                if(Height(p.height)-Height(p.right)==2)
                 if(x<p.left.data)
                 p= singlerotateright(p);
                 else p = doublerotateright(p);
                else if (x > p.data){ 
                    p.right = insert(p.right, x);
                    if (Height(p.left) - Height(p.right) == -2)
                    if (x > p.right.data)
                    p = singlerotateleft(p);
                    else p = doublerotateleft(p);
                }
            }
            p.height = max(Height(p.left),Height(p.right)) + 1;
            return p;
        }
        int max(int a, int b){
            if(a>b) return a;
            else return b;
        }
    }
    AvlAgac singlerotateright(AvlAgac p){
        AvlAgac lc = p.left;
        p.left = lc.right;
        lc.right = p;
        p.height = max(Height(p.left), Height(p.right)) + 1;
        lc.height = max(Height(lc.left), lc.height) + 1;
        return lc;
    }
    AvlAgac doublerotateright(AvlAgac p){
        p.left = singlerotateleft(p.left);
        return singlerotateright(p);
    }
    AvlAgac singlerotateleft(AvlAgac p){
        AvlAgac rc = p.right;
        p.right = rc.left;
        rc.left = p;
        p.height = max(Height(p.left), Height(p.right))+1;
        rc.height = max(Height(rc.right), rc.height)+ 1;
        return rc;
    }
    AvlAgacdoublerotateleft(AvlAgac p){
        p.right = singlerotateright(p.right);
        return singlerotateleft(p);
    }

}