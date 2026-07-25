package filehandling;

import java.io.*;

class Student implements Serializable {
    int roll;
    String name;
    transient String pass;

    Student(int roll, String name, String pass) {
        this.roll = roll;
        this.name = name;
        this.pass = pass;
    }
}

public class Serialization {
    static void main() throws IOException, ClassNotFoundException {
        Student s = new Student(1, "hello", "hello@123");

        // folder for file of serialization
        File f1 = new File("D:\\code\\java\\Regex\\src\\filehandling\\Serialization");
        if (!f1.exists()) {
            f1.mkdir();
        }
        else System.out.println("folder already exists");

        // Serialization
        FileOutputStream fos = new FileOutputStream("D:\\code\\java\\Regex\\src\\filehandling\\Serialization\\student.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s);
        oos.close();

        System.out.println("Object Serialized");


        // deserialization
        FileInputStream fis = new FileInputStream("D:\\code\\java\\Regex\\src\\filehandling\\Serialization\\student.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Student s2 = (Student) ois.readObject();    //readObject() returns type Object, so you must typecast it back to the original class
        ois.close();

        System.out.println("roll = " + s2.roll + ", name = " + s2.name + ", pass = " + s2.pass);
    }
}
