package by.epam.homeElectricalDevices.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Service provides getting data from property file located in resources folder
 *
 * @author Igor Taren
 */
public class PropertyService {
    private final Properties properties;
    private InputStream inputStream;

    public PropertyService() {
        properties = new Properties();
    }

    /**
     * Method get data from property file
     *
     * @param propertyFileName path name of property file
     * @return instance of property
     */
    public Properties readFromPropertyFile(String propertyFileName) {
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(propertyFileName);
            if (inputStream != null) {
                properties.load(inputStream);
                inputStream.close();
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
