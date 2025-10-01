package observer;

import model.Satellite;

/**
 * Observer callback for satellite state changes.
 */
public interface SatelliteObserver {
    /**
     * Invoked when satellite state changes.
     *
     * @param sat the satellite instance
     * @param event short event code string (e.g., "rotate", "panels_activated")
     */
    void onStateChanged(Satellite sat, String event);
}
