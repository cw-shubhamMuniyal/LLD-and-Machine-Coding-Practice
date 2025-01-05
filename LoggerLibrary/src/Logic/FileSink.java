package Logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import Entity.Message;
import Utility.Constants;

public class FileSink implements Sink {
    private String fileLocation;
    private long maxFileSize;
    private int rotationIndex = Constants.getLogfileRotationIndexStart();

    @Override
    public synchronized void logMessage(Message message) {
        File logFile = new File(fileLocation);
        if (logFile.exists() && logFile.length() > maxFileSize) {
            rotateLogs();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write(message.toString());
            writer.newLine();
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void addConfig(Map<String, String> configMap) {
        this.fileLocation = configMap.get("file_location");
        this.maxFileSize = Long.parseLong(configMap.getOrDefault("max_file_size", "1000"));
    }

    private void rotateLogs() {
        File logFile = new File(fileLocation);
        String rotatedFileName = fileLocation + "." + rotationIndex + ".gz";
        try (FileInputStream fis = new FileInputStream(logFile);
                FileOutputStream fos = new FileOutputStream(rotatedFileName);
                GZIPOutputStream gzipOS = new GZIPOutputStream(fos)) {

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) > 0) {
                gzipOS.write(buffer, 0, len);
            }
        } catch(FileNotFoundException exception) {
            exception.printStackTrace();
        } catch(IOException exception) {
            exception.printStackTrace();
        }

        logFile.delete();
        rotationIndex++;
    }

}
