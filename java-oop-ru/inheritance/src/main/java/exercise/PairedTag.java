package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag{

    String text;
    List<Tag> children;

    public PairedTag(String name, Map<String, String> attributes, String text, List<Tag> children){

        super(name, attributes);
        this.text = text;
        this.children = new ArrayList<>(children);

    }

    @Override
    public String toString() {



        StringBuilder stringBuilder = new StringBuilder();

        if (attributes.size() == 0){
            return String.format("<%s></%s>", name, name);
        }


        attributes.forEach((k,v) ->{
            stringBuilder.append(String.format(" %s=\"%s\"", k, attributes.get(k)));

        });

        if (children.size() == 0){
            return "<"+ name + stringBuilder + ">" + String.format("%s</%s>",text, name);
        }


        StringBuilder stringBuilderChild = new StringBuilder();
        children.forEach(e -> {
            stringBuilderChild.append(e.toString());

        });



        return "<"+ name + stringBuilder + ">" + String.format("%s</%s>",stringBuilderChild, name);

    }
}

// END
