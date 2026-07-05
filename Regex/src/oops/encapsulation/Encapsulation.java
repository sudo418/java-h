package oops.encapsulation;

class Student {
    private String name;
    private int age;
    private int roll;

    Student(String name, int age, int roll) {
        this.name = name;
        this.age = age;
        this.roll = roll;
    }

    // getter
    public String getName() {
        return name;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age > 18) {       // validation/check
            this.age = age;
        } else {
            System.out.println("you are in school");
        }
    }
}

public class Encapsulation {
    static void main() {
        Student s = new Student("Happy", 20, 101);

        s.setAge(30);
        System.out.println(s.getAge());

        s.setAge(12);
    }
}
