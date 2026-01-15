import java.math.BigDecimal;

public interface AccountDAO {

    public BigDecimal currentBalance(int accountId);
    void updateBalance(int accountId, BigDecimal amount);
}
