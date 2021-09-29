package by.epam.homeElectricalDevices.service;

import by.epam.homeElectricalDevices.constants.Location;
import by.epam.homeElectricalDevices.entity.Device;
import by.epam.homeElectricalDevices.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * The class provides a business logic of all commands
 *
 * @author Igor Taren
 */
public class CommandService {
    private final SortedMap<Integer, String> resultMap;
    private final HashMap<String, Device> deviceMapsSortedByLocation;
    private final HashMap<String, Device> deviceMapsSortedByEnergizing;
    private final HashMap<String, Device> deviceMapSortedById;
    private Device deviceWithClosestPower;
    private Device device;

    public CommandService() {
        resultMap = new TreeMap<>();
        deviceMapsSortedByLocation = new HashMap<>();
        deviceWithClosestPower = new Device();
        deviceMapsSortedByEnergizing = new HashMap<>();
        deviceMapSortedById = new HashMap<>();
        device = new Device();
    }

    public SortedMap<Integer, String> getResultMap() {
        return resultMap;
    }

    public HashMap<String, Device> getDeviceMapsSortedByLocation() {
        return deviceMapsSortedByLocation;
    }

    public Device getDeviceWithClosestPower() {
        return deviceWithClosestPower;
    }

    public HashMap<String, Device> getDeviceMapsSortedByEnergizing() {
        return deviceMapsSortedByEnergizing;
    }

    public HashMap<String, Device> getDeviceMapSortedById() {
        return deviceMapSortedById;
    }

    /**
     * Methods provides a finding of devices closest to certain power value
     *
     * @param deviceHashMap HashMap contains the records of all devices
     * @param power         requested power
     * @return the Device which has a closest power to the requested power
     */
    public CommandService findByPower(HashMap<String, Device> deviceHashMap, Integer power) {
        resultMap.clear();
        for (Map.Entry entry : deviceHashMap.entrySet()) {
            //iterating within whole power consumption rates of all devices and subtracting the selected power and rated power
            int diff = Math.abs(((Device) entry.getValue()).getPowerConsumption() - power);
            //storing in sorted map -> result of subtract(less value is closet value to selected power) put as key,
            // key of deviceHashMap put to value
            resultMap.put(diff, ((String) entry.getKey()));
        }
        if (!resultMap.isEmpty()) {
            deviceWithClosestPower = deviceHashMap.get(resultMap.values().toArray()[0]);
        }
        return this;
    }

    /**
     * Method provides a sorting of the devices by their location
     *
     * @param deviceHashMap HashMap contains the records of all devices
     * @param location      requested location
     * @return HasMap which contains the devices located in requested location
     */
    public CommandService sortByLocation(HashMap<String, Device> deviceHashMap, Location location) {
        deviceMapsSortedByLocation.clear();
        for (Map.Entry entry : deviceHashMap.entrySet()) {
            if (((Device) entry.getValue()).getLocation().name().equalsIgnoreCase(location.name())) {
                deviceMapsSortedByLocation.put(((String) entry.getKey()), ((Device) entry.getValue()));
            }
            deviceMapsSortedByLocation.forEach((K, V) -> {
                System.out.println("deviceMapsSortedByLocation " + K + " " + V);
            });
        }
        return this;
    }

    /**
     * Method provides a filtering of the devices by their energizing state
     *
     * @param deviceHashMap   HashMap contains the records of all devices
     * @param energizingState energizing state
     * @return modified HashMap the records of which are filtered by energizing state
     */
    public CommandService filterByEnergizing(HashMap<String, Device> deviceHashMap, boolean energizingState) {
        deviceMapsSortedByEnergizing.clear();
        for (Map.Entry entry : deviceHashMap.entrySet()) {
            if (energizingState) {
                if (((Device) entry.getValue()).isEnergized()) {
                    deviceMapsSortedByEnergizing.put(((String) entry.getKey()), ((Device) entry.getValue()));
                }
            } else {
                if (!((Device) entry.getValue()).isEnergized()) {
                    deviceMapsSortedByEnergizing.put(((String) entry.getKey()), ((Device) entry.getValue()));
                }
            }
        }
        deviceMapsSortedByEnergizing.forEach((K, V) -> {
            System.out.println("deviceMapsSortedByEnergizing " + K + " " + V);
        });
        return this;
    }

    /**
     * Methods prints all devices to the console
     *
     * @param deviceHashMap device HashMap for printing to the console
     */
    public void getAllDevices(HashMap<String, Device> deviceHashMap) {
        deviceHashMap.forEach((K, V) -> {
            System.out.println(K + " " + V);
        });
    }

    /**
     * Method plugs set the filed energized of the certain device and modifies map
     *
     * @param deviceHashMap source map where the device object should be modified
     * @param id            certain id of the device
     * @return the modified HashMap of the devices
     */
    public HashMap<String, Device> plugInDevice(HashMap<String, Device> deviceHashMap, String id) {
        for (Map.Entry entry : deviceHashMap.entrySet()) {
            if (((String) entry.getKey()).contentEquals(id)) {
                device = ((Device) entry.getValue());
                device.setEnergized(true);
                entry.setValue(device);
            }
        }
        ServiceFactory.getInstance().getCommandService().getAllDevices(deviceHashMap);
        return deviceHashMap;
    }

    /**
     * Method calculates the total power consumption of all energized devices
     *
     * @param deviceHashMap Hashmap contains all devices
     * @return result of calculated power
     */
    public Integer powerCalculation(HashMap<String, Device> deviceHashMap) {
        int totalPowerCalculated = 0;
        for (Map.Entry entry : deviceHashMap.entrySet()) {
            if (((Device) entry.getValue()).isEnergized()) {
                totalPowerCalculated = totalPowerCalculated + ((Device) entry.getValue()).getPowerConsumption();
            }
        }
        return totalPowerCalculated;
    }
}
