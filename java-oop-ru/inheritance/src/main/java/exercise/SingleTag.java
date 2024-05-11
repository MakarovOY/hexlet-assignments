package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag {

    public SingleTag(String name, Map<String, String> attributes) {
        super(name, attributes);
    }

    @Override
    public String toString() {
        if (attributes.size() == 0) {
            return String.format("<%s>", name);
        }
        StringBuilder stringBuilder = new StringBuilder();

        attributes.forEach((k, v) -> {
            stringBuilder.append(String.format(" %s=\"%s\"", k, attributes.get(k)));
        });

        return "<" + name + stringBuilder + ">";


    }
}

// END
