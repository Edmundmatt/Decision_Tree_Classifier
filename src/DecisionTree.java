import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DecisionTree {
    private List<String> categoryNames;
    private int categoryNum;
    private List<Instance> allInstances;

    public DecisionTree(String fileName){
        read(fileName);
        Node rootNode = buildTree(allInstances, categoryNames);
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
        if(instances.isEmpty()){
            //Return a leaf node that contains the name and probability of the most probable class across the whole training set
        }else if(isPure(instances)){
            //Return a leaf node that contains the name of the class and probability 1
        }else if(features.isEmpty()){
            //Return a leaf node that contains the name and probability of the majority
        }else{
            for(int i = 0; i < features.size(); i++){
                List<Instance> featTrue = new ArrayList<>();
                List<Instance> featFalse = new ArrayList<>();
                for(Instance inst : instances){
                    if(inst.getFeatures().get(i).equals("true")) featTrue.add(inst);
                    else featFalse.add(inst);
                }
                //Compute the purity of each set
                //Think this means looking at the purity of the classification
                double truePurity = computePurity(featTrue);
                double falsePurity = computePurity(featFalse);
            }
        }
        return null;
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

    private static double computePurity(List<Instance> instances){

        return 0;
    }

    private static void highestProb(){

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

