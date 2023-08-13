class DatabaseService {
    private static DatabaseService instance;

    private DatabaseService() {
        System.out.println("Open a connection with DB");
    }

    public static DatabaseService getInstance() {
        if (instance == null) {
            instance = new DatabaseService();
        }
        return instance;
    }

    public void getDataFromTable() {
        System.out.println("Gets the data from the table");
    }

    public void putDataInTable() {
        System.out.println("Puts the data in the table");
    }
}

public class singletonDesignPattern {
    public static void main(String[] args) {
        DatabaseService dbs = DatabaseService.getInstance();
        dbs = DatabaseService.getInstance();
        dbs = DatabaseService.getInstance();
        dbs = DatabaseService.getInstance();

        dbs.getDataFromTable();
        dbs.putDataInTable();
    }
}
