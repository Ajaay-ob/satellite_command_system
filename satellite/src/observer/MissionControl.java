package observer;

import model.Satellite;

import java.time.LocalDateTime;
import java.util.logging.Logger;

/**
 * Simple Mission Control observer that logs state changes and timestamps.
 */
public class MissionControl implements SatelliteObserver {
    private static final Logger logger = Logger.getLogger(MissionControl.class.getName());

    @Override
    public void onStateChanged(Satellite sat, String event) {
        String msg = String.format("[%s] MissionControl: Event=%s | %s",
                LocalDateTime.now(), event, sat.toString());
        logger.info(msg);
    }
}
