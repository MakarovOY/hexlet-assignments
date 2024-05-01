package exercise;

// BEGIN
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileKV implements KeyValueStorage {

    private String filepath;
    private Map<String, String> dataBase;

    public FileKV(String filepath, Map<String, String> initialValueOfDB) {
        this.filepath = filepath;
        dataBase = new HashMap<>(initialValueOfDB);
        String json = Utils.serialize(dataBase);
        Utils.writeFile(filepath, json);


    }

    @Override
    public void set(String key, String value) {
        dataBase.put(key, value);
        String json=  Utils.serialize(dataBase);
        Utils.writeFile(filepath, json);

    }

    @Override
    public void unset(String key) throws IOException {

        Path path = Paths.get(filepath);
        Files.writeString(path, "");

        dataBase.remove(key);
        String json = Utils.serialize(dataBase);
        Utils.writeFile(filepath, json);


    }

    @Override
    public String get(String key, String defaultValue) {
        if (dataBase.containsKey(key)) {
            return dataBase.get(key);
        }
        return defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>(dataBase);
        return map;
    }


}

// END
