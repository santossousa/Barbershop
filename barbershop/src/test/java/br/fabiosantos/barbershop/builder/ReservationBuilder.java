package br.fabiosantos.barbershop.builder;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import br.fabiosantos.barbershop.domain.Customer;
import br.fabiosantos.barbershop.domain.Reservation;
import lombok.Builder;

public class ReservationBuilder {
	@Builder.Default
    private final Customer customer = Customer.of("Rodrigo Peleias", "teste@email.com", "(11)99999-9999");

    @Builder.Default
    private final LocalDate date = LocalDate.of(2020, 1, 20);

    @Builder.Default
    private final DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;

    @Builder.Default
    private LocalTime time = LocalTime.of(10, 0);

    public static ReservationBuilder builder() {
        return new ReservationBuilder();
    }

    @Builder
    public ReservationBuilder time(LocalTime time) {
        this.time = time;
        return this;
    }

    public Reservation build() {
        return Reservation.of(customer, date, dayOfWeek, time);
    }
}

