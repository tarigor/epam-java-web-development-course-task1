package by.epam.homeElectricalDevices.service;

import by.epam.homeElectricalDevices.entity.Device;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Class provides json file parsing into the HashMap by Gson library.
 *
 * @author Igor Taren
 */
public class JsonFileService {
    private final Logger log = Logger.getLogger(JsonFileService.class);
    private final String JSON_FILE_PATH = ".//src//main//resources/devices.json";
    private final Gson gson;

    public JsonFileService() {
        gson = new Gson();
    }

    /**
     * Methods provides json file parsing into the HashMap.
     *
     * @return HashMap contains key/value of deviceId/Device(POJO)
     */
    public HashMap<String, Device> getListOfDevicesFromJsonFile() {
        String fileContent = null;
        try {
            fileContent = new String(Files.readAllBytes(Paths.get(JSON_FILE_PATH)));
        } catch (IOException e) {
            log.error(e);
            e.printStackTrace();
        }
        return gson.fromJson(fileContent,
                new TypeToken<HashMap<String, Device>>() {
                }.getType());
    }

    public void storeMapToJson(HashMap<String, Device> deviceHashMap) {
        String fileContent = gson.toJson(deviceHashMap, new TypeToken<HashMap<String, Device>>() {
        }.getType());
        try {
            Files.writeString(Path.of(JSON_FILE_PATH), fileContent);
        } catch (IOException e) {
            log.error(e);
            e.printStackTrace();
        }
    }
}