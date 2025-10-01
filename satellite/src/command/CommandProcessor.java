package command;

import java.util.logging.Logger;

/**
 * Simple invoker that runs commands.
 * Can be extended to support queueing, history, undo, etc.
 */
public class CommandProcessor {
    private static final Logger logger = Logger.getLogger(CommandProcessor.class.getName());

    public void execute(Command cmd) {
        logger.info("Processor executing: " + cmd.name());
        cmd.execute();
    }
}
