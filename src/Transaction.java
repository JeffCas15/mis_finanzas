import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private int transactionId;
    private String type;
    private BigDecimal amount;
    private LocalDateTime dateTime;
    private int accountId;

    //constructor
    public Transaction(int transactionId, String type, BigDecimal amount, LocalDateTime dateTime, int accountId){
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
        this.dateTime = dateTime;
        this.accountId = accountId;
    }

    //getter and setters

    public int getTransaction_id() {
        return transactionId;
    }

    public void setTransaction_id(int transaction_id) {
        this.transactionId = transaction_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
