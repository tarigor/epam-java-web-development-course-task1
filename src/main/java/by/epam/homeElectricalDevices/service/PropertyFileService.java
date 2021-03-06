package by.epam.homeElectricalDevices.service;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Service provides getting data from property file located in resources folder
 *
 * @author Igor Taren
 */
public class PropertyFileService {
    private final Logger log = Logger.getLogger(PropertyFileService.class);
    private final Properties properties;
    private InputStream inputStream;

    public PropertyFileService() {
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
            log.error("Exception: " + e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    log.error("Exception: " + e);
                    e.printStackTrace();
                }
            }
        }
        return properties;
    }
}
