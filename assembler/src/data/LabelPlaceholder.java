package data;

public class LabelPlaceholder extends Data{
    String label;
    public LabelPlaceholder(String label){
        this.label = label;
    }

    public String toString(){
        return "Label: "+label;
    }


}
