import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import model.People;
import model.PeopleList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import service.FetchPeople;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Starwars {
    private static RestTemplateBuilder RestTemplateBuilder;
    private static FetchPeople FetchPeople;

    public static void main(String args[]) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
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
        people.stream().forEach(System.out::println);

    }
}
