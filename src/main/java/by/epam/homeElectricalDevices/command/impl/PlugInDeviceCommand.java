package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;
import by.epam.homeElectricalDevices.service.factory.ServiceFactory;

/**
 * Class responsible for command execution - plugin a certain device
 *
 * @author Igor Taren
 */
public class PlugInDeviceCommand extends BaseCommand implements Command {
    private final String id;

    public PlugInDeviceCommand(String id) {
        this.id = id;
    }

    @Override
    public void execute() {
        System.out.println("Requested id -> " + id);
        ServiceFactory.getInstance().getJsonFileService().storeMapToJson(
                ServiceFactory.getInstance().getCommandService().plugInDevice(deviceHashMap, id));
    }

    @Override
    public String toString() {
        return "PlugInDeviceCommand";
    }
}
