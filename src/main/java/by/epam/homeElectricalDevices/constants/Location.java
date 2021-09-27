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
    BED_ROOM("Bed room"),
    CABINET("Cabinet");

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

    @Override
    public String toString() {
        return "Location{" +
                "roomName='" + roomName + '\'' +
                '}';
    }
}
