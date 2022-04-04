package no.ntnu.databaseRelations;

import no.ntnu.databaseRelations.role.Role;
import no.ntnu.databaseRelations.role.RoleRepository;
import no.ntnu.databaseRelations.user.User;
import no.ntnu.databaseRelations.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DummyDataInitializer implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (isInitialized()) {
            System.out.println("Data already exists! Not importing again...");
            return;
        }
        System.out.println("Importing data...");

        Role admin = new Role("ADMIN");
        Role user = new Role("USER");
        roleRepository.save(admin);
        roleRepository.save(user);

        User adam = new User("Adam Jensen");
        User karl = new User("Karl");

        adam.addRole(admin);
        adam.addRole(user);
        karl.addRole(user);

        userRepository.save(adam);
        userRepository.save(karl);

        System.out.println("Finished importing data!");
    }

    private boolean isInitialized() {
        return this.userRepository.count() > 0;
    }
}
