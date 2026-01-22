import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private int transactionId;
    private String type;
    private BigDecimal amount;
    private LocalDateTime dateTime;
    private int accountId;
    private int categoryId;

    //constructor
    public Transaction(int transactionId, String type, BigDecimal amount, LocalDateTime dateTime, int accountId, int categoryId){
        this.transactionId = transactionId;
        this.amount = amount;
        this.type = type;
        this.dateTime = dateTime;
        this.accountId = accountId;
        this.categoryId = categoryId;
    }

//getter and setters

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
