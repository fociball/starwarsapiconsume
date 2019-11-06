package spring;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class People {

    protected People(){}

    @Id
    int id;
    @JsonProperty
    String name;
    @JsonProperty
    int height;
    @JsonProperty
    int mass;
    @JsonProperty(value = "hair_color")
    String hairColor;
    @JsonProperty(value = "skin_color")
    String skinColor;
    @JsonProperty(value = "eye_color")
    String eyeColor;
    @JsonProperty(value = "birth_year")
    String birthYear;
    @JsonProperty
    String gender;
    @JsonProperty
    String homeworld;
    @JsonProperty
    String created;
    @JsonProperty
    String edited;
    @JsonProperty
    String url;

    public People(String name){
        this.name = name;
    }
}
