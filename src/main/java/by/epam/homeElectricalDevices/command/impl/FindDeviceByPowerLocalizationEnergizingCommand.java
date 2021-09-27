package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;
import by.epam.homeElectricalDevices.constants.Location;

/**
 * Class responsible for command execution - find device by power , localization,energizing state parameters
 *
 * @author Igor Taren
 */
public class FindDeviceByPowerLocalizationEnergizingCommand extends BaseCommand implements Command {
    private final int power;
    private final Location location;
    private final boolean energizing;

    public FindDeviceByPowerLocalizationEnergizingCommand(int power, Location location, boolean energizing) {
        this.power = power;
        this.location = location;
        this.energizing = energizing;
    }

    @Override
    public void execute() {
        System.out.println("Selected power -> " + power);
        System.out.println("Selected Location -> " + location.name());
        System.out.println("Energizing state -> " + energizing);
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "FindDeviceByPowerLocalizationEnergizingCommand";
    }
}
