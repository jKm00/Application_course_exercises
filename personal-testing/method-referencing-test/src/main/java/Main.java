import User.User;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Joakim", "Eduard"};
        ArrayList<User> users = new ArrayList();

        Arrays.stream(names).forEach(name -> users.add(new User(name)));
        // Though this would work
        //Arrays.stream(names).forEach(users.add(User::new));
    }
}
