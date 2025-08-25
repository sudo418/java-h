class CellPhone {
    public void ring()
    {
        System.out.println("Ringing");
    }

    public void vibrate()
    {
        System.out.println("Vibrating");
    }
}

class Square {
    int side;

    public void setSide(int n)
    {
        side = n;
    }

    public int area ()
    {
        return side * side;
    }

    public int perimeter()
    {
        return 4 * side;
    }

}

public class Pr02 {
    public static void main(String[] args) {

        CellPhone asus = new CellPhone();

        asus.ring();
        asus.vibrate();

        Square a1 = new Square();

        a1.setSide(5);
        System.out.println(a1.area());
        System.out.println(a1.perimeter());
    }
}
