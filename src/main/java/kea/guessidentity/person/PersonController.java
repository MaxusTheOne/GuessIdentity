package kea.guessidentity.person;

import jakarta.annotation.Nullable;
import kea.guessidentity.api.AgifyResponse;
import kea.guessidentity.api.FullResponse;
import kea.guessidentity.api.GenderizeResponse;
import kea.guessidentity.api.NationalizeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// I am not doing a service layer for this project, it's too short and I can't be bothered.
// I lied
@RestController
@RequestMapping("/person")
public class PersonController {


    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    // Testing endpoint for agify.io
    @GetMapping("/guess")
    public ResponseEntity<FullResponse> getAge(@RequestParam(required = false) @Nullable String name, @RequestParam(required = false) @Nullable String firstName, @RequestParam(required = false) @Nullable String middleName, @RequestParam(required = false) @Nullable String lastName) {
        Person personToSearch = new Person();
        if (name != null) {
           personToSearch.setFullName(name);
        } else {
            personToSearch.setFirstName(firstName);
            personToSearch.setMiddleName(middleName);
            personToSearch.setLastName(lastName);
            if (middleName == null) {
                personToSearch.setFullName(firstName + " " + lastName);
            } else {
                personToSearch.setFullName(firstName + " " + middleName + " " + lastName);
            }

        }


        System.out.println("Name: " + name);
        AgifyResponse agifyResponse = personService.getEstimatedAge(personToSearch.getFirstName(), personToSearch.getCountry());
        GenderizeResponse genderizeResponse = personService.getGender(personToSearch.getFirstName());
        NationalizeResponse nationalizeResponse = null;
        if (personToSearch.getLastName() != null) {
            nationalizeResponse = personService.getNationality(personToSearch.getLastName());
            System.out.println(nationalizeResponse.getCountry());
        } else {
            System.out.println("No last name found");
            nationalizeResponse = new NationalizeResponse();
        }

        FullResponse fullResponse = new FullResponse(agifyResponse, genderizeResponse, nationalizeResponse, personToSearch);
        return ResponseEntity.ok(fullResponse);
    }
}
