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
   javac cli/*.java model/*.java command/*.java exceptions/*.java observer/*.java
   java -cp cli.Main
