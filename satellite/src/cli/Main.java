package cli;

import command.*;
import exceptions.InvalidCommandException;
import model.Orientation;
import model.Satellite;
import observer.MissionControl;

import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Console CLI for Satellite Command System
 *
 * Supported commands:
 *   rotate <north|south|east|west>
 *   activatePanels
 *   deactivatePanels
 *   collectData <units>
 *   status
 *   help
 *   exit
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        setupLogging();

        Satellite sat = Satellite.getInstance();
        sat.addObserver(new MissionControl());

        CommandProcessor processor = new CommandProcessor();
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Satellite Command System CLI ===");
        printHelp();

        while (true) {
            System.out.print("> ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            try {
                if (line.equalsIgnoreCase("exit") || line.equalsIgnoreCase("quit")) {
                    System.out.println("Exiting. Goodbye.");
                    break;
                }
                Command cmd = parse(line);
                processor.execute(cmd);
            } catch (InvalidCommandException e) {
                System.out.println("Invalid command: " + e.getMessage());
            } catch (IllegalStateException e) {
                System.out.println("Operation failed: " + e.getMessage());
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Unexpected error", e);
            }
        }

        sc.close();
    }

    private static Command parse(String line) throws InvalidCommandException {
        String[] parts = line.split("\\s+");
        String c = parts[0].toLowerCase();

        switch (c) {
            case "rotate":
                if (parts.length < 2) throw new InvalidCommandException("rotate requires a direction");
                Orientation o;
                try { o = Orientation.fromString(parts[1]); }
                catch (Exception ex) { throw new InvalidCommandException("unknown orientation: " + parts[1]); }
                return new RotateCommand(o);
            case "activatepanels":
            case "activate":
                return new ActivatePanelsCommand();
            case "deactivatepanels":
            case "deactivate":
                return new DeactivatePanelsCommand();
            case "collectdata":
            case "collect":
                if (parts.length < 2) throw new InvalidCommandException("collectData requires units integer");
                int units;
                try { units = Integer.parseInt(parts[1]); }
                catch (NumberFormatException ex) { throw new InvalidCommandException("units must be an integer"); }
                if (units <= 0) throw new InvalidCommandException("units must be positive");
                return new CollectDataCommand(units);
            case "status":
                return new Command() {
                    @Override public void execute() { System.out.println(Satellite.getInstance().toString()); }
                };
            case "help":
                return new Command() { @Override public void execute() { printHelp(); } };
            default:
                throw new InvalidCommandException("unknown command: " + c);
        }
    }

    private static void printHelp() {
        System.out.println("Commands:");
        System.out.println("  rotate <north|south|east|west>   - rotate satellite");
        System.out.println("  activatePanels                   - activate solar panels");
        System.out.println("  deactivatePanels                 - deactivate solar panels");
        System.out.println("  collectData <units>              - collect data (requires active panels)");
        System.out.println("  status                           - show satellite status");
        System.out.println("  help                             - show this help");
        System.out.println("  exit                             - quit");
    }

    private static void setupLogging() {
        Logger root = Logger.getLogger("");
        root.setLevel(Level.INFO);
        // ensure console handler exists and at appropriate level
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.INFO);
        root.addHandler(ch);
    }
}
