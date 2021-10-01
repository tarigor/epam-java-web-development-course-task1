package by.epam.homeElectricalDevices.service;

import by.epam.homeElectricalDevices.entity.Device;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

class CommandServiceTest {

    private static HashMap<String, Device> inputHashMap;
    private static CommandService commandService;

    @BeforeAll
    public static void setUp() {
        inputHashMap = new HashMap<>();
        commandService = new CommandService();
    }

    @Test
    public void testFindByPower() {
        //GIVEN
        int inputData = 3550;
        inputHashMap.put("1", new Device("first", by.epam.homeElectricalDevices.constants.Location.BED_ROOM, 2000, true));
        inputHashMap.put("2", new Device("second", by.epam.homeElectricalDevices.constants.Location.BED_ROOM, 3000, true));
        inputHashMap.put("3", new Device("third", by.epam.homeElectricalDevices.constants.Location.BED_ROOM, 4000, true));
        Device expectedResult = commandService.findByPower(inputHashMap, inputData);
        System.out.println("expectedResult->" + expectedResult);

        //WHEN
        Device myResult = new Device("third", by.epam.homeElectricalDevices.constants.Location.BED_ROOM, 4000, true);
        System.out.println("myResult->" + myResult);

        //THEN
        Assert.assertEquals(expectedResult, myResult);
    }
}
