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

	private Reservation(Customer customer, LocalDate date, DayOfWeek dayOfWeek, LocalTime time) {
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
	public Reservation(Builder builder) {
		this.customer = builder.customer;
		this.date = builder.date;
		this.dayOfWeek = builder.dayOfWeek;
		this.time = builder.time;
		
	}

	public static class Builder {
		private Customer customer;
		private LocalDate date;
		private DayOfWeek dayOfWeek;
		private LocalTime time;
		public Builder(Customer customer) {
			this.customer = customer;
		}

		public Builder customer(Customer customer) {
			this.customer = customer;
			return this;
		}

		public Builder date(LocalDate date) {
			this.date = date;
			return this;
		}

		public Builder dayOfWeek(DayOfWeek dayOfWeek) {
			this.dayOfWeek = dayOfWeek;
			return this;
		}

		public Builder time(LocalTime time) {
			this.time = time;
			return this;
		}

		public Reservation build() {
			return new Reservation(this);
		}

	}

}
