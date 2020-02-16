package com.eugene;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class LogResultToFile {
    public static void logResultToFile(String filePath, String message){
        try (FileWriter writer = new FileWriter(filePath, true)){
            writer.write(new Date().toString());
            writer.append(" ");
            writer.append(message);
            writer.append('\n');
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
