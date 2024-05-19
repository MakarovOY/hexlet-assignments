package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path path, Car car) throws Exception {
        Files.write(path, car.serialize().getBytes()) ;
    }

    public static Car extract(Path path) throws Exception {
        String content = Files.readString(path);
        return Car.unserialize(content);
    }
}    
// END
