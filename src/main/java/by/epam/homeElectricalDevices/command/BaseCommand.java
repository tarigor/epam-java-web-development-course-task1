package by.epam.homeElectricalDevices.command;

import by.epam.homeElectricalDevices.entity.Device;
import by.epam.homeElectricalDevices.service.factory.ServiceFactory;

import java.util.HashMap;

public abstract class BaseCommand {
    protected HashMap<String, Device> deviceHashMap = ServiceFactory.getInstance().getJsonFileService().getListOfDevicesFromJsonFile();
    // protected ArrayList<Device> deviceList = ServiceFactory.getInstance().getJsonFileService().getListOfDevicesFromJsonFile();
}
