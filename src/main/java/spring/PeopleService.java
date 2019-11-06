package spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class PeopleService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PeopleRepository peopleRepo;

    public PeopleService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    //fetch all people and insert into the in-mem database after spring starts
    @PostConstruct
    public void fetchPeople() throws IOException {
        // Send request with GET method and default Headers.
        LinkedHashMap list = restTemplate.getForObject("https://swapi.co/api/people/", LinkedHashMap.class);
        ArrayList temp = (ArrayList) list.get("results");

        for(int i=0;i<temp.size();i++) {
            LinkedHashMap temp2 = (LinkedHashMap) temp.get(i);
            Gson gson = new Gson();
            String json = gson.toJson(temp2, LinkedHashMap.class);
            ObjectMapper mapper = new ObjectMapper();
            People test = mapper.readValue(json, People.class);
            test.setId(i);
            peopleRepo.save(test);
        }

    }

    //Spring JPA method to find all people entities and return as a list
    public List<People> getAllPeople() throws IOException {
        return peopleRepo.findAll();
    }
}
