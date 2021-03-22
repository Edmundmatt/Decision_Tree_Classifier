public class Node {

    private int attribute;
    private double probability;
    private Node left;
    private Node right;

    public Node(int att, Node left, Node right){
        this.attribute = att;
        this.left = left;
        this.right = right;
    }

//    public void setHepInstance(HepInstance hepInstance) {
//        this.hepInstance = hepInstance;
//    }
//
//    public HepInstance getHepInstance() {
//        return hepInstance;
//    }

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
}
