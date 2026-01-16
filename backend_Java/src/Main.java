import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        //creating new transaction
        Transaction salary = new Transaction(-1, "expense", BigDecimal.valueOf(1000), LocalDateTime.now(), 1 );
        TrasactionDAOImp con = new TrasactionDAOImp();
        con.save(salary);

        //updating the balance in the account
        AccountDAOImp addTrasactionToAccount = new AccountDAOImp();

        if(salary.getType().equals("income")){
            addTrasactionToAccount.updateBalance(salary.getAccountId(),salary.getAmount());
        } else if(salary.getType().equals("expense")){
            addTrasactionToAccount.updateBalance(salary.getAccountId(), salary.getAmount().negate());
        }

    }
}
