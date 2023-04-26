import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder

public class FileAvlbDomine {

    private int id;

    private String accountNumber;

    private double amount;

    private String invoiceNumber;


    private String name;

    private String date;

    public FileAvlbDomine(String id, String accountNumber, String amount, String invoiceNumber, String name, String Date) {
        this.id = Integer.parseInt(id);
        this.accountNumber = accountNumber;
        this.amount = Double.parseDouble(amount);
        this.invoiceNumber = invoiceNumber;
        this.name = name;
        this.date = String.valueOf(date);
    }
}
