package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;
import by.epam.homeElectricalDevices.service.factory.ServiceFactory;

/**
 * Class responsible for command execution - calculation of consumption of all plugged devices
 *
 * @author Igor Taren
 */
public class PowerCalculationCommand extends BaseCommand implements Command {
    @Override
    public void execute() {
        System.out.println("The total power consumption of all energized devices is -> " +
                ServiceFactory.getInstance().getCommandService().powerCalculation(deviceHashMap));
    }

    @Override
    public String toString() {
        return "PowerCalculationCommand";
    }
}
