package data;

public class RawData extends Data{

    int data;
    public RawData(int data){
        this.data = data;
    }

    public String toString(){
        return "Data: "+data;
    }

}
