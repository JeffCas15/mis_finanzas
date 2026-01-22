import java.util.List;

public interface TransactionDAO {

   void save (Transaction transaction);
   void remove(int transactionId);
   void edit(Transaction transaction);
   Transaction findById(int transactionId);
   List<Transaction> findAll();
}
