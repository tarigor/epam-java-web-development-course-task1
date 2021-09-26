package by.epam.homeElectricalDevices.service.factory;

import by.epam.homeElectricalDevices.service.MenuService;
import by.epam.homeElectricalDevices.service.PropertyService;

/**
 * Factory of services.
 * Implemented based on Singleton pattern.
 *
 * @author Igor Taren
 */
public class ServiceFactory {

    private static final ServiceFactory instance = new ServiceFactory();
    private final MenuService menuService;
    private final PropertyService propertyService;

    private ServiceFactory() {
        menuService = new MenuService();
        propertyService = new PropertyService();
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
    public PropertyService getPropertyService() {
        return propertyService;
    }
}
