package model;

import observer.SatelliteObserver;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

/**
 * Singleton Satellite that holds state and notifies observers on changes.
 */
public final class Satellite {
    private static volatile Satellite instance;
    private Orientation orientation;
    private boolean solarPanelsActive;
    private int dataCollected; // units
    private final List<SatelliteObserver> observers;
    private static final Logger logger = Logger.getLogger(Satellite.class.getName());

    private Satellite() {
        this.orientation = Orientation.NORTH;
        this.solarPanelsActive = false;
        this.dataCollected = 0;
        this.observers = new CopyOnWriteArrayList<>();
    }

    public static Satellite getInstance() {
        if (instance == null) {
            synchronized (Satellite.class) {
                if (instance == null) instance = new Satellite();
            }
        }
        return instance;
    }

    public synchronized void rotate(Orientation newOrientation) {
        this.orientation = newOrientation;
        logger.info("Satellite rotated to " + newOrientation);
        notifyObservers("rotate");
    }

    public synchronized void activatePanels() {
        if (!solarPanelsActive) {
            solarPanelsActive = true;
            logger.info("Solar panels activated.");
            notifyObservers("panels_activated");
        } else {
            logger.info("Solar panels already active.");
        }
    }

    public synchronized void deactivatePanels() {
        if (solarPanelsActive) {
            solarPanelsActive = false;
            logger.info("Solar panels deactivated.");
            notifyObservers("panels_deactivated");
        } else {
            logger.info("Solar panels already inactive.");
        }
    }

    public synchronized void collectData(int units) {
        if (solarPanelsActive) {
            dataCollected += units;
            logger.info("Collected " + units + " units of data. Total: " + dataCollected);
            notifyObservers("data_collected");
        } else {
            throw new IllegalStateException("Cannot collect data: solar panels are not active.");
        }
    }

    public Orientation getOrientation() { return orientation; }
    public boolean arePanelsActive() { return solarPanelsActive; }
    public int getDataCollected() { return dataCollected; }

    public void addObserver(SatelliteObserver obs) { observers.add(obs); }
    public void removeObserver(SatelliteObserver obs) { observers.remove(obs); }

    private void notifyObservers(String event) {
        for (SatelliteObserver o : observers) {
            try {
                o.onStateChanged(this, event);
            } catch (Exception ex) {
                logger.warning("Observer threw: " + ex.getMessage());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Orientation: %s | Panels: %s | Data: %d",
                orientation, (solarPanelsActive ? "Active" : "Inactive"), dataCollected);
    }
}
