public class Node {

    private String feature;
    private String label;
    private double probability;
    private Node left;
    private Node right;
    private Boolean leaf;

    public Node(String feat, Node left, Node right){
        this.feature = feat;
        this.left = left;
        this.right = right;
    }

    public Node(String label, double prob){
        this.label = label;
        this.probability = prob;
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
