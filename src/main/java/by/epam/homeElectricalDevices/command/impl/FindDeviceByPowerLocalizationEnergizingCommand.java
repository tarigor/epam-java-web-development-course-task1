package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;
import by.epam.homeElectricalDevices.constants.Location;

public class FindDeviceByPowerLocalizationEnergizingCommand  extends BaseCommand implements Command {
    private int power;
    private Location location;
    private boolean energizing;

    public FindDeviceByPowerLocalizationEnergizingCommand(int power, Location location, boolean energizing) {
        this.power = power;
        this.location = location;
        this.energizing = energizing;
    }

    @Override
    public void execute() {

    }
}