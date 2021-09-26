package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;

/**
 * Class responsible for command execution - devices sort
 *
 * @author Igor Taren
 */
public class DeviceSortCommand extends BaseCommand implements Command {
    @Override
    public void execute() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "DeviceSortCommand";
    }
}
