package data;

import java.util.HashMap;

public class LabelPlaceholder extends Data{
    String label;
    public LabelPlaceholder(String label){
        this.label = label;
    }

    public String toString(){
        return "Label: "+label;
    }

    public int emit(HashMap<String, Integer> labelMap){
        return labelMap.get(label);
    }

}
