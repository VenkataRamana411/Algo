package target;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.SQLNonTransientException;

public class Overrider {

    public void print() throws SQLNonTransientException {

    }

}

class child extends Overrider{

    @Override
    public void print() throws SQLDataException {
        try {
            super.print();
        } catch (SQLNonTransientException e) {
            throw new RuntimeException(e);
        }
    }
}
