package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;

/**
 * Class responsible for command execution - plugin a certain device
 *
 * @author Igor Taren
 */
public class PlugInDeviceCommand extends BaseCommand implements Command {
    @Override
    public void execute() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "PlugInDeviceCommand";
    }
}
