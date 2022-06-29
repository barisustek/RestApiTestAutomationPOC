package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private final Properties properties;

    public ConfigReader() {

        BufferedReader reader;
        String propertyFilePath = "src/test/resources/config.properties";

        try{

            reader = new BufferedReader( new FileReader(propertyFilePath));
            properties = new Properties();
            try {

                properties.load(reader);
                reader.close();

            }catch (IOException e){
                e.printStackTrace();
            }

        }catch (FileNotFoundException e){

            throw new RuntimeException("Config file not found" + propertyFilePath);

        }

    }

    public String getRestAssuredUrl() {

        return properties.getProperty("RestAssuredUrl");

    }

    public int getWireMockPortNumber() {

        return Integer.parseInt(properties.getProperty("WireMockPortNumber"));

    }

}
