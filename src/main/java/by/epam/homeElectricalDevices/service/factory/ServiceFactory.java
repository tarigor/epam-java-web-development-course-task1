package by.epam.homeElectricalDevices.service.factory;

import by.epam.homeElectricalDevices.service.CommandService;
import by.epam.homeElectricalDevices.service.JsonFileService;
import by.epam.homeElectricalDevices.service.MenuService;
import by.epam.homeElectricalDevices.service.PropertyFileService;

/**
 * Factory of services.
 * Implemented based on Singleton pattern.
 *
 * @author Igor Taren
 */
public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final MenuService menuService;
    private final PropertyFileService propertyService;
    private final JsonFileService jsonFileService;
    private final CommandService commandService;

    private ServiceFactory() {
        menuService = new MenuService();
        propertyService = new PropertyFileService();
        jsonFileService = new JsonFileService();
        commandService = new CommandService();
    }

    /**
     * @return instance of Service Factory
     */
    public static ServiceFactory getInstance() {
        return instance;
    }

    /**
     * @return instance of Menu Service
     */
    public MenuService getMenuService() {
        return menuService;
    }

    /**
     * @return instance of Property Service
     */
    public PropertyFileService getPropertyService() {
        return propertyService;
    }

    public JsonFileService getJsonFileService() {
        return jsonFileService;
    }

    public CommandService getCommandService() {
        return commandService;
    }
}
