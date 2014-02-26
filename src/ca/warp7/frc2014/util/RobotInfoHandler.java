package ca.warp7.frc2014.util;

import com.sun.squawk.microedition.io.FileConnection;

import javax.microedition.io.Connector;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: Ari
 * Date: 1/9/14
 * Time: 3:22 PM
 */
public class RobotInfoHandler {


    private static final Vector infoList = new Vector();
    private static final String INFO_FILE_PATH = "robotInfo.txt";


    /**
     * Reads the infos file and overrides the values in this class for any infos it contains.
     */
    public static void readInfoFromFile() {
        DataInputStream infoStream;
        FileConnection infoFile;
        byte[] buffer = new byte[512];
        String content = "";

        try {
            // Read everything from the file into one string.
            infoFile = (FileConnection) Connector.open("file:///" + INFO_FILE_PATH,
                    Connector.READ);
            if (!infoFile.exists()) {
                writeInfoToFile(); //yaaaaaaaaay
                Util.log("InfoValue", "File does not exist, creating.");
            }
            infoStream = infoFile.openDataInputStream();
            while (infoStream.read(buffer) != -1) {
                content += new String(buffer);
            }
            infoStream.close();
            infoFile.close();

            // Extract each line separately.
            String[] lines = Util.split(content, "\n");
            for (int i = 0; i < lines.length; i++) {
                // Extract the key and value.
                String[] line = Util.split(lines[i], "=");

                boolean found = false;
                // Search through the infoList until we find one with the same name.
                for (int j = 0; j < infoList.size(); j++) {
                    InfoValue info = (InfoValue) infoList.elementAt(j);
                    if (info.getKey().equals(line[0])) {
                        Util.log("InfoValue", "Setting " + info.getKey() + " to " + Double.parseDouble(line[1]));
                        info.setVal(Double.parseDouble(line[1]));
                        found = true;
                        break;
                    }
                    if (line.length < 2) {
                        found = true; //no error, is blank line.
                    }
                }

                if (!found)
                    Util.log("InfoValue", "Error: the specified InfoValue doesn't exist: " + lines[i]);
            }
        } catch (IOException e) {
            Util.log("InfoValue", "wat.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeInfoToFile() {
        // resets all info then writes defaults to a file.
        FileConnection infoFile;
        try {
            infoFile = (FileConnection) Connector.open("file:///" + INFO_FILE_PATH,
                    Connector.READ_WRITE);
            if (!infoFile.exists()) {
                infoFile.create();
            }
            OutputStream outStream = infoFile.openOutputStream();
            // Search through the infoList and write every one.
            for (int j = 0; j < infoList.size(); j++) {
                InfoValue info = (InfoValue) infoList.elementAt(j);
                // Util.log("InfoValue",info.getKey());
                outStream.write((info.getKey() + "=" + info.getDefault() + "\n").getBytes()); //Convert to byte array
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class InfoValue {
        private final String key;
        private double data;
        private double def;

        InfoValue(String key, double data) {
            this.key = key;
            this.def = data;
            this.data = this.def;
            infoList.addElement(this);
        }

        public String getKey() {
            return key;
        }

        public double getDouble() {
            return data;
        }

        public int getInt() {
            return (int) data;
        }

        public void setVal(double data) {
            this.data = data;
        }

        public double getDefault() {
            return def;
        }

        public String toString() {
            return key + ":" + data;
        }
    }
}
