package by.epam.homeElectricalDevices.service;

import by.epam.homeElectricalDevices.command.factory.CommandDefiner;
import by.epam.homeElectricalDevices.constants.Location;
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

    public String getSelectedOption() {
        return selectedOption;
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
    public CommandDefiner optionSelection() {
        printToConsole("Input a number of the desired option:");
        selectedOption = scanner.next();
        return CommandDefiner.getInstance();
    }

    /**
     * Method provides text printing in the console.
     *
     * @param text desired text for input.
     */
    private void printToConsole(String text) {
        System.out.println(text);
    }

    /**
     * Method provides dialog input of power selection
     *
     * @return selected power
     */
    public int requestForPowerInput() {
        return 0;
    }

    /**
     * Method provides dialog selection of the devices localization in a house
     *
     * @return selected room space
     */
    public Location requestForLocationSelection() {
        return Location.BAD_ROOM;
    }

    /**
     * Method provides to define of energized state of the device
     *
     * @return energized state
     */
    public boolean requestForEnergizing() {
        return false;
    }
}
