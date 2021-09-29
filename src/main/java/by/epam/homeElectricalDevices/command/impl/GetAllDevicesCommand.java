package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;
import by.epam.homeElectricalDevices.service.factory.ServiceFactory;

/**
 * Class responsible for command execution - list all devices in a house
 *
 * @author Igor Taren
 */
public class GetAllDevicesCommand extends BaseCommand implements Command {
    @Override
    public void execute() {
        ServiceFactory.getInstance().getCommandService().getAllDevices(deviceHashMap);
    }

    @Override
    public String toString() {
        return "GetAllDevicesCommand";
    }
}
