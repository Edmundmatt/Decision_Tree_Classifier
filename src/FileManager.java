import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    int numCategories;
    int numAtts;
    List<String> categoryNames;
    List<String> attNames;
    List<HepInstance> allInstances;

    public void read(String fileName){
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
}
