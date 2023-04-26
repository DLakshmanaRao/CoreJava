import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class FileDomine {

    private String accountNumber;

    private double amount;

    private String invoiceNumber;


    public FileDomine(String accountNum, String amount, String invoiceNum) {
        this.accountNumber = accountNumber;
        this.amount = Double.parseDouble(amount);
        this.invoiceNumber = invoiceNumber;
    }

}
