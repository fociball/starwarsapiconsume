package spring;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PeopleController {
    @Autowired
    PeopleService peopleService;

    @RequestMapping("/getAllPeople")
    public List<People> getAllPeople() throws IOException {
        return peopleService.getAllPeople();
    }
}