package no.ntnu.edvardsem.hikingtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Business logic related to orders
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Returns all orders stored in the application state
     * @return all orders
     */
    public List<Order> getOrders() {
        List<Order> orders = new LinkedList<>();
        this.orderRepository.findAll().forEach(orders::add);
        return orders;
    }

    /**
     * Adds an order to the application state
     * @param customerId the id of the customer who placed the order
     * @param productIds a list of products ids for all the products
     *                    that are a part of the order
     * @return {@code true} if order was successfully added, {@code false}
     * otherwise
     */
    public boolean addOrder(int customerId, List<Integer> productIds) {
        boolean added = false;
        Customer customer = this.findCustomerById(customerId);
        if (customer != null) {
            Order order = new Order(customer, "pending");
            Set<Product> products = this.findProductsById(productIds);
            for (Product product : products) {
                order.addProduct(product);
            }
            this.orderRepository.save(order);
            added = true;
        }
        return added;
    }

    /**
     * Finds a customer from the application state by their ids
     * @param customerId the id of the customer
     * @return customer found, or null if no customer was found
     */
    private Customer findCustomerById(int customerId) {
        Customer customer = null;
        Optional<Customer> result = this.customerRepository.findById(customerId);
        if (result.isPresent()) {
            customer = result.get();
        }
        return customer;
    }

    /**
     * Created a list of products from a list of products ids.
     * @param productIds list of product ids
     * @return a list of products
     */
    private Set<Product> findProductsById(List<Integer> productIds) {
        Set<Product> products = new HashSet<>();
        for (int productId : productIds) {
            Optional<Product> result = this.productRepository.findById(productId);
            result.ifPresent(products::add);
        }
        return products;
    }
}
