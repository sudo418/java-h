package designpattern;

// Eager Initialization
class DatabaseConnection {
    private static DatabaseConnection db = new DatabaseConnection();

    private DatabaseConnection () {
        System.out.println("Database connection established!");
    }

    public static DatabaseConnection getInstance() {
        return db;
    }
}

// Lazy way
class Logger {

    private static Logger log;

    private Logger() {
        System.out.println("logged!");
    }

    public static Logger getLog() {
        if (log == null) {
            log = new Logger();
        }
        return log;
    }
}

public class Singleton {
    static void main() {
        DatabaseConnection db = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        System.out.println(db == db2);

        System.out.println(db.hashCode());
        System.out.println(db2.hashCode());

        Logger log = Logger.getLog();
        Logger log2 = Logger.getLog();

        System.out.println(log == log2);
    }
}
