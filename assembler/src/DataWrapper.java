public class DataWrapper {
    public static enum TYPE {INT, STRING};
    public TYPE type;
    public int integer;

    public DataWrapper(int val){
        this.type = TYPE.INT;
        this.integer = val;
    }
}
