package spring;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

@Service
public class PeopleService {

    @Autowired
    private static RestTemplate restTemplate;

    public PeopleService(RestTemplate restTemplate)
    {
        this.restTemplate = restTemplate;
    }

    public static ArrayList getAllPeople() throws IOException {
        ArrayList people = new ArrayList();

        // Send request with GET method and default Headers.
        LinkedHashMap list = restTemplate.getForObject("https://swapi.co/api/people/", LinkedHashMap.class);
        ArrayList temp = (ArrayList) list.get("results");

        for(int i=0;i<temp.size();i++) {
            LinkedHashMap temp2 = (LinkedHashMap) temp.get(i);
            Gson gson = new Gson();
            String json = gson.toJson(temp2, LinkedHashMap.class);
            ObjectMapper mapper = new ObjectMapper();
            People test = mapper.readValue(json, People.class);
            people.add(test);
        }
        return people;
    }
}
