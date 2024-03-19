package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Shell implements IO{
    private final BufferedReader in;
    private final PrintWriter out;

    public Shell(BufferedReader in, PrintWriter out){
        this.in = in;
        this.out = out;
    }

    @Override
    public String input() throws IOException {
       return this.in.readLine();
    }

    @Override
    public void output(String str) {
        this.out.print(str);
    }

    @Override
    public void flush() {
        this.out.flush();
    }
}
