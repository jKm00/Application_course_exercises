package no.ntnu.edvardsem.hikingtest;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int customerId;
    private String firstname;
    private String lastname;
}
