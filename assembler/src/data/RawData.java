package data;

import java.util.HashMap;

public class RawData extends Data{

    int data;
    public RawData(int data){
        this.data = data;
    }

    public String toString(){
        return "Data: "+data;
    }

    public int emit(HashMap<String, Integer> labelMap){
        return data;
    }

}
