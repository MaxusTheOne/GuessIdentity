package kea.guessidentity.person;

import kea.guessidentity.api.AgifyResponse;
import kea.guessidentity.api.GenderizeResponse;
import kea.guessidentity.api.NationalizeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
    private final RestTemplate restTemplate;

    public PersonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AgifyResponse getEstimatedAge(String name, String country) {
        System.out.println("Getting age with name: " + name);
        String url = "https://api.agify.io" + "?name=" + name;

        // or throw an exception, handle error case as per your requirement
        return restTemplate.getForObject(url, AgifyResponse.class);
    }

    public GenderizeResponse getGender(String firstName) {
        System.out.println("Getting gender with First name: " + firstName);
        String url = "https://api.genderize.io?name=" + firstName;
        System.out.println();

        return restTemplate.getForObject(url, GenderizeResponse.class);
    }

    public NationalizeResponse getNationality(String lastName) {
        logger.info("Getting nationality for last name: {}", lastName);
        String url = "https://api.nationalize.io?name=" + lastName;

        // Log the URL before making the request
        logger.debug("Request URL: {}", url);

        // Perform the HTTP GET request
        NationalizeResponse response = restTemplate.getForObject(url, NationalizeResponse.class);

        // Log the response after receiving it
        logger.debug("Response received: {}", response);

        return response;

    }
}
