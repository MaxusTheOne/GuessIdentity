package kea.guessidentity.person;

import kea.guessidentity.api.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonService {

    @Value("${agify.api.url}")
    private String agifyApiUrl;


    private final RestTemplate restTemplate;

    public PersonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<Integer> getEstimatedAge(String name) {
        String url = agifyApiUrl + "?name=" + name;
        ApiResponse response = restTemplate.getForObject(url, ApiResponse.class);
        if (response != null) {
            return ResponseEntity.ok(response.getAge());
        } else {
            return ResponseEntity.status(404).build(); // or throw an exception, handle error case as per your requirement
        }
    }
}