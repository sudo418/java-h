class Employee {
    int id;
    String name;
    int salary;

    public void details()
    {
        System.out.print("My name is: " + name);
        System.out.println(" and my id is: " + id);
    }

    public void getsalary()
    {
        System.out.println(salary);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String n)
    {
        name = n;
    }
}

public class Main {
    public static void main(String[] args) {

        // Instantiating a new Employee Object
        Employee avi = new Employee();
        Employee chirayu = new Employee();

        avi.id = 11;
        avi.name = "Avi Shah";
        avi.salary = 1000000;

        chirayu.id = 12;
        chirayu.name = "Chirayu Shah";
        chirayu.salary = 2000000;

        System.out.println(chirayu.id);

        avi.details();
        avi.getsalary();
        System.out.println(avi.getName());

        chirayu.details();
        chirayu.getsalary();
        System.out.println(chirayu.getName());

        avi.setName("Hello World!");
        System.out.println(avi.getName());
    }
}