package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.Command;

/**
 * Class responsible for informing of wrong command selected
 *
 * @author Igor Taren
 */
public class UndefinedCommand implements Command {
    @Override
    public void execute() {
        System.out.println("There is not such a command, try again");
    }

    @Override
    public String toString() {
        return "UndefinedCommand";
    }
}
