package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static void main(String[] args) {


    }
    public  static List buildApartmentsList(List<Home> homes, int countOfFirstElements){



       List<Home> homesToSort= new ArrayList<>(homes);
       Collections.sort(homesToSort);
       List<String> resultList = new ArrayList<>();
        homesToSort.subList(0,countOfFirstElements).forEach(e-> resultList.add(e.toString()));

        return resultList;

    }
// END
