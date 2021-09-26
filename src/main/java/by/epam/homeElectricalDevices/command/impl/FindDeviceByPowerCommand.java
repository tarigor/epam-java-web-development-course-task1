package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;

public class FindDeviceByPowerCommand  extends BaseCommand implements Command {
    private int power;

    public FindDeviceByPowerCommand(int power) {
        this.power = power;
    }

    @Override
    public void execute() {

    }
}
