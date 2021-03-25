import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class DecisionTree {
    private static List<String> categoryNames;
    private static int categoryNum;
    private static List<Instance> allInstances;

    public DecisionTree(String fileName){
        read(fileName);
        Node rootNode = buildTree(allInstances, categoryNames);
        outputTree(rootNode);


        read("C:\\Users\\Matthew\\IdeaProjects\\comp307assignment1part2v3\\data\\hepatitis-test");
        for(Instance instance : allInstances) testTree(rootNode, instance);

    }

    public static void main(String[] args){
        DecisionTree dT = new DecisionTree("C:\\Users\\Matthew\\IdeaProjects\\COMP307Assignment1Part2\\data\\hepatitis-training");
    }

    /**
     * Recursive method to build the decisionTree
     * @param
     * @param
     */
    public static Node buildTree(List<Instance> instances, List<String> features){
        String bestFeat = null;
        Node left;
        Node right;
        if(instances.isEmpty()){
            //Return a leaf node that contains the name and probability of the most probable class across the whole training set
            return highestProb(allInstances);
        }else if(isPure(instances)){
            //Return a leaf node that contains the name of the class and probability 1
            return new Node(instances.get(0).getLabel(), 1);
        }else if(features.isEmpty()){
            //Return a leaf node that contains the name and probability of the majority class of instances
            return highestProb(instances);
        }else{ //Find the best feature
            List<Instance> bestInstsTrue = new ArrayList<>();
            List<Instance> bestInstsFalse = new ArrayList<>();
            List<Double> impurities = new ArrayList<>();
            for(int i = 0; i < features.size(); i++){
                List<Instance> featTrue = new ArrayList<>();
                List<Instance> featFalse = new ArrayList<>();
                for(Instance inst : instances){
                    if(inst.getFeatures().get(i).equals("true")) featTrue.add(inst);
                    else featFalse.add(inst);
                }
                //Compute the impurity of each set
                //Think this means looking at the purity of the classification
                double trueImpurity = computeWeightedImpurity(featTrue);
                double falseImpurity = computeWeightedImpurity(featFalse);
                double weightAveImpurity = trueImpurity + falseImpurity;
                //If the weighted average purity of these sets is the best so far
                //Check that this is correct - so far in the loop of features?
                boolean check = true;
                if(!impurities.isEmpty()){
                    for(Double d : impurities){
                        if(d < weightAveImpurity) check = false;
                    }
                }
                impurities.add(weightAveImpurity);
                if(check){
                    bestFeat = features.get(i);
                    bestInstsTrue = featTrue;
                    bestInstsFalse = featFalse;
                }
            }
            //Build subtrees using remaining attributes
            features.remove(bestFeat);
            left = buildTree(bestInstsTrue, features);
            right = buildTree(bestInstsFalse, features);
        }
        return new Node(bestFeat, left, right);
    }

    /**
     * Traverse the created tree with testInstances - check accuracy of algorithm
     */
    public static void outputTree(Node node){
        node.report("");
    }

    /**
     * Test the algorithm's accuracy with test data
     * @param node
     */
    public static void testTree(Node node, Instance instance){

    }

    /**
     * Returns boolean of whether all categories of a Node are the same.
     * @param
     * @return
     */
    private static boolean isPure(List<Instance> instances){
        Instance prev = new Instance("junk", null);
        for(int i = 0; i < instances.size(); i++){
            if(!instances.get(i).getLabel().equals(prev.getLabel())) return false;
        }
        return true;
    }

    /**
     * Compute and return the weighted purity of a set of instances
     * @param instances
     * @return
     */
    private static double computeWeightedImpurity(List<Instance> instances){
        int aCount = 0;
        int bCount = 0;
        for(int i = 0; i < instances.size(); i++){
            if(instances.get(i).getLabel().equals("live")) aCount++;
            else bCount++;
        }
        double a = aCount;
        double b = bCount;
//        System.out.println(((a * b) / ((a + b)*(a + b))) * ((double)aCount / (double)instances.size()));
        return ((a * b) / ((a + b)*(a + b))) * ((double)aCount / (double)instances.size());
    }

    private static Node highestProb(List<Instance> instances){
        int aCount = 0;
        int bCount = 0;
        for(Instance inst : instances){
            if(inst.getLabel().equals("live")) aCount++;
            else bCount++;
        }
        int total = aCount + bCount;
        //Need a check if the classes have equal count
        Random random = new Random();
        if(aCount == bCount){
            if(random.nextBoolean()) return new Node("live", 0.5);
            else return new Node("die", 0.5);
        }
        String probableClass = (aCount > bCount) ? "live" : "die";
        double highestProb = (aCount > bCount) ? (double)aCount/(double)total : (double)bCount/(double)total;
        return new Node(probableClass, highestProb);
    }


    /**------------- Reading in data --------------*/

    private void read(String fileName){
        System.out.println("Reading data from file " + fileName);
        try{
            Scanner allIn = new Scanner(new File(fileName));

            categoryNames = new ArrayList<>();
            Scanner s = new Scanner(allIn.nextLine());
            s.next(); //Label is first
            while(s.hasNext()) categoryNames.add(s.next());
            categoryNum = categoryNames.size();

            allInstances = readInstances(allIn);

        }catch(IOException e){
            throw new RuntimeException("Data File caused IOException");
        }
    }

    private List<Instance> readInstances(Scanner allIn){
        List<Instance> instances = new ArrayList<>();
        while(allIn.hasNext()){
            Scanner line =  new Scanner(allIn.nextLine());
            String label = line.next();
            List<String> features = new ArrayList<>();
            while(line.hasNext()) features.add(line.next());
            instances.add(new Instance(label, features));
        }
        System.out.println("*-------Read " + instances.size() + " instances-------*");

        return instances;
    }

}

