package by.gsu.pms;

import java.util.Date;

public class AccountingRecordDTO {
    private int recordId;
    private String car_brand;
    private String car_model;
    private String service_name;
    private String service_cost;
    private Date dueDate;

    public AccountingRecordDTO(int recordId, String car_brand, String car_model, String service_name, String service_cost, Date dueDate) {
        this.recordId = recordId;
        this.car_brand = car_brand;
        this.car_model = car_model;
        this.service_name = service_name;
        this.service_cost = service_cost;
        this.dueDate = dueDate;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getService_cost() {
        return service_cost;
    }

    public void setService_cost(String service_cost) {
        this.service_cost = service_cost;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
