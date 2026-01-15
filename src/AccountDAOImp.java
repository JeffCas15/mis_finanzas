import java.math.BigDecimal;
import java.sql.*;

public class AccountDAOImp implements AccountDAO{
    @Override
    public BigDecimal currentBalance(int accountId) {
        //establish initial balance amount and SQL sentence
        BigDecimal balance = BigDecimal.ZERO;
        String sql = "SELECT balance FROM accounts WHERE account_id = ?";

        //connection using try-with-resources to close the connection
        try(Connection conn = dbConnection.connectDb(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1, accountId);

            //Assign the object returned to a ResultSet object
            ResultSet rs = ps.executeQuery();

            //Moving to the first row of the table
            if (rs.next()){
                balance = rs.getBigDecimal("balance");
            }
        } catch (SQLException e){  //exception
            e.printStackTrace();
        }

        return balance; //returning balance
    }

    @Override
    public void updateBalance(int accountId, BigDecimal amount) {

        String sql = "UPDATE accounts SET balance = balance + ? WHERE account_id = ? ";

        try(Connection conn = dbConnection.connectDb(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setBigDecimal(1, amount);
            ps.setInt(2, accountId);

            ps.executeUpdate();
            System.out.println("Your balance has been updated.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
