package by.epam.homeElectricalDevices.entity;

import by.epam.homeElectricalDevices.constants.Location;

/**
 * Entity represents electrical device located at home.
 *
 * @author Igor Taren
 */
public class Device {
    private String deviceName;
    private Location location;
    private int powerConsumption;
    private boolean energized;

    /**
     * Constructor of the Device entity
     *
     * @param deviceName       name of device
     * @param location         name of device location
     * @param powerConsumption power consumption of the device
     * @param energized        energizing state of the device
     */
    public Device(String deviceName, Location location, int powerConsumption, boolean energized) {
        this.deviceName = deviceName;
        this.location = location;
        this.powerConsumption = powerConsumption;
        this.energized = energized;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public boolean isEnergized() {
        return energized;
    }

    public void setEnergized(boolean energized) {
        this.energized = energized;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceName='" + deviceName + '\'' +
                ", location=" + location +
                ", powerConsumption=" + powerConsumption +
                ", energized=" + energized +
                '}';
    }
}
