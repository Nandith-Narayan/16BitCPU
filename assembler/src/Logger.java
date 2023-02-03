public class Logger {
    static String[] colors = new String[]{"\u001b[37m", "\u001b[32m", "\u001b[36m"};

    public static void log(String s, int level){

        if(level > 1){
            s = "────"+s;
        }
        if(level > 0){
            s = "└───"+s;
        }
        s = colors[level] + s;
        System.out.println(s+"\u001b[37m");
    }
    public static void err(String s, int level){

        if(level > 1){
            s = "────"+s;
        }
        if(level > 0){
            s = "└───"+s;
        }
        s = "\u001b[31m" + s;
        System.out.println(s+"\u001b[37m");
    }

}
