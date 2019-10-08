package service;

import model.People;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FetchPeople {

    private final RestTemplate restTemplate;

    public FetchPeople(RestTemplateBuilder restTemplateBuilder)
    {
        this.restTemplate = restTemplateBuilder.build();
    }

    public People getPeople(){
        return this.restTemplate.getForObject("https://swapi.co/api/people/1/", People.class);
    }
}
