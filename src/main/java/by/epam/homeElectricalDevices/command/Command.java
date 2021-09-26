package by.epam.homeElectricalDevices.command;

/**
 * Command interface based on Command Factory pattern,
 * provides execute command which must be override by each command.
 *
 * @author Igor Taren
 */
public interface Command {
    void execute();
}
