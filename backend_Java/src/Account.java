import java.math.BigDecimal;

public class Account {
    private int accountId;
    private BigDecimal balance;

    // constructor
    public Account(BigDecimal balance, int accountId) {
        this.balance = balance;
        this.accountId = accountId;
    }

    //Getters & setters
    public int getAccount_id() {
        return accountId;
    }

    public void setAccount_id(int accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
