package br.fabiosantos.barbershop.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;


public class ReservationTest {

    @Test
    void whenReservationIsGivenThenItShouldBeCreated() {
        var expectedDate = LocalDate.of(2022, 1, 12);
        var expectedDayOfWeek = DayOfWeek.FRIDAY;
        var expectedTime = LocalTime.of(10, 0);
        var reservation = Reservation.of(this.createCustomer(), expectedDate, expectedDayOfWeek, expectedTime);

        assertThat(reservation.getCustomer().getName(), equalTo(this.createCustomer().getName()));
        assertThat(reservation.getDayOfWeek(), equalTo(expectedDayOfWeek));
        assertThat(reservation.getTime(), equalTo(expectedTime));
        assertThat(reservation.getDate(), equalTo(expectedDate));

    }

    private Customer createCustomer() {
        var expectedName = "fabio";
        var expectedEmail = "fabio@email.com";
        var expectedPhone = "(88)9999-9999";

        return Customer.of(expectedName, expectedEmail, expectedPhone);
    }
}
