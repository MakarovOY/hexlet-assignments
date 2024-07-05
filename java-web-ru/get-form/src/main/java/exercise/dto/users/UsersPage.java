package exercise.dto.users;

import exercise.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
public class UsersPage {
    private List<User> users;
    String term;
}
// END
