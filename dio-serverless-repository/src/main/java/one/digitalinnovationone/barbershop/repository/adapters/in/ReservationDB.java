package one.digitalinnovationone.barbershop.repository.adapters.in;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

import br.fabiosantos.barbershop.domain.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovationone.barbershop.repository.adapters.converter.LocalDateConverter;
import one.digitalinnovationone.barbershop.repository.adapters.converter.LocalTimeConverter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class ReservationDB {
	
	

	private ReservationDB(CustomerDB customer, LocalDate date, String dayOfWeek, LocalTime time) {
		super();
		this.customer = customer;
		this.date = date;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
	}

	@DynamoDBAttribute(attributeName = "Customer")
	private CustomerDB customer;

	@DynamoDBTypeConverted(converter = LocalDateConverter.class)

	@DynamoDBAttribute(attributeName = "Date")
	private LocalDate date;

	@DynamoDBAttribute(attributeName = "DayOfWeek")
	private String dayOfWeek;

	@DynamoDBTypeConverted(converter = LocalTimeConverter.class)

	@DynamoDBAttribute(attributeName = "Time")
	private LocalTime time;

	public static ReservationDB from(Reservation reservation) {
		return ReservationDB.builder().customer(CustomerDB.from(reservation.getCustomer()))
				.dayOfWeek(reservation.getDayOfWeek().name()).time(reservation.getTime()).build();
	}

	public static Reservation to(ReservationDB reservationDB) {
		return new Reservation.Builder(CustomerDB.to(reservationDB.getCustomer()))
				.dayOfWeek(DayOfWeek.valueOf(reservationDB.getDayOfWeek())).time(reservationDB.getTime()).build();
	}

	public CustomerDB getCustomer() {
		return customer;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public LocalTime getTime() {
		return time;
	}
	
	public static class Builder{
		@DynamoDBAttribute(attributeName = "Customer")
		private CustomerDB customer;

		@DynamoDBTypeConverted(converter = LocalDateConverter.class)

		@DynamoDBAttribute(attributeName = "Date")
		private LocalDate date;

		@DynamoDBAttribute(attributeName = "DayOfWeek")
		private String dayOfWeek;

		@DynamoDBTypeConverted(converter = LocalTimeConverter.class)

		@DynamoDBAttribute(attributeName = "Time")
		private LocalTime time;
		
		public Builder customer(CustomerDB customer) {
			this.customer = customer;
			return this;
		}
		public Builder date(LocalDate date) {
			this.date = date;
			return this;
		}
		public Builder dayOfWeek(String dayOfWeek) {
			this.dayOfWeek = dayOfWeek;
			return this;
		}
		public Builder time(LocalTime time) {
			this.time = time;
			return this;
		}
		public ReservationDB build() {
			return new ReservationDB(customer, date, dayOfWeek, time);
		}
	}
	public static Builder builder() {
		return new Builder();
	}

}
