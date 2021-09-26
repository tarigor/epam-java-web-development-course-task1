package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;

/**
 * Class responsible for command execution - find device by power parameter
 *
 * @author Igor Taren
 */
public class FindDeviceByPowerCommand extends BaseCommand implements Command {
    private final int power;

    public FindDeviceByPowerCommand(int power) {
        this.power = power;
    }

    @Override
    public void execute() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "FindDeviceByPowerCommand";
    }
}
