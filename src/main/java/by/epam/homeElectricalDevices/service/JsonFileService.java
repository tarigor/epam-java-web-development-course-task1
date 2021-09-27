package by.epam.homeElectricalDevices.service;

import by.epam.homeElectricalDevices.entity.Device;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * Class provides json file parsing into the HashMap by Gson library.
 *
 * @author Igor Taren
 */
public class JsonFileService {
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
            e.printStackTrace();
        }
        return gson.fromJson(fileContent,
                new TypeToken<HashMap<String, Device>>() {
                }.getType());
    }
}