abstract public class Node extends Utility {
  protected Node left;
  protected Node right;

  public Node() {this.left = null; this.right = null;}
  public Node go_left() {return this.left;}
  public Node go_right() {return this.right;}
  public void connect_left(Node connection) {this.left = connection;}
  public void connect_right(Node connection) {this.right = connection;}
}
