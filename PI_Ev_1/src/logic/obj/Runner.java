package logic.obj;

import java.util.Date;


public class Runner {
    private String name;
    private String surname;
    private Date dateOfBirth;

    public Runner(String name, String surname, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Runner(String[] runner) {
        if(runner.length != 3) 
            throw new IllegalArgumentException("Cannot construct the object with the given array (inconsistent number of elements found)");
        this.name = runner[0];
        this.surname = runner[1];
        this.dateOfBirth = new Date(Long.parseLong(runner[2]));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Corredor{" + "nombre=" + name + ", apellido=" + surname + ", fechaDeNacimiento=" + dateOfBirth + '}';
    }
    
    public String toCSV(){
        String csv = "";
        csv += this.name +",";
        csv += this.surname +",";
        csv += Long.toString(this.dateOfBirth.getTime());
        return csv;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj == this) return true;
        if(!(obj instanceof Runner)) return false;
        Runner runner = (Runner) obj;
        return runner.name.equals(this.name)
                && runner.surname.equals(this.surname)
                && runner.dateOfBirth.equals(this.dateOfBirth);
    }
}
