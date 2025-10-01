package command;

import model.Satellite;
import java.util.logging.Logger;

public class DeactivatePanelsCommand implements Command {
    private static final Logger logger = Logger.getLogger(DeactivatePanelsCommand.class.getName());

    @Override
    public void execute() {
        Satellite sat = Satellite.getInstance();
        logger.info("Executing DeactivatePanelsCommand");
        sat.deactivatePanels();
    }
}
