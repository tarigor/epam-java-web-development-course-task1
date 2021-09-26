package by.epam.homeElectricalDevices.command;

import by.epam.homeElectricalDevices.service.factory.ServiceFactory;

import java.util.ArrayList;

public abstract class BaseCommand {
    protected ArrayList<Command> listOfCommand = ServiceFactory.getInstance().getJsonFileService().getListOfDevicesFromJsonFile();
}
