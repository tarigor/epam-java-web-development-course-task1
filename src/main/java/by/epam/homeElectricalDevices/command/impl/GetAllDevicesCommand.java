package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;

import java.util.Map;

/**
 * Class responsible for command execution - list all devices in a house
 *
 * @author Igor Taren
 */
public class GetAllDevicesCommand extends BaseCommand implements Command {
    @Override
    public void execute() {
        for (Map.Entry entry : deviceHashMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "GetAllDevicesCommand";
    }
}
