package model;

public enum Orientation {
    NORTH, SOUTH, EAST, WEST;

    public static Orientation fromString(String s) {
        return Orientation.valueOf(s.trim().toUpperCase());
    }
}
