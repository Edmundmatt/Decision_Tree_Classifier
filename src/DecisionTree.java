import java.util.ArrayList;
import java.util.List;

public class DecisionTree {

    public static void main(String[] args){
        FileManager fMTraining = new FileManager();
        fMTraining.read("C:\\Users\\Matthew\\IdeaProjects\\COMP307Assignment1Part2\\data\\hepatitis-training");
        FileManager fMTest = new FileManager();
        fMTest.read("C:\\Users\\Matthew\\IdeaProjects\\COMP307Assignment1Part2\\data\\hepatitis-test");

    }

    /**
     * Recursive method to build the decisionTree
     * @param instances
     * @param attributes
     */
    public static Node buildTree(List<Node> instances, List<String> attributes){
        int BestAtt;
        if(instances.isEmpty()){
            //Return leaf node containing the name and probability of the most probable class across the whole training set
        }else if(isPure(instances)){
            //Return a leaf node that contains the name of the class and probability 1
        }else if(attributes.isEmpty()){
            //Return a leaf node that contains the name and probability of the majority class of the instances (random if equal classes)
        }else{
            //Find the best attribute
            //for(each attribute not used yet)
                //Separate instances into two sets
                List<Node> atrbTrue = new ArrayList<>();
                //Compute purity of set
                List<Node> atrbFalse = new ArrayList<>();
                //Compute purity of set
                //if(weighted av. purity of the sets is best so far)
                    //bestAtt = this attribute
                    //bestInstsTrue = set of true instances
                    //besInstsFalse = set of flase instances
            //Build subTrees using remaining the remaining attributes
            //Node left = buildTree(bestInstsTrue, attributes - bestAtt)
            //Node right = buildTree(bestInstsFalse, attributes - bestAtt)
            }
        //return Node(bestAtt, left, right)
        return null;
        }

    /**
     * Returns boolean of whether all categories of a Node containing a HepInstance list are the same.
     * @param instances
     * @return
     */
    private static boolean isPure(List<Node> instances){

//        return instances.stream()
//                .map(HepInstance::getCategory)
//                .distinct()
//                .limit(2)
//                .count() <= 1;
        return true;
    }

    private static double computePurity(List<Node> instances, int atrbIndex){
        //Check that this correct (skipping the class as the first atrb)
        double purity = 0;
        List<Double> list = new ArrayList<>();

        return purity;
    }
}
