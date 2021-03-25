import java.util.List;

public class Instance {
    private String label;
    private List<String> features;

    public Instance(String label, List<String> features){
        this.label = label;
        this.features = features;
    }

    public String getLabel(){
        return this.label;
    }

    public List<String> getFeatures(){
        return this.features;
    }

}
