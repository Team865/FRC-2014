package ca.warp7.frc2014.autonomous;


import ca.warp7.robotlib.parents.AutoMode;
import ca.warp7.robotlib.util.CheesyVisionServer;
import ca.warp7.robotlib.util.Util;
import com.sun.squawk.microedition.io.FileConnection;
import com.sun.squawk.util.NotImplementedYetException;

import javax.microedition.io.Connector;
import java.io.DataInputStream;
import java.io.IOException;


public class Block extends AutoMode {
    private CheesyVisionServer server;
    String currentDefenseMode;

    public void init() {

        throw new NotImplementedYetException("Blocking Auton is not implemented!");
        //ignore dis
        /*
        server = CheesyVisionServer.getInstance();
        server.setPort(1180);
        server.start();
        server.startSamplingCounts();
        */

    }

    public void disable() {

        server.stopSamplingCounts();
        server.stop();
    }

    public void tick() {
        System.out.println("Current left: " + server.getLeftStatus() + ", current right: " + server.getRightStatus());
        System.out.println("Left count: " + server.getLeftCount() + ", right count: " + server.getRightCount() + ", total: " + server.getTotalCount() + "\n");
    }

    /**
     * Reads the info file and overrides the values in this class for any info it contains.
     */
    /*
    public static void readFile(String team) {
        DataInputStream infoStream;
        FileConnection infoFile;
        byte[] buffer = new byte[512];
        String content = "";

        try {
            // Read everything from the file into one string.
            infoFile = (FileConnection) Connector.open("file:///" + team + ".txt",
                    Connector.READ);
            infoStream = infoFile.openDataInputStream();
            while (infoStream.read(buffer) != -1) {
                content += new String(buffer);
            }

            // Gotta close these cause WPILibJ was (badly) ported from c.
            infoStream.close();
            infoFile.close();


            //split on semicolons;

            String[] commands = content.split(";");
            for (int i = 0; i < commands.length; i++) {
                //loop through and do..something about this?
                    String currCommand = commands[i];
                    if(currCommand.startsWith("f")) { //Forwards
                        double amt = Integer.parseInt(currCommand.substring(1));
                    } else if(currCommand.startsWith("b")) { //Backwards
                        double amt = Integer.parseInt(currCommand.substring(1));
                    } else if(currCommand.startsWith("s")) { //Stop

                    }
            }
        } catch (IOException e) {
            Util.log("Block", "wat.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */

}
