package oops.enumration;

enum Directions {
    NORTH {
        @Override
        public void move() {
            System.out.println("move up");
        }
    },
    SOUTH {
        @Override
        public void move() {
            System.out.println("move down");
        }
    },
    EAST {
        @Override
        public void move() {
            System.out.println("move right");
        }
    },
    WEST {
        @Override
        public void move() {
            System.out.println("move left");
        }
    };

    public abstract void move();
}

public class EnumAbstract {
    static void main() {
        Directions d = Directions.EAST;
        d.move();

        Direction2 d2 = new North();
        d2.move();
    }
}

// how we do without enum

abstract class Direction2 {
    public abstract void move();
}

class North extends Direction2 {
    @Override
    public void move() {
        System.out.println("move up");
    }
}
// same for other directions

/*
how compiler will convert enum(not the exact compiler output, but the closest way to understand it)

final class Directions extends Enum<Directions> {

    // Enum constants
    public static final Directions NORTH = new Directions("NORTH", 0) {

        @Override
        public void move() {
            System.out.println("move up");
        }
    };

    public static final Directions SOUTH = new Directions("SOUTH", 1) {

        @Override
        public void move() {
            System.out.println("move down");
        }
    };

    public static final Directions EAST = new Directions("EAST", 2) {

        @Override
        public void move() {
            System.out.println("move right");
        }
    };

    public static final Directions WEST = new Directions("WEST", 3) {

        @Override
        public void move() {
            System.out.println("move left");
        }
    };

    // Private constructor
    private Directions(String name, int ordinal) {
        super(name, ordinal);
    }

    // Abstract method
    public abstract void move();

    // Compiler-generated methods
    public static Directions[] values() {
        // returns all constants
    }

    public static Directions valueOf(String name) {
        // returns enum constant by name
    }
}
 */