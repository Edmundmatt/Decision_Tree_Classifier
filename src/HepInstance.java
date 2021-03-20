import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HepInstance {
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
