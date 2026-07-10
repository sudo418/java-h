package oops.enumration;

enum Direction {
    NORTH(0),
    SOUTH(180),
    EAST(90),
    WEST(270);

    private int degree;

    Direction (int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }
}

public class EnumConstructor {
    static void main() {
        Direction d = Direction.SOUTH;
        System.out.println(d.getDegree());
    }
}
/*
compiler generated class of this enum :-

final class Direction extends Enum<Direction> {

    // Enum constants (objects)
    public static final Direction NORTH = new Direction("NORTH", 0, 0);
    public static final Direction SOUTH = new Direction("SOUTH", 1, 180);
    public static final Direction EAST  = new Direction("EAST", 2, 90);
    public static final Direction WEST  = new Direction("WEST", 3, 270);

    // Instance variable
    private int degree;

    // Private constructor
    private Direction(String name, int ordinal, int degree) {
        super(name, ordinal);
        this.degree = degree;
    }

    // Getter
    public int getDegree() {
        return degree;
    }

    // Compiler-generated methods

    public static Direction[] values() {
        // returns all enum constants
    }

    public static Direction valueOf(String name) {
        // returns the enum constant whose name matches 'name'
    }
}
 */