package com.littlesekii.incentivo.config;

import com.littlesekii.incentivo.modules.order.entity.Order;
import com.littlesekii.incentivo.modules.order.entity.OrderStatus;
import com.littlesekii.incentivo.modules.order.repository.OrderRepository;
import com.littlesekii.incentivo.modules.user.entity.User;
import com.littlesekii.incentivo.modules.user.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public TestConfig(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<User> users = List.of(
                new User(null, "Davi Bacalhau", "littlesekii@gmail.com", "(21) 94002-8922", "uvekp23465"),
                new User(null, "Flávia Helena", "flavinhahele@gmail.com", "(43) 94002-8922", "uvekp23564")
        );
        userRepository.saveAll(users);

        System.out.println("Usuários adicionados:");
        users.forEach((user -> System.out.println(user.getId() + " - " + user.getName())));

        List<Order> orders = List.of(
                new Order(null, Instant.parse("2024-01-01T00:00:00Z"), users.get(0), OrderStatus.WAITING_PAYMENT),
                new Order(null, Instant.parse("2024-01-02T01:00:59Z"), users.get(1), OrderStatus.PAID),
                new Order(null, Instant.parse("2024-05-19T13:34:43Z"), users.get(1), OrderStatus.DELIVERED)
        );

        orderRepository.saveAll(orders);

        System.out.println("Pedidos adicionados:");
        orders.forEach(
            (order ->
                System.out.println(
                    order.getId() + " - " +
                    order.getClient().getName() +
                    " às " + order.getMoment()
                )
            )
        );

    }
}
