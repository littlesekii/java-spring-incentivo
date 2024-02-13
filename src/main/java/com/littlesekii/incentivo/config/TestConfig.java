package com.littlesekii.incentivo.config;

import com.littlesekii.incentivo.modules.user.entity.User;
import com.littlesekii.incentivo.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;

    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> users = List.of(
                new User(1L, "Davi Bacalhau", "littlesekii@gmail.com", "(21) 94002-8922", "uvekp23465"),
                new User(2L, "Flávia Helena", "flavinhahele@gmail.com", "(43) 94002-8922", "uvekp23564")
        );
        userRepository.saveAll(users);

        System.out.println("Usuários adicionados:");
        users.forEach((user -> System.out.println(user.getId() + " - " + user.getName())));
    }
}
