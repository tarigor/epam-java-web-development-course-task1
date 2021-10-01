package by.epam.homeElectricalDevices.service;

import by.epam.homeElectricalDevices.command.factory.CommandDefiner;
import by.epam.homeElectricalDevices.constants.Location;
import by.epam.homeElectricalDevices.service.factory.ServiceFactory;
import org.apache.log4j.Logger;

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
    private final Logger log = Logger.getLogger(MenuService.class);
    private final Scanner scanner;
    private final String MENU_FILE_PROPERTIES = "menu.properties";
    private HashMap<String, String> menuHierarchy;
    private Properties properties;
    private InputStream inputStream;
    private String selectedOption;
    private String selectedId;

    public MenuService() {
        scanner = new Scanner(System.in);
        menuHierarchy = new HashMap<>();
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setMenuHierarchy(HashMap<String, String> menuHierarchy) {
        this.menuHierarchy = menuHierarchy;
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
        this.setProperties(ServiceFactory.getInstance().getPropertyService().readFromPropertyFile(MENU_FILE_PROPERTIES));
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
     * Method provides dialog input of power selection
     * and validation of inputting
     *
     * @return selected power
     */
    public int requestForPowerInput() {
        int powerEntered = 0;
        boolean inputIsWrong = true;
        while (inputIsWrong) {
            try {
                printToConsole("Enter the power value to search for a device close to it");
                powerEntered = scanner.nextInt();
            } catch (Exception e) {
                log.error("Input is wrong please type an integer type!!!", e);
                scanner.next();
                continue;
            }
            inputIsWrong = false;
        }
        return powerEntered;
    }

    /**
     * Method provides dialog selection of the devices localization in a house
     * and validation of inputting
     *
     * @return selected room space
     */
    public Location requestForLocationSelection() {
        int selectedLocationId = 0;
        boolean inputIsWrong = true;
        while (inputIsWrong) {
            try {
                printToConsole("Select the device location fromm the list bellow");
                for (int i = 0; i < Location.values().length; i++) {
                    printToConsole((i + 1) + ". " + Location.values()[i].name());
                }
                printToConsole("enter an ID of Location from 1 to " + Location.values().length);
                selectedLocationId = scanner.nextInt();
            } catch (Exception e) {
                log.error("Input is wrong please type an integer type!!!", e);
                scanner.next();
                continue;
            }
            if (selectedLocationId > Location.values().length) {
                printToConsole("Please enter a number within a range (0-" + Location.values().length + ")");
            }
            inputIsWrong = false;
        }
        return Location.values()[selectedLocationId - 1];
    }

    /**
     * Method provides a definition of energized state of the device
     * and validation of inputting
     *
     * @return energized state
     */
    public boolean requestForEnergizing() {
        boolean answer = false;
        boolean doWhileCycle = true;
        while (doWhileCycle) {
            printToConsole("Does the device should be energized? Enter y or n");
            switch (scanner.next()) {
                case ("y"):
                    answer = true;
                    break;
                case ("n"):
                    answer = false;
                    break;
                default:
                    printToConsole("Please answer y(Y) or n(N), try again...");
                    continue;
            }
            doWhileCycle = false;
        }
        return answer;
    }

    /**
     * Methods provides the requesting dialog of the desired device ID
     *
     * @return selected ID
     */
    public String requestForId() {
        String selectedId = "";
        boolean doWhileCycle = true;
        while (doWhileCycle) {
            ServiceFactory.getInstance().getCommandService().getAllDevices(ServiceFactory.getInstance().getJsonFileService().getListOfDevicesFromJsonFile());
            printToConsole("Input an ID of the device listed above:");
            selectedId = scanner.next();
            if (ServiceFactory.getInstance().getJsonFileService().getListOfDevicesFromJsonFile().containsKey(selectedId)) {
                return selectedId;
            } else {
                printToConsole("There is now such id, try again");
                continue;
            }
        }
        return selectedId;
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
