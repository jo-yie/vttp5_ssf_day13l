package sg.edu.nus.iss.vttp5_ssf_day13l.model;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Person {

    // validators
    // @NotNull(message = "id must be auto generated")
    private String id;

    @NotEmpty(message = "first name is mandatory")
    @Size(min = 5, max = 60, message = "first name must be between 5 to 60 characters long")
    private String firstName;

    @NotEmpty(message = "last name is mandatory")
    @Size(min = 5, max = 60, message = "last name must be between 5 to 60 characters long")
    private String lastName; 

    @Min(value = 1500, message = "minimum salary starts from $1500")
    @Max(value = 50000, message = "maximum salary ceiling is $50000")
    private Integer salary;

    @Email(message = "email input doesn't conform to email format")
    @NotBlank(message = "email is mandatory")
    private String email;

    @Past(message = "dob input is not in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    // regex: starts with 8 or 9, followed by 7 digits
    @Pattern(regexp = "(8|9)[0-9]{7}", message = "phone number must start with 8 or 9, followed by 7 digits")
    private String telephone; 

    // 111111 to 999999
    @Digits(fraction = 0, integer = 6, message = "postal code must be 6 digits")
    @Min(value = 111111, message = "postal code must be greater than 111111")
    @Max(value = 999999, message = "postal code must be less than 999999")
    private Integer postalCode; 



    public Person(String firstName, String lastName, Integer salary, String email, LocalDate dob, String telephone, Integer postalCode) { 

        // random id generated
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName; 
        this.salary = salary;
        this.email = email;
        this.dob = dob;
        this.telephone = telephone; 
        this.postalCode = postalCode;
    }

    public Person() {
        //TODO Auto-generated constructor stub
    }

    
    public String getId() {
        return id;
    }



    public void setId(String id) {
        this.id = id;
    }



    public String getFirstName() {
        return firstName;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getLastName() {
        return lastName;
    }



    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public Integer getSalary() {
        return salary;
    }



    public void setSalary(Integer salary) {
        this.salary = salary;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public LocalDate getDob() {
        return dob;
    }



    public void setDob(LocalDate dob) {
        this.dob = dob;
    }



    public String getTelephone() {
        return telephone;
    }



    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    public Integer getPostalCode() {
        return postalCode;
    }



    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }



}
