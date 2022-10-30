package anything.shell;

import java.io.*;
import java.util.stream.Collectors;

public class Shell{
    public static String run(String command) throws IOException{
        Process proc = Runtime.getRuntime().exec("sh");
        InputStream procI = proc.getInputStream();
        DataOutputStream procO = new DataOutputStream(proc.getOutputStream());

        //write the command and flush
        procO.writeBytes(command + "\n");
        procO.flush();


        //exit after
        procO.writeBytes("exit\n");
        procO.flush();

        //then close the stream
        procO.close();
        
        BufferedReader res = new BufferedReader(new InputStreamReader(procI));
        return res.lines().parallel().collect(Collectors.joining("\n"));
    }
}
