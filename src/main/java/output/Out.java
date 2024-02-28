package output;

import java.io.PrintWriter;

public class Out {
    private static PrintWriter instance;

    private Out(){};

    public static PrintWriter getInstance(){
        if (instance == null)
            throw new Error("please set output first");
        return  instance;
    }

    public static void setInstance(PrintWriter out){
        instance = out;
    }

}
