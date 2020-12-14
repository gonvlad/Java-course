package by.gsu.pms;

public class Mapper {
    public AccountingRecordDTO mapAccountingRecordDTO(AccountingRecord accountingRecord, Car car, Service service){
        return AccountingRecordDTO.builder()
                .recordId(accountingRecord.getRecordId())
                .carBrand(car.getCarBrand())
                .carModel(car.getCarModel())
                .serviceName(service.getServiceName())
                .serviceCost(service.getServiceCost())
                .dueDate(accountingRecord.getDueDate())
                .build();
    }
}
