package by.gsu.pms;

import java.util.ArrayList;

public class Abiturient implements Comparable<Abiturient> {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private String mobilePhoneNumber;
    private ArrayList<Integer> marks;

    public Abiturient(int id, String surname, String name, String patronymic, String address, String mobilePhoneNumber, ArrayList<Integer> marks) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }

    public void setMarks(ArrayList<Integer> marks) {
        this.marks = marks;
    }

    public int getTotalMark() {
        int sum = 0;
        for (Integer mark: marks) {
            sum += mark;
        }
        return sum;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nSurname: " + surname +
                "\nName: " + name +
                "\nPatronymic: " + patronymic +
                "\nAddress: " + address +
                "\nMobile phone number: " + mobilePhoneNumber +
                "\nAbiturient marks: " + marks.toString();
    }

    @Override
    public int compareTo(Abiturient abiturient) {
        if (this.getTotalMark() < abiturient.getTotalMark()) {
            return 1;
        } else if (this.getTotalMark() > abiturient.getTotalMark()) {
            return -1;
        }
        return  0;
    }
}
