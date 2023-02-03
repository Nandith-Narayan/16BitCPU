package statements;

public class Label extends Statement{
    public String name;
    public Label(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Label: "+name;
    }
}
