public class Node {

    private String attribute;
    private String classLabel;
    private double probability;
    private Node left;
    private Node right;
    private Boolean leaf;

    public Node(String att, Node left, Node right){
        this.attribute = att;
        this.left = left;
        this.right = right;
    }

    public Node(String classLabel, double prob){
        this.classLabel = classLabel;
        this.probability = prob;
        this.left = left;
        this.right = right;
        this.leaf = true;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public double getProbability() {
        return probability;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

    public Boolean isLeaf(){ return leaf; }

}
