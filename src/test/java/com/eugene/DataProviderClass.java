package com.eugene;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static com.eugene.Config.IN_DATA_PATH;

public class DataProviderClass {

    @DataProvider(name = "query")
    public static Object[][] dataFromFile(){
        String posQuery = "", negQuery = "";

        try(FileReader reader = new FileReader(IN_DATA_PATH)) {
            BufferedReader bufferedReader = new BufferedReader(reader);
            posQuery = bufferedReader.readLine();
            negQuery = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Object[][]{{posQuery, negQuery}};
    }
}
