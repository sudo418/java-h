package oops.association;

class Engine {
    void startEngine() {
        System.out.println("Engine starting...");
    }
}

class Train  {
    Engine e;

    Train() {
        e = new Engine();
    }

    void startTrain() {
        System.out.println("Train starting...");
        e.startEngine();
    }
}

public class Composition {
    static void main() {
        Train t = new Train();
        t.startTrain();
    }
}
/*
WHY WE USE CONSTRUCTOR TO CREATE ENGINE, NOT FIELD DECLARATION DIRECTLY

Option A - directly at field declaration:
    class Train {
        Engine engine = new Engine();
    }

Option B - inside constructor (what we used):
    class Train {
        Engine engine;
        Train() {
            engine = new Engine();
        }
    }

both create the Engine object when Train object is created, both are
still composition either way. but constructor way is preferred because:

reason 1 - constructor lets creation depend on values passed in:
    class Engine {
        int horsepower;
        Engine(int horsepower) {
            this.horsepower = horsepower;
        }
    }

    class Train {
        Engine engine;
        Train(int enginePower) {
            engine = new Engine(enginePower);   // using Train's own
                                                  // constructor input
        }
    }
    cannot do this with field initializer, because field initializers
    run before the constructor even receives its arguments -> no way
    to pass enginePower into it at that point

reason 2 - constructor allows branching/conditional logic:
    Train(String type) {
        if (type.equals("electric")) {
            engine = new ElectricEngine();
        } else {
            engine = new DieselEngine();
        }
    }
    field initializer is just one flat statement, no if/else possible,
    constructor is a full method body so it gives full flexibility

for simple no-arg cases (like our actual Engine example) both options
work identically, constructor way is just the more general pattern
that scales when arguments/branching are needed later
*/


