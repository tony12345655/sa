package IO;

import java.io.IOException;

public interface IO {

    public String Input() throws IOException;
    public void Output(String str);

    public void Flush();
}
