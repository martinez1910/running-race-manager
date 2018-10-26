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
