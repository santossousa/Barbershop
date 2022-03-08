package br.fabiosantos.barbershop.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(exclude = { "customer" })
public class Reservation {

	private final Customer customer;
	private final LocalDate date;
	private final DayOfWeek dayOfWeek;
	private final LocalTime time;

	public Reservation(Customer customer, LocalDate date, DayOfWeek dayOfWeek, LocalTime time) {
		super();
		this.customer = customer;
		this.date = date;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
	}

	public static Reservation of(Customer customer, LocalDate date, DayOfWeek dayOfWeek, LocalTime time) {
		return new Reservation(customer, date, dayOfWeek, time);
	}

	public LocalDate getDate() {
		return date;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public LocalTime getTime() {
		return time;
	}

	public Customer getCustomer() {
		return customer;
	}
}
