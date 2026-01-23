import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        /* creating new transaction
        Transaction salary = new Transaction(-1, "expense", BigDecimal.valueOf(10000), LocalDateTime.now(), 1, 1);
        TrasactionDAOImp con = new TrasactionDAOImp();
        con.save(salary);

        updating the balance in the account
        AccountDAOImp addTrasactionToAccount = new AccountDAOImp();

        if(salary.getType().equals("income")){
            addTrasactionToAccount.updateBalance(salary.getAccountId(),salary.getAmount());
        } else if(salary.getType().equals("expense")){
            addTrasactionToAccount.updateBalance(salary.getAccountId(), salary.getAmount().negate());
        }



        //find by id and find all
        TransactionDaoImp find = new TransactionDaoImp();
        System.out.println(find.findById(3).toString());

        System.out.println(find.findAll().toString());
        */

        //edit
        TransactionDaoImp find = new TransactionDaoImp();
        System.out.println(find.findById(3).toString());

        Transaction updateTransaction = find.findById(3);

        updateTransaction.setCategoryId(8);
        updateTransaction.setDateTime(LocalDateTime.now());
        find.edit(updateTransaction);

        System.out.println(find.findById(3).toString());

        //creating new transaction
        Transaction netflix = new Transaction(-1, "expense", BigDecimal.valueOf(20000), LocalDateTime.now(), 1, 8, "Netflix");
        TransactionDaoImp con = new TransactionDaoImp();
        con.save(netflix);






    }
}
