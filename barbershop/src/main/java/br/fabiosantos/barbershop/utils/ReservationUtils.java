package br.fabiosantos.barbershop.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import br.fabiosantos.barbershop.domain.Customer;
import br.fabiosantos.barbershop.domain.Reservation;

public class ReservationUtils {

		public static final Customer customer = Customer.of("Fabio", "teste@email.com", "(88)99999-9999");

		public static final LocalDate date = LocalDate.of(2022, 1, 20);

		public static final DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;

		public static final LocalTime time = LocalTime.of(10, 0);
		
		
	

}
