package by.epam.homeElectricalDevices.command;

import by.epam.homeElectricalDevices.command.factory.CommandDefiner;
import by.epam.homeElectricalDevices.entity.Device;
import by.epam.homeElectricalDevices.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

import java.util.HashMap;

public abstract class BaseCommand {
    protected static final Logger log = Logger.getLogger(BaseCommand.class);
    protected HashMap<String, Device> deviceHashMap = ServiceFactory.getInstance().getJsonFileService().getListOfDevicesFromJsonFile();
}
