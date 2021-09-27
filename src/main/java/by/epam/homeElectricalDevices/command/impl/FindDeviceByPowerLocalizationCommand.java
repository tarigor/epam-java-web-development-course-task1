package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;
import by.epam.homeElectricalDevices.constants.Location;

/**
 * Class responsible for command execution - find device by power, localization parameters
 *
 * @author Igor Taren
 */
public class FindDeviceByPowerLocalizationCommand extends BaseCommand implements Command {
    private final int power;
    private final Location location;

    public FindDeviceByPowerLocalizationCommand(int power, Location location) {
        this.power = power;
        this.location = location;
    }

    @Override
    public void execute() {
        System.out.println("Selected power -> " + power);
        System.out.println("Selected Location -> " + location.name());
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "FindDeviceByPowerLocalizationCommand";
    }
}
