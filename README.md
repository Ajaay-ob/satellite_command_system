# Satellite Command System (Java)

Simple console-based Satellite Command System demonstrating:
- Singleton pattern (`model.Satellite`)
- Command pattern (commands in `command/`)
- Observer pattern (`observer.MissionControl`)
- Logging, validation, and exception handling

## Structure
- src/cli/Main.java (CLI)
- src/model/ (Satellite, Orientation)
- src/command/ (Command interface + concrete commands + CommandProcessor)
- src/observer/ (SatelliteObserver, MissionControl)
- src/exceptions/ (custom exceptions)

## Build & Run (Unix / macOS / Windows with Git Bash)
1. From project root:
   ```bash
   mkdir src
   <!-- To compile this project follow thw below line -->
   <!-- javac cli/*.java model/*.java command/*.java exceptions/*.java observer/*.java -->
   java -cp cli.Main

## Follow the steps to see the output
1. Commands:
  rotate <north|south|east|west>   - rotate satellite
  activatePanels                   - activate solar panels
  deactivatePanels                 - deactivate solar panels
  collectData <units>              - collect data (requires active panels)
  status                           - show satellite status
  help                             - show this help
  exit                             - quit
<!-- Provide direction along with rotate -->
2. rotate north
<!-- To activate panels provide the given below step-->
3. activatePanels 
<!-- To collect data -->
4. collect 10
<!-- To check the status -->
5. status
<!-- To deactivate panels -->
6. deactivatePanels
<!-- To exit  -->
7. exit



