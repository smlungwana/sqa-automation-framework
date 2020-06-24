package tools;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestDataReader {


    private static String path = System.getProperty("user.dir")+"\\data";
    private static String jsonFile = "JSON_Data.json";
    private static String csvFile = "CSV_Data.csv";

    public static Map<String,String> getJSON_Data() {
        String path = System.getProperty("user.dir")+"\\data";

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = null;

        // Read JSON from a file into a Map
        try {
            map = mapper.readValue(new File(
                    path + "\\" + jsonFile), new TypeReference<Map<String, Object>>() {
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
    public static Map<String,String> getCSV_Data() {

        String line = "";
        String cvsSplitBy = ",";
        HashMap<String, String> list = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path + "\\"+csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                list.put(country[0], country[1]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }



}
