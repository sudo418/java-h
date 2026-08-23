package oops.inheritance;

class Q {
    void show() {
        System.out.println("show in Q");
    }
}

// R overrides Q's show() with its own version
class R extends Q {
    void show() {
        System.out.println("show in R");
    }
}

// S overrides Q's show() with its own version
class S extends Q {
    void show() {
        System.out.println("show in S");
    }
}
/*
class T extends R, S {     // ❌ not allowed in Java
    void Test() {
        show();         // ❌ Ambiguous — Java doesn't know whether to call R's show() or S's show()
        this.show();    // ❌ Ambiguous — Java doesn't know which inherited show() this should refer to
        super.show();   // ❌ Ambiguous — Java doesn't know whether 'super' should refer to R or S
    }
}

🔹If T could extend both R and S, T would inherit TWO different
🔹overridden versions of show() (R's version and S's version) —
🔹Java has no way to know which one T should use, so this is
🔹not allowed, avoiding the Diamond Problem entirely
*/

public class Diamond {
}
