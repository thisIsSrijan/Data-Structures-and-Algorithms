//Programing to implementation, Bad practice
// The Application class is tightly coupled to MySQLDatabase.
// If we want to switch to PostgreSQLDatabase, we must modify the Application class.

// class MySQLDatabase {
//     void connect() {
//         System.out.println("Connected to MySQL");
//     }
// }
// class Application {
//     private MySQLDatabase db; // Direct dependency on MySQLDatabase
//     Application() {
//         db = new MySQLDatabase(); // Tightly coupled
//     }
//     void start() {
//         db.connect();
//     }
// }
// public class Main {
//     public static void main(String[] args) {
//         Application app = new Application();
//         app.start();  // Output: Connected to MySQL
//     }
// }


//programming to interface, Good practice

public class Interface {
    // Interface defining expected behavior

    static interface Database {

        void connect();
    }

// Concrete implementations
    static class MySQLDatabase implements Database {

        public void connect() {
            System.out.println("Connected to MySQL");
        }
    }

    static class PostgreSQLDatabase implements Database {

        public void connect() {
            System.out.println("Connected to PostgreSQL");
        }
    }

// Application depends on the interface, not a specific implementation
    static class Application {

        private Database db;

        // Constructor injection (Dependency Injection)
        Application(Database db) {
            this.db = db;
        }

        void start() {
            db.connect();
        }
    }

    public class Main {

        public static void main(String[] args) {
            // We can easily switch database implementations
            Database mysql = new MySQLDatabase();
            Application app1 = new Application(mysql);
            app1.start();  // Output: Connected to MySQL

            Database postgres = new PostgreSQLDatabase();
            Application app2 = new Application(postgres);
            app2.start();  // Output: Connected to PostgreSQL
        }
    }

}
