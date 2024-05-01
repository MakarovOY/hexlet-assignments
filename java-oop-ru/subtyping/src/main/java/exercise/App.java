package exercise;
import java.io.IOException;import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Map;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
   public static void swapKeyValue(KeyValueStorage keyValueStorageToSwap) {
        keyValueStorageToSwap.toMap().forEach((k,v)->{
            try {
                keyValueStorageToSwap.unset(k);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            keyValueStorageToSwap.set(v, k);
        });
    }
}
// END
