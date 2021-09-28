package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;
import by.epam.homeElectricalDevices.service.factory.ServiceFactory;

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
        System.out.println("Selected power is => " + power);
        System.out.println("The nearest value of power to the selected power is for device: " +
                ServiceFactory.getInstance().getCommandService()
                        .findByPower(deviceHashMap, power).getDeviceWithClosestPower().toString());
    }
}
