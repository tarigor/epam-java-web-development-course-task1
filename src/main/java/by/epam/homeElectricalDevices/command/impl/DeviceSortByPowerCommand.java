package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;
import by.epam.homeElectricalDevices.service.factory.ServiceFactory;

/**
 * Class responsible for command execution - devices sort by power consumption
 *
 * @author Igor Taren
 */
public class DeviceSortByPowerCommand extends BaseCommand implements Command {
    @Override
    public void execute() {
        ServiceFactory.getInstance().getCommandService().sortByPower(deviceHashMap).forEach((K, V) ->
                System.out.println(K + " " + V));
    }

    @Override
    public String toString() {
        return "DeviceSortCommand";
    }
}
