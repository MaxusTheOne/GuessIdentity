package kea.guessidentity.person;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getGenderProbability() {
        return genderProbability;
    }

    public void setGenderProbability(Double genderProbability) {
        this.genderProbability = genderProbability;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getAgeProbability() {
        return ageProbability;
    }

    public void setAgeProbability(Double ageProbability) {
        this.ageProbability = ageProbability;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Double getCountryProbability() {
        return countryProbability;
    }

    public void setCountryProbability(Double countryProbability) {
        this.countryProbability = countryProbability;
    }

    private String fullName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private Double genderProbability;
    private int age;
    private Double ageProbability;
    private String country;
    private Double countryProbability;

    public Person() {
    }

    public Person(String fullName, String firstName, String middleName, String lastName) {
        this.fullName = fullName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}