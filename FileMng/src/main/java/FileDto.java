import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder

public class FileDto {

    private List<String[]> requiredColumns;

    private List<String[]> availableColumns;

    public FileDto(List<String[]> requiredColumns, List<String[]> availableColumns) {
        this.requiredColumns = requiredColumns;
        this.availableColumns = availableColumns;
    }


}
