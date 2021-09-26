package by.epam.homeElectricalDevices;

import by.epam.homeElectricalDevices.service.MenuService;
import by.epam.homeElectricalDevices.service.factory.ServiceFactory;

/**
 * Provides menu life cycle while app using
 * Implemented based on Singleton pattern
 *
 * @author Igor Taren
 */
public class MenuRunner {
    private static MenuRunner menuRunner;
    private final MenuService menuService = ServiceFactory.getInstance().getMenuService();

    public MenuRunner() {
    }

    public static MenuRunner getMenuRunner() {
        if (menuRunner == null) {
            menuRunner = new MenuRunner();
        }
        return menuRunner;
    }

    /**
     * Method provides continuous cycle while using a menu.
     * Implemented based on builder pattern.
     */
    public void doMenuCycle() {
        while (true) {
            menuService
                    .getMenu()
                    .storeMenuToMap()
                    .printMenu()
                    .optionSelection()
                    .getCommand(ServiceFactory.getInstance().getMenuService().getSelectedOption())
                    .execute();
        }
    }
}
