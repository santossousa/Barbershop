package br.fabiosantos.barbershop.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;


public class CustomerTest {

    @Test
    void whenCustomerPropertiesAreGivenThenItShouldBeCreated() {
        var expectedName = "Fabio";
        var expectedEmail = "fabio@email.com";
        var expectedPhone = "(88)99999-9999";

        var customer = Customer.of(expectedName, expectedEmail, expectedPhone);

        assertThat(customer.getName(), equalTo(expectedName));
        assertThat(customer.getEmail(), equalTo(expectedEmail));
        assertThat(customer.getPhone(), equalTo(expectedPhone));
    }
}
