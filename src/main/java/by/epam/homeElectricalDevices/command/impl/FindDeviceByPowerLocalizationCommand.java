package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;
import by.epam.homeElectricalDevices.constants.Location;

public class FindDeviceByPowerLocalizationCommand  extends BaseCommand implements Command {
    private int power;
    private Location location;

    public FindDeviceByPowerLocalizationCommand(int power, Location location) {
        this.power = power;
        this.location = location;
    }

    @Override
    public void execute() {

    }
}
