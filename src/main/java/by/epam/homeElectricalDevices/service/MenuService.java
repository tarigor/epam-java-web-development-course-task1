package by.epam.homeElectricalDevices.service;

import by.epam.homeElectricalDevices.service.factory.ServiceFactory;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

/**
 * Service of menu activity
 *
 * @author Igor Taren
 */
public class MenuService {
    private final Scanner scanner;
    private final String MENU_FILE_PROPERTIES = "menu.properties";
    private final HashMap<String, String> menuHierarchy;
    private Properties properties;
    private InputStream inputStream;
    private String selectedOption;

    public MenuService() {
        scanner = new Scanner(System.in);
        menuHierarchy = new HashMap<>();
    }

    /**
     * Method store data from properties file in HashMap.
     *
     * @return instance of menu Service provides builder pattern.
     */
    public MenuService storeMenuToMap() {
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            menuHierarchy.put((String) entry.getKey(), (String) entry.getValue());
        }
        return this;
    }

    /**
     * Method gets menu content by calling method reading from property file by Property service
     *
     * @return instance of Menu Service with initialized properties field provides builder pattern.
     */
    public MenuService getMenu() {
        this.properties = ServiceFactory.getInstance().getPropertyService().readFromPropertyFile(MENU_FILE_PROPERTIES);
        return this;
    }

    /**
     * Method prints out the menu content to console.
     *
     * @return instance of menu Service provides builder pattern.
     */
    public MenuService printMenu() {
        for (Map.Entry<String, String> entry : menuHierarchy.entrySet()) {
            printToConsole(entry.getKey() + ". " + entry.getValue());
        }
        return this;
    }

    /**
     * Method provides a dialogue of entering the desired option.
     *
     * @return inputted option.
     */
    public String optionSelection() {
        printToConsole("Input a number of the desired option:");
        selectedOption = scanner.next();
        printToConsole("selected option->" + selectedOption);
        return selectedOption;
    }

    /**
     * Method provides text printing in the console.
     *
     * @param text desired text for input.
     */
    private void printToConsole(String text) {
        System.out.println(text);
    }
}
