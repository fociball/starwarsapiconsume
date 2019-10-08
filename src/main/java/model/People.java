package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class People {

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
    String[] films;
    @JsonProperty
    String[] species;
    @JsonProperty
    String[] vehicles;
    @JsonProperty
    String[] starships;
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
