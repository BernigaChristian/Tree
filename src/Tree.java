/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 05/05/2022, giovedì
 **/
public class Tree {
    private int elements;
    private Node root;

    public Tree(){
        root = null;
        elements = 0;
    }

    public void add(int n){
        Node newNode = new Node(n);
        if(root == null)    root = newNode;
        else add(root,newNode);
    }

    private void add(Node temp,Node n){
        if(n.getInfo() <= temp.getInfo()){
            if(temp.getSx() == null)    temp.setSx(n);
            else    add(temp.getSx(),n);
        }
        else{
            if(temp.getDx() == null)    temp.setDx(n);
            else    add(temp.getDx(),n);
        }
    }

    public boolean isThere(int n){
        return isThere(root,n);
    }

    private boolean isThere(Node temp,int n){
        if(temp == null) return false;
        else if(temp.getInfo() == n) return true;
        else if(isThere(temp.getSx(),n))    return true;
        else if(isThere(temp.getDx(),n))    return true;
        else return false;
    }

    public void visit(){
        visit(root);
    }

    private void visit(Node temp){
        if(temp == null)    return;
        visit(temp.getSx());
        System.out.println(temp.getInfo());
        visit(temp.getDx());
    }

    public void lumberjack(int n){
        if(!isThere(n)) System.out.println("this number is not in the tree");
        else if(root.getInfo() == n)    root = null;
        else lumberjack(root,n);
    }
    private void lumberjack(Node temp, int n){
        if(temp == null)    return;
        if(temp.getSx() != null && temp.getSx().getInfo() == n) temp.setSx(null);
        else if(temp.getDx() != null && temp.getDx().getInfo() == n)    temp.setDx(null);
        else if(temp.getInfo() <= n)    lumberjack(temp.getDx(),n);
        else lumberjack(temp.getSx(),n);
    }
}

class Test{
    public static void main(String[] args) {
        Tree t = new Tree();
        t.add(10);
        t.add(1);
        t.add(2);
        t.add(4);
        t.add(3);
        t.add(11);
        t.add(20);
        t.add(14);
        t.add(12);
        t.visit();
        System.out.println("\n\n");
        t.lumberjack(20);
        t.visit();
    }
}
