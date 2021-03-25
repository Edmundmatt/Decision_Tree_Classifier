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
        this.leaf = false;
    }

    public Node(String label, double prob){
        this.label = label;
        this.probability = prob;
        this.leaf = true;
    }

    public String getFeature(){
        return this.feature;
    }

    public String getLabel(){
        return this.label;
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

    public void report(String indent){
        System.out.printf("%s%s = True:%n", indent, feature);
        if(left.isLeaf())left.reportLeaf(indent);
        else left.report(indent+"\t");
        System.out.printf("%s%s = False:%n", indent, feature);
        if(right.isLeaf()) right.reportLeaf(indent);
        else right.report(indent+"\t");
    }

    public void reportLeaf(String indent){
        if (probability==0){ //Error-checking
            System.out.printf("%sUnknown%n", indent);
        }else{
            System.out.printf("%sClass %s, prob=%.2f%n", indent, label, probability);
        }}


}
