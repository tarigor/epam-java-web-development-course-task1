package by.epam.homeElectricalDevices.service;

import by.epam.homeElectricalDevices.constants.Location;
import by.epam.homeElectricalDevices.entity.Device;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author
 */
public class CommandService {
    private final SortedMap<Integer, String> resultMap;
    private final HashMap<String, Device> deviceMapsSortedByLocation;
    private Device deviceWithClosestPower;
    private final HashMap<String, Device> deviceMapsSortedByEnergizing;

    public CommandService() {
        resultMap = new TreeMap<>();
        deviceMapsSortedByLocation = new HashMap<>();
        deviceWithClosestPower = new Device();
        deviceMapsSortedByEnergizing = new HashMap<>();
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

    /**
     * @param deviceHashMap
     * @param power
     * @return the first Device with closest power to the selected power
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
     * @param deviceHashMap
     * @param location
     * @return
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
     * @param deviceHashMap
     * @param energizingState
     * @return
     */
    public CommandService sortByEnergizing(HashMap<String, Device> deviceHashMap, boolean energizingState) {
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
}
