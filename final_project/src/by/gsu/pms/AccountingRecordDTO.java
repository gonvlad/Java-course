package by.gsu.pms;

import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountingRecordDTO {
    private int recordId;
    private String carBrand;
    private String carModel;
    private String serviceName;
    private String serviceCost;
    private Date dueDate;
}
