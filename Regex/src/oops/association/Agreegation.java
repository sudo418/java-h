package oops.association;

class MusicPlayer {
    void play() {
        System.out.println("playing music..");
    }
}

class Truck {
    MusicPlayer mp;   // Truck HAS-A MusicPlayer (aggregation)

    Truck(MusicPlayer mp) {
        this.mp = mp;   // existing MusicPlayer object passed in, NOT created here
    }

    void start() {
        System.out.println("Truck Started");
        mp.play();
    }
}

public class Agreegation {
    static void main() {
        MusicPlayer mp = new MusicPlayer();
        Truck t = new Truck(mp);

        t.start();
    }
}
/*
IMPORTANT POINTS - AGGREGATION

1. definition:
   aggregation = HAS-A relationship where a container class holds a
   reference to another class's object, but the contained object's
   lifecycle is INDEPENDENT of the container

2. why this is aggregation, not composition:
   - MusicPlayer object is created OUTSIDE Truck (in main), then passed
     into Truck's constructor
   - Truck never does "new MusicPlayer()" itself
   - same mp object could be reused in another Truck too

3. object independence (both directions):
   - if Truck object is deleted -> mp (MusicPlayer) still exists fine,
     reusable elsewhere
   - if mp is set to null -> Truck object still exists fine, just
     t.mp becomes null (would cause NullPointerException only if
     start() is called after that, since it calls mp.play())
   - neither object's existence controls the other's existence

4. code-level dependency vs object-level dependency (different things):
   - code-level: Truck's code needs MusicPlayer class to exist to
     compile (true for every class relationship, not special to
     aggregation)
   - object-level (this is what actually defines aggregation/composition):
     does deleting one OBJECT at runtime destroy the other OBJECT?
     in aggregation -> NO

6. aggregation vs composition (quick contrast):
   - aggregation = weak ownership, independent lifecycles (this example)
   - composition = strong ownership, dependent lifecycles
     (e.g. House destroyed -> Rooms destroyed too, since object is
     created INSIDE the container class itself)
*/
