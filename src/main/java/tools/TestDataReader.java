package tools;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**TestDataReader class that reads JSON and CSV files stored inside data/ folder
 * @author smlungwana
 **/

public class TestDataReader {


    private static String jsonFile = "JSON_Data.json";
    private static String csvFile = "CSV_Data.csv";
    private static String directory =  System.getProperty("user.dir");

    /**getJSON_Data method to get JSON test data.
     * 	@throws	Exception
     */
    public static Map<String,String> getJSON_Data() {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> map = null;

        // Read JSON from a file into a Map
        try {
            //Platform independent path
            Path jsonPath = Paths.get( directory,"data",jsonFile);

            map = mapper.readValue(new File(
                    jsonPath.toString() ), new TypeReference<Map<String, Object>>() {
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**getCSV_Data method to get CSV test data.
     * 	@throws	Exception
     */
    public static Map<String,String> getCSV_Data() {
        String line = "";
        String cvsSplitBy = ",";
        HashMap<String, String> list = new HashMap<>();

        Path csvPath = Paths.get( directory,"data",csvFile);

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath.toString()))) {

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
