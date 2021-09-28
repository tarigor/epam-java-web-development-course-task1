package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;
import by.epam.homeElectricalDevices.constants.Location;
import by.epam.homeElectricalDevices.service.factory.ServiceFactory;


/**
 * Class responsible for command execution - find device by power, localization parameters
 *
 * @author Igor Taren
 */
public class FindDeviceByPowerLocalizationCommand extends BaseCommand implements Command {
    private final int power;
    private final Location location;

    public FindDeviceByPowerLocalizationCommand(Location location, int power) {
        this.power = power;
        this.location = location;
    }

    @Override
    public void execute() {
        System.out.println("Selected Location -> " + location.name());
        System.out.println("Selected power -> " + power);

        ServiceFactory.getInstance().getCommandService()
                .sortByLocation(deviceHashMap, location)
                .findByPower(ServiceFactory.getInstance().getCommandService().getDeviceMapsSortedByLocation(), power);

        if (ServiceFactory.getInstance().getCommandService().getDeviceWithClosestPower().getDeviceName() != null) {
            System.out.println("It was found the device on location " + location.name() + " which has power closest to " + power);
            System.out.println("Device -> " + ServiceFactory.getInstance().getCommandService().getDeviceWithClosestPower().toString());
        } else {
            System.out.println("It was not found any device match requested parameters");
        }
    }
}
