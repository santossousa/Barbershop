package br.fabiosantos.barbershop.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;


public class CustomerTest {

    @Test
    void whenCustomerPropertiesAreGivenThenItShouldBeCreated() {
        var expectedName = "Rodrigo Peleias";
        var expectedEmail = "rodrigo@email.com";
        var expectedPhone = "(11)99991-1234";

        var customer = Customer.of(expectedName, expectedEmail, expectedPhone);

        assertThat(customer.getName(), equalTo(expectedName));
        assertThat(customer.getEmail(), equalTo(expectedEmail));
        assertThat(customer.getPhone(), equalTo(expectedPhone));
    }
}
