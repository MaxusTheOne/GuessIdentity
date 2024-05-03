package kea.guessidentity.api;

import jakarta.persistence.Cacheable;
import kea.guessidentity.person.Person;

import java.text.DecimalFormat;
import java.util.List;

@Cacheable
public class FullResponse {

    private String fullName;
    private String firstName;
    private String middleName;
    private String lastName;
    private int age;
    private String gender;
    private double genderProbability;
    private List<Country> country;
    private double countryProbability;

    public FullResponse(AgifyResponse agifyResponse, GenderizeResponse genderizeResponse, NationalizeResponse nationalizeResponse ,Person person){
        this.setAge(agifyResponse.getAge());
        this.setGender(genderizeResponse.getGender());
        this.setGenderProbability(genderizeResponse.getProbability());
        this.setFullName(person.getFullName());
        this.setFirstName(person.getFirstName());
        this.setMiddleName(person.getMiddleName());
        this.setLastName(person.getLastName());
        this.setCountry(nationalizeResponse.getCountry());
        this.setCountryProbability(nationalizeResponse.getProbability());
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getGenderProbability() {
        return genderProbability;
    }

    public void setGenderProbability(double genderProbability) {
        this.genderProbability = genderProbability;
    }

    public String getCountry() {
        if (this.country == null) {
            return null; // or return null if you prefer
        } else {
            return this.country.get(0).getCountry_id();
        }
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }


    public double getCountryProbability() {
        if (this.country == null) {
            return 0.0;
        } else {
            return ((double)((int)(this.country.get(0).getProbability() *100.0)))/100.0;
        }
    }

    public void setCountryProbability(double countryProbability) {
        this.countryProbability = countryProbability;
    }
}
