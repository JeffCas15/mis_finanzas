import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TransactionDaoImp implements TransactionDAO{
    @Override
    public void save(Transaction transaction){
        //SQL
        String sqlSave = "INSERT INTO transactions (type, amount, account_id, category_id, description) VALUES (?,?,?,?,?)";

        //try using preparedStatement
        try(PreparedStatement ps = dbConnection.connectDb().prepareStatement(sqlSave)){
            ps.setString(1,transaction.getType());
            ps.setBigDecimal(2,transaction.getAmount());
            ps.setInt(3, transaction.getAccountId());
            ps.setInt(4, transaction.getCategoryId());
            ps.setString(5, transaction.getDescription());

            ps.executeUpdate();

            System.out.println("The transaction has been saved succesfully!");

        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void remove(int transactionId) {
        //sql
        String sqlRemove = "DELETE FROM transactions WHERE transaction_id = ?";
        try(PreparedStatement ps = dbConnection.connectDb().prepareStatement(sqlRemove)){
            ps.setInt(1, transactionId);

            //executing
            ps.executeUpdate();
            System.out.println("The transaction #" + transactionId + " has been deleted !");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void edit(Transaction transaction) {

        //note must  use full object from the frontend to avoid overriding null values in the database.

        //sql consult
        String sqlEdit = "UPDATE transactions SET type = ? , amount = ?, date_time = ?, category_id = ? WHERE transaction_id = ?";

        //try with preparedstament
        try(PreparedStatement ps = dbConnection.connectDb().prepareStatement(sqlEdit)){
            ps.setString(1, transaction.getType());
            ps.setBigDecimal(2, transaction.getAmount());
            ps.setTimestamp(3, Timestamp.valueOf(transaction.getDateTime()));
            ps.setInt(4, transaction.getCategoryId());
            ps.setInt(5, transaction.getTransactionId());

            //executing update
            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @Override
    public Transaction findById(int transactionId) {
        //sql consult
        String sqlSearch = "SELECT * FROM transactions WHERE transaction_id = ?" ;

        Transaction transactionRecovered = null;
        try (PreparedStatement ps = dbConnection.connectDb().prepareStatement(sqlSearch)) {
            ps.setInt(1, transactionId);

            ResultSet response = ps.executeQuery();

            if (response.next()) {

                //mapping the data to the new object
                transactionRecovered = new Transaction(
                        response.getInt("transaction_id"),
                        response.getString("type"),
                        response.getBigDecimal("amount"),
                        response.getTimestamp("date_time").toLocalDateTime(),
                        response.getInt("account_id"),
                        response.getInt("category_id"),
                        response.getString("description")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transactionRecovered;
    }

    @Override
    public List<Transaction> findAll() {
        List<Transaction> list = new ArrayList<>();
        // SQL
        String sqlSearchAll = "SELECT * FROM transactions";

        //try with prepared stament
        try(PreparedStatement ps = dbConnection.connectDb().prepareStatement(sqlSearchAll)){

            //response saved in ResulSet object
            ResultSet rs = ps.executeQuery();

            //mapping fields into new object
            while(rs.next()){
                Transaction allTransactions = new Transaction(
                        rs.getInt("transaction_id"),
                        rs.getString("type"),
                        rs.getBigDecimal("amount"),
                        rs.getTimestamp("date_time").toLocalDateTime(),
                        rs.getInt("account_id"),
                        rs.getInt("category_id"),
                        rs.getString("description")
                );

                //adding the mapped object into the list
                list.add(allTransactions);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return list;
    }
}