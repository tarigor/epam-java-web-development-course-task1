package by.epam.homeElectricalDevices.constants;

/**
 * Location room names within a home.
 *
 * @author Igor Taren
 */
public enum Location {
    KITCHEN("Kitchen"),
    HALL("Hall"),
    LIVING_ROOM("Living room"),
    BAD_ROOM("Bad room");

    private final String roomName;

    /**
     * Constructor of class
     *
     * @param roomName name of room
     */
    Location(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }
}
