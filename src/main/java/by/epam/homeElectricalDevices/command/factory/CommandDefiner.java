package by.epam.homeElectricalDevices.command.factory;

import by.epam.homeElectricalDevices.command.Command;
import by.epam.homeElectricalDevices.command.impl.*;
import by.epam.homeElectricalDevices.service.MenuService;
import by.epam.homeElectricalDevices.service.factory.ServiceFactory;

public class CommandDefiner {
    private static final CommandDefiner instance = new CommandDefiner();
    private Command command;
    private MenuService menuService = ServiceFactory.getInstance().getMenuService();

    public CommandDefiner() {
    }

    public static CommandDefiner getInstance() {
        return instance;
    }

    public Command getCommand(String commandId) {
        switch (commandId) {
            case ("1"):
                command = new GetAllDevicesCommand();
                break;
            case ("2"):
                command = new PlugInDeviceCommand();
                break;
            case ("3"):
                command = new PowerCalculationCommand();
                break;
            case ("4"):
                command = new DeviceSortCommand();
                break;
            case ("5"):
                command = new FindDeviceByPowerCommand(menuService.requestForPowerInput());
                break;
            case ("6"):
                command = new FindDeviceByPowerLocalizationCommand(
                        menuService.requestForPowerInput(),
                        menuService.requestForLocationInput());
                break;
            case ("7"):
                command = new FindDeviceByPowerLocalizationEnergizingCommand(
                        menuService.requestForPowerInput(),
                        menuService.requestForLocationInput(),
                        menuService.requestForEnergizing());
                break;
            default:
                System.out.println("There is not such a command " + commandId + " , try again");
        }
        return command;
    }
}
