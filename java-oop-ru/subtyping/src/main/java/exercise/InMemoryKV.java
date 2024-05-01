package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {

    private Map <String, String> valueOfDB;

    public InMemoryKV(Map valueOfDB) {

        this.valueOfDB = new HashMap<>(valueOfDB)  ;
    }


    @Override
    public void set(String key, String value) {
        valueOfDB.put(key, value);
    }

    @Override
    public void unset(String key) {
        valueOfDB.remove(key);

    }

    @Override
    public String get(String key, String defaultValue) {
        if (valueOfDB.containsKey(key)){
            return valueOfDB.get(key);
        }
        return defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>(valueOfDB);
        return map;
    }
}

// END
