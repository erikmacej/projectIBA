package my.projekt.iba.service;


import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Erik Macej
 */
public class Student {

    @Length(min=1, max=60 , message="Meno musi mať dĺžku od 1 do 60 znakov")
    @Pattern(regexp="([[A-Z]ÁÄČĎÉĚÍŇOÓŘŠŤÚŮÝŽĹĽÔŔ][[a-z]áäčďžéěíĺľňóôŕřšťúýžů[A-Z]ÁÄČĎÉĚÍŇOÓŘŠŤÚŮÝŽĹĽÔŔ\\s]*)",message="Meno obsahuje zakazané znaky")
    private String name;
    
    @Length(min=1, max=60,message="Priezvisko musi mať dĺžku od 1 do 60 znakov")
    @Pattern(regexp="([[A-Z]ÁÄČĎÉĚÍŇOÓŘŠŤÚŮÝŽĹĽÔŔ][[a-z]áäčďžéěíĺľňóôŕřšťúýžů[A-Z]ÁÄČĎÉĚÍŇOÓŘŠŤÚŮÝŽĹĽÔŔ\\s]*)",message="Priezvisko obsahuje zakazané znaky")
    private String surname;
    
    @NotNull(message="Nezadaný dátum")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    @Past(message="Dátum nie je v minulosti")
    private Date bornDate;
    
    @NotEmpty(message="Nezadané pohlavie")
    @Pattern(regexp="žena|muž",message="Zlé pohlavie môze byť len žena alebo muž")
    private String sex;
    
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

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    
    
}
