package command;

import model.Satellite;
import java.util.logging.Logger;

public class CollectDataCommand implements Command {
    private final int units;
    private static final Logger logger = Logger.getLogger(CollectDataCommand.class.getName());

    public CollectDataCommand(int units) {
        this.units = units;
    }

    @Override
    public void execute() {
        Satellite sat = Satellite.getInstance();
        logger.info("Executing CollectDataCommand -> units=" + units);
        if (!sat.arePanelsActive()) {
            throw new IllegalStateException("Cannot collect data: panels inactive.");
        }
        sat.collectData(units);
    }
}
