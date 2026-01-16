import java.time.LocalDateTime;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TrasactionDAOImp implements TransactionDAO{

    @Override
    public void save(Transaction transaction){
        //SQL
        String sqlSave = "INSERT INTO transactions (transaction_type, amount, account_id) VALUES (?,?,?)";

        //try using preparedStatement
        try(PreparedStatement ps = dbConnection.connectDb().prepareStatement(sqlSave)){
            ps.setString(1,transaction.getType());
            ps.setBigDecimal(2,transaction.getAmount());
            ps.setInt(3, transaction.getAccountId());

            ps.executeUpdate();

            System.out.println("The transaction has been saved succesfully!");

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int transactionId) {

    }

    @Override
    public void edit(Transaction transaction) {

    }

    @Override
    public List<Transaction> findAll() {
        return List.of();
    }
}
