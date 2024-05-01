package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;
// BEGIN
import java.io.IOException;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;
import org.junit.jupiter.api.Test;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void unsetTest() throws IOException {
        Map<String, String>  mapTest = new HashMap<>(Map.of("key1", "value1", "key2", "key2"));
        KeyValueStorage keyValueStorage = new FileKV("src/test/resources/file", mapTest);
        keyValueStorage.unset("key2");
        String exp = "{\"key1\":\"value1\"}";
        String  act = Utils.readFile("src/test/resources/file");
        assertThat(act).isEqualTo(exp);

    }

    @Test
    void setTest() {
        Map<String, String>  mapTest = new HashMap<>(Map.of("key1", "value1"));
        KeyValueStorage keyValueStorage = new FileKV("src/test/resources/file", mapTest);
        keyValueStorage.set("key2", "value2");
        String actual = Utils.readFile("src/test/resources/file");
        String exp = "{\"key1\":\"value1\",\"key2\":\"value2\"}";
        assertThat(actual).isEqualTo(exp);
    }

    @Test
    void getTest() {
        Map<String, String>  mapTest = new HashMap<>(Map.of("key1", "value1"));
        KeyValueStorage keyValueStorage = new FileKV("src/test/resources/file", mapTest);
        String actual = keyValueStorage.get("key1", "def v");
        String expected = "value1";
        assertThat(actual).isEqualTo(expected);

    }
    @Test
    void getTest2() {
        Map<String, String>  mapTest = new HashMap<>(Map.of("key1", "value1"));
        KeyValueStorage keyValueStorage = new FileKV("src/test/resources/file", mapTest);
        String actual = keyValueStorage.get("key2", "def v");
        String expected = "def v";
        assertThat(actual).isEqualTo(expected);

    }
    @Test
    void toMapTest() {
        Map<String, String>  mapTest = new HashMap<>(Map.of("key1", "value1"));
        KeyValueStorage keyValueStorage = new FileKV("src/test/resources/file", mapTest);
        assertThat(mapTest).isEqualTo(keyValueStorage.toMap());

    }
    // END
}
