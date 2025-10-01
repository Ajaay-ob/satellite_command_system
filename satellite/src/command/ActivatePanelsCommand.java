package command;

import model.Satellite;
import java.util.logging.Logger;

public class ActivatePanelsCommand implements Command {
    private static final Logger logger = Logger.getLogger(ActivatePanelsCommand.class.getName());

    @Override
    public void execute() {
        Satellite sat = Satellite.getInstance();
        logger.info("Executing ActivatePanelsCommand");
        sat.activatePanels();
    }
}
