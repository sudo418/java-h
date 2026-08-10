package collections.ch01_Iterable;

import java.util.Iterator;

public class CustomCollection {
    static void main() {
        String[] name = {"hello", "world", "java", "springboot"};

        NameContainer nc = new NameContainer(name);

        Iterator<String> it = nc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Enhanced for loop = same iterator + hasNext() + next() code,
        // just hidden by the compiler so you don't have to write it by hand.
        for (String n : nc) {
            System.out.println(n);
        }
    }
}

class NameContainer implements Iterable<String> {
    private String[] names;
    private int size;

    public NameContainer(String[] names) {
        this.names = names;
        this.size = this.names.length;
    }

    /*
    @Override
    public Iterator<String> iterator() {
        return new NameContainerIterator();
    }

    private class NameContainerIterator implements Iterator<String> {
        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < names.length;
        }

        @Override
        public String next() {
            return names[cursor++];
        }
    }   Iterator implementation is used only inside iterator(), no
    separate named class needed since it's not reused anywhere else in the code
    */

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int cursor = 0;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public String next() {
                return names[cursor++];
            }
        };
    }
}
/*
If iterator() and "implements Iterable<String>" are removed,
the enhanced for loop  will give a compile error, since it only
works on arrays or objects that implement Iterable
 */