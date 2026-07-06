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
    void show() {
        System.out.println("show in R");
    }
}

🔹If T could extend both R and S, T would inherit TWO different
🔹overridden versions of show() (R's version and S's version) —
🔹Java has no way to know which one T should use, so this is
🔹not allowed, avoiding the Diamond Problem entirely
*/

public class Diamond {
}
