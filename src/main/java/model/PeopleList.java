package model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @AllArgsConstructor
public class PeopleList {

  private List<People> people;

  public PeopleList(){
      people = new ArrayList<>();
  }

    public List<People> getPeople() {
        return people;
    }
}
