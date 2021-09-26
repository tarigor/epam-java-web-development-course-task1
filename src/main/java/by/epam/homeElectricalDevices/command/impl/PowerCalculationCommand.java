package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;

/**
 * Class responsible for command execution - calculation of consumption of all plugged devices
 *
 * @author Igor Taren
 */
public class PowerCalculationCommand extends BaseCommand implements Command {
    @Override
    public void execute() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "PowerCalculationCommand";
    }
}
