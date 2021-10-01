package by.epam.homeElectricalDevices.command.factory;

import by.epam.homeElectricalDevices.command.Command;
import by.epam.homeElectricalDevices.command.impl.*;
import by.epam.homeElectricalDevices.service.MenuService;
import by.epam.homeElectricalDevices.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

/**
 * The class is defined certain of election made on menu.
 * Implemented based on singleton pattern
 *
 * @author Igor Taren
 */
public class CommandDefiner {
    private static final Logger log = Logger.getLogger(CommandDefiner.class);
    private static final CommandDefiner instance = new CommandDefiner();
    private final MenuService menuService = ServiceFactory.getInstance().getMenuService();
    private Command command;

    public CommandDefiner() {
    }

    public static CommandDefiner getInstance() {
        return instance;
    }

    /**
     * Method defines the certain commands depends from menu selection
     *
     * @param commandId selected id from menu
     * @return certain instance of command depends from menu selection
     */
    public Command getCommand(String commandId) {
        switch (commandId) {
            case ("1"):
                command = new GetAllDevicesCommand();
                break;
            case ("2"):
                command = new PlugInDeviceCommand(menuService.requestForId());
                break;
            case ("3"):
                command = new PowerCalculationCommand();
                break;
            case ("4"):
                command = new DeviceSortByPowerCommand();
                break;
            case ("5"):
                command = new FindDeviceByPowerCommand(menuService.requestForPowerInput());
                break;
            case ("6"):
                command = new FindDeviceByPowerLocalizationCommand(
                        menuService.requestForLocationSelection(),
                        menuService.requestForPowerInput());
                break;
            case ("7"):
                command = new FindDeviceByPowerLocalizationEnergizingCommand(
                        menuService.requestForLocationSelection(),
                        menuService.requestForEnergizing(),
                        menuService.requestForPowerInput());
                break;
            default:
                command = new UndefinedCommand();
        }
        log.info(command.toString() + " selected");
        return command;
    }
}
