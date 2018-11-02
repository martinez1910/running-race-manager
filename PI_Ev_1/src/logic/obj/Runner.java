package logic.obj;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


public class Runner {
    private String name;
    private String id;
    private Date dateOfBirth;
    private String address;
    private String phoneNumber;

    public Runner(String name, String id, Date dateOfBirth, String address, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    
    public Runner(String[] runner) {
        if(runner.length != 5) 
            throw new IllegalArgumentException("Cannot construct the object with the given array (inconsistent number of elements found)");
        this.name = runner[0];
        this.id = runner[1];
        this.dateOfBirth = new Date(Long.parseLong(runner[2]));
        this.address = runner[3];
        this.phoneNumber = runner[4];
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("es", "ES"));
        return "Corredor{" + "nombre=" + name + ", DNI=" + id + ", fechaDeNacimiento=" + df.format(dateOfBirth) + ", dirección=" + address + ", teléfono=" + phoneNumber + '}';
    }
    
    public String toCSV(){
        String csv = "";
        csv += this.name +",";
        csv += this.id +",";
        csv += Long.toString(this.dateOfBirth.getTime()) +",";
        csv += this.address +",";
        csv += this.phoneNumber;
        return csv;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj == this) return true;
        if(!(obj instanceof Runner)) return false;
        Runner runner = (Runner) obj;
        return runner.name.equals(this.name)
                && runner.id.equals(this.id)
                && runner.dateOfBirth.equals(this.dateOfBirth)
                && runner.address.equals(this.address)
                && runner.phoneNumber.equals(this.phoneNumber);
    }
}
