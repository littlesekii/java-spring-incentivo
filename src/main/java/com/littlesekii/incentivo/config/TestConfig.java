package com.littlesekii.incentivo.config;

import com.littlesekii.incentivo.modules.category.entity.Category;
import com.littlesekii.incentivo.modules.category.repository.CategoryRepository;
import com.littlesekii.incentivo.modules.order.entity.Order;
import com.littlesekii.incentivo.modules.order.entity.OrderStatus;
import com.littlesekii.incentivo.modules.order.repository.OrderRepository;
import com.littlesekii.incentivo.modules.order_item.entity.OrderItem;
import com.littlesekii.incentivo.modules.order_item.repository.OrderItemRepository;
import com.littlesekii.incentivo.modules.product.entity.Product;
import com.littlesekii.incentivo.modules.product.repository.ProductRepository;
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
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    private final OrderItemRepository orderItemRepository;

    public TestConfig(
            UserRepository userRepository,
            OrderRepository orderRepository,
            CategoryRepository categoryRepository,
            ProductRepository productRepository,
            OrderItemRepository orderItemRepository
    ) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Category> categories = List.of(
                new Category(null, "Electronics"),
                new Category(null, "Books"),
                new Category(null, "Computers")
        );

        categoryRepository.saveAll(categories);

        System.out.println("Categorias adicionadas:");
        categories.forEach((category -> System.out.println(category.getId() + " - " + category.getName())));

        List<Product> products = List.of(
                new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""),
                new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""),
                new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""),
                new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""),
                new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "")
        );

        productRepository.saveAll(products);

        System.out.println("Produtos adicionados:");
        products.forEach((product -> System.out.println(product.getId() + " - " + product.getName())));

        products.get(0).getCategories().add(categories.get(1));
        products.get(1).getCategories().add(categories.get(0));
        products.get(2).getCategories().add(categories.get(0));
        products.get(2).getCategories().add(categories.get(2));
        products.get(3).getCategories().add(categories.get(0));
        products.get(3).getCategories().add(categories.get(2));
        products.get(4).getCategories().add(categories.get(1));

        System.out.println("Categoria dos produtos adicionados:");
        products.forEach(
            product -> {
                System.out.println(product.getId() + " - " + product.getName() + ": ");
                product.getCategories().forEach(
                    category -> System.out.println("\t" + category.getName())
                );
            }
        );

        productRepository.saveAll(products);

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

        List<OrderItem> orderItems = List.of(
                new OrderItem(orders.get(0), products.get(0), 2, products.get(0).getPrice()),
                new OrderItem(orders.get(0), products.get(2), 1, products.get(2).getPrice()),
                new OrderItem(orders.get(1), products.get(2), 2, products.get(2).getPrice()),
                new OrderItem(orders.get(2), products.get(4), 2, products.get(4).getPrice())
        );

        orderItemRepository.saveAll(orderItems);

        System.out.println("Itens de pedidos adicionados:");
        orderItems.forEach(
            orderItem -> {
                System.out.println(
                    orderItem.getOrder().getId() + " - " +
                    orderItem.getOrder().getClient().getName() + ": "
                );
                System.out.println(
                        "\t" + orderItem.getProduct().getName() + " - " +
                        orderItem.getQuantity() + " itens, R$" + orderItem.getPrice() +
                        "(R$" + orderItem.getQuantity() * orderItem.getPrice() + ")"
                );
            }
        );

    }
}
