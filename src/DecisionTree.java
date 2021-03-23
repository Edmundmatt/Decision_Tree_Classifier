import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecisionTree {
    int numCategories;
    int numAtts;
    List<String> categoryNames;
    List<String> attNames;
    List<HepInstance> allInstances;

    public DecisionTree(String fileName, Boolean completedTree){
//        read("C:\\Users\\Matthew\\IdeaProjects\\COMP307Assignment1Part2\\data\\hepatitis-training");
        read(fileName);
    }
    public static void main(String[] args){

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
                    //besInstsFalse = set of false instances
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

        return instances.stream()
                .map(HepInstance::getCategory)
                .distinct()
                .limit(2)
                .count() <= 1;
        return true;
    }

    private static double computePurity(List<Node> instances, int atrbIndex){
        //Check that this correct (skipping the class as the first atrb)
        double purity = 0;
        List<Double> list = new ArrayList<>();

        return purity;
    }

    private static void highestProb(){

    }

    /**-----------------------------------------------------------*/

    private void read(String fileName){
        System.out.println("Reading data from file: "+fileName);
        try{
            Scanner din = new Scanner(new File(fileName));

            categoryNames = new ArrayList<>();
            for (Scanner s = new Scanner(din.nextLine()); s.hasNext();) categoryNames.add(s.next());
            numCategories=categoryNames.size();
            System.out.println(numCategories +" categories");

            attNames = new ArrayList<>();
            for (Scanner s = new Scanner(din.nextLine()); s.hasNext();) attNames.add(s.next());
            numAtts = attNames.size();
            System.out.println(numAtts +" attributes");

            allInstances = readInstances(din);
            din.close();

        }catch(IOException e){
            throw new RuntimeException("Data File caused IOException");
        }
    }

    private List<HepInstance> readInstances(Scanner din){
        /* instance = classname and space separated attribute values */
        List<HepInstance> hepInstances = new ArrayList<>();
        while (din.hasNext()){
            Scanner line = new Scanner(din.nextLine());
            hepInstances.add(new HepInstance(categoryNames.indexOf(line.next()),line));
        }
        System.out.println("Read " + hepInstances.size()+" instances");
        return hepInstances;
    }

    private class HepInstance {
        //    private final List<String> categoryNames;
        private final int category;
        private final List<Boolean> values;

        public HepInstance(int category, Scanner s){
            this.category = category;
            this.values = new ArrayList<>();
            while (s.hasNextBoolean()) values.add(s.nextBoolean());
        }

        public boolean getAtt(int index){
            return values.get(index);
        }

        public int getCategory(){
            return category;
        }

    public String toString(){
        StringBuilder ans = new StringBuilder(categoryNames.get(category));
        ans.append(" ");
        for (Boolean val : values)
            ans.append(val?"true  ":"false ");
        return ans.toString();
    }

    }

}

