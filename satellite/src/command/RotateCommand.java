package command;

import model.Orientation;
import model.Satellite;
import java.util.logging.Logger;

public class RotateCommand implements Command {
    private final Orientation newOrientation;
    private static final Logger logger = Logger.getLogger(RotateCommand.class.getName());

    public RotateCommand(Orientation o) {
        this.newOrientation = o;
    }

    @Override
    public void execute() {
        Satellite sat = Satellite.getInstance();
        logger.info("Executing RotateCommand -> " + newOrientation);
        sat.rotate(newOrientation);
    }
}
