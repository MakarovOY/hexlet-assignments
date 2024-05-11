package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
import java.util.LinkedHashMap;
public abstract  class Tag {
    String name;
    Map<String, String> attributes;


    public Tag(String name, Map <String, String> attributes) {

        this.name = name;
        this.attributes = new LinkedHashMap<>(attributes);


    }

}

// END
