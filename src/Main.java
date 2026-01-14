import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Transaction salary = new Transaction(-1, "income", BigDecimal.valueOf(250000), LocalDateTime.now(), 1 );
        TrasactionDAOImp con = new TrasactionDAOImp();
        con.save(salary);
    }
}
