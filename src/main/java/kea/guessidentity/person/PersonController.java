package kea.guessidentity.person;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// I am not doing a service layer for this project, it's too short and I can't be bothered.
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    // Testing endpoint for agify.io
    // @GetMapping("/age")
    public String getAge() {

        return "Hello";
    }
}
