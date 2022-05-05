public class Node {
    private int info;
    private Node sx;
    private Node dx;

    public Node(int o) {
        info = o;
        sx = null;
        dx = null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getSx() {
        return sx;
    }

    public Node getDx() {
        return dx;
    }

    public void setSx(Node sx) {
        this.sx = sx;
    }

    public void setDx(Node dx) {
        this.dx = dx;
    }

    @Override
    public String toString(){
        return "[" + info+ "]";
    }

}