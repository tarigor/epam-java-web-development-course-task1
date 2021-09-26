package by.epam.homeElectricalDevices.service;

import by.epam.homeElectricalDevices.command.Command;

import java.util.ArrayList;

public class JsonFileService {
    private ArrayList<Command> listOfDevice;

    public JsonFileService() {
        listOfDevice = new ArrayList<>();
    }

    public ArrayList<Command> getListOfDevicesFromJsonFile() {
        return listOfDevice;
    }
}
