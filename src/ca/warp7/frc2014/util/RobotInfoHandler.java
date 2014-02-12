package ca.warp7.frc2014.util;

import com.sun.squawk.microedition.io.FileConnection;

import javax.microedition.io.Connector;
import java.io.DataInputStream;
import java.io.IOException;
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
        byte[] buffer = new byte[255];
        String content = "";

        try {
            // Read everything from the file into one string.
            infoFile = (FileConnection) Connector.open("file:///" + infoList,
                    Connector.READ);
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
                if (line.length != 2) {
                    System.out.println("Error: invalid info file line: " +
                            (lines[i].length() == 0 ? "(empty line)" : lines[i]));
                    continue;
                }

                boolean found = false;
                // Search through the infoList until we find one with the same name.
                for (int j = 0; j < infoList.size(); j++) {
                    RobotInfo info = (RobotInfo) infoList.elementAt(j);
                    if (info.getKey().compareTo(line[0]) == 0) {
                        System.out.println("Setting " + info.getKey() + " to " + Double.parseDouble(line[1]));
                        info.setVal(Double.parseDouble(line[1]));
                        found = true;
                        break;
                    }
                }

                if (!found)
                    System.out.println("Error: the infoList doesn't exist: " + lines[i]);
            }
        } catch (IOException e) {
            System.out.println("infos.txt not found. Not overriding infos.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class RobotInfo {
        private final String key;
        private double data;

        RobotInfo(String key, double data) {
            this.key = key;
            this.data = data;

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

        public String toString() {
            return key + ":" + data;
        }
    }
}
