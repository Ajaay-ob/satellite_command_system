package command;

/**
 * Command interface for satellite commands.
 */
public interface Command {
    void execute();
    default String name() { return this.getClass().getSimpleName(); }
}
