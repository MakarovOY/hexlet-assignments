package exercise;
import java.io.IOException;



// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage keyValueStorageToSwap) {
        keyValueStorageToSwap.toMap().forEach((k, v) -> {
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
