package by.epam.homeElectricalDevices.command.impl;

import by.epam.homeElectricalDevices.command.BaseCommand;
import by.epam.homeElectricalDevices.command.Command;
import by.epam.homeElectricalDevices.entity.Device;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class responsible for command execution - devices sort by power consumption
 * was learned how to do such a magic lambda expression following this link :) -> https://stackoverflow.com/questions/780541/how-to-sort-a-hashmap-in-java
 *
 * @author Igor Taren
 */
public class DeviceSortCommand extends BaseCommand implements Command {
    @Override
    public void execute() {
        Comparator<HashMap.Entry<String, Device>> valueComparator =
                Comparator.comparingInt(e -> e.getValue().getPowerConsumption());
        HashMap<String, Device> sortedMap =
                deviceHashMap.entrySet().stream().
                        sorted(valueComparator).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
        for (Map.Entry entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }
}
