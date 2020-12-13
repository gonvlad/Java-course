package by.gsu.pms;

import java.util.Date;

public class AccountingRecord {
    private int recordId;
    private int carId;
    private int serviceId;
    private Date dueDate;

    public AccountingRecord(int recordId, int carId, int serviceId, Date dueDate) {
        this.recordId = recordId;
        this.carId = carId;
        this.serviceId = serviceId;
        this.dueDate = dueDate;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
