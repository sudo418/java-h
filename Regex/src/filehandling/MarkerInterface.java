package filehandling;

interface Secure{
}

class User implements Secure {
    void login() {
        System.out.println("User logged in!");
    }
}

public class MarkerInterface {
    static void main() {
        User u = new User();

        if (u instanceof Secure) {
            System.out.println("Access Granted!");
            u.login();
        }
        else System.out.println("Access Denied");
    }
}
