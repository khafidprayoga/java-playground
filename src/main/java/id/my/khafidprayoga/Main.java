package id.my.khafidprayoga;

abstract class Connection {
    abstract String URI();

    abstract long poolCount();
}

class MySQLConnection extends Connection {

    @Override
    String URI() {
        return "";
    }

    @Override
    long poolCount() {
        return 0;
    }

    void prepareStmt() {
    }
}

public class Main {
    public static void main(String[] args) {
//         error bcz abstract class cant be instantiated
        //        Connection mongo = new Connection();
        MySQLConnection sql = new MySQLConnection();

        sql.poolCount();
        sql.URI();
        sql.prepareStmt();
    }
}