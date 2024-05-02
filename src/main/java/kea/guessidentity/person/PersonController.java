package kea.guessidentity.person;

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
    public ResponseEntity<Integer> getAge(@RequestParam String name, @RequestParam String country) {
        Person personToSearch = new Person(name, country);

        if (country == null) {
            country = "dk";
        }
        System.out.println("Name: " + name);
        return personService.getEstimatedAge(personToSearch.getFirstName(), personToSearch.getCountry());


    }
}
