package br.fabiosantos.barbershop.domain;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.fabiosantos.barbershop.exception.ScheduleAlreadyReservedException;
import br.fabiosantos.barbershop.exception.TimeNotAvailableException;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Barbershop {
	private final String name;
	private final String address;
	private final String city;
	private final Availability availability;
	public Barbershop(Builder build) {
		super();
		this.name = build.name;
		this.address = build.address;
		this.city = build.city;
		this.availability = build.availability;
	}
	

	private final List<Reservation> reservations = new ArrayList<Reservation>();

	public void add(Reservation reservation) {
		verifyIfTimeIsAlreadyScheduled(reservation);
		verifyIfTimeInformedIsValid(reservation);
		this.reservations.add(reservation);
	}

	private void verifyIfTimeIsAlreadyScheduled(Reservation reservation) {
		if (this.reservations.contains(reservation)) {
			throw new ScheduleAlreadyReservedException(reservation.getCustomer());
		}
	}

	private void verifyIfTimeInformedIsValid(Reservation reservation) {
		LocalTime openTime = availability.getOpenTime();
		LocalTime closeTime = availability.getCloseTime();

		LocalTime informedReservationTime = reservation.getTime();
		if (informedReservationTime.isBefore(openTime) || informedReservationTime.isAfter(closeTime)) {
			throw new TimeNotAvailableException(informedReservationTime);
		}
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public Availability getAvailability() {
		return availability;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public static class Builder {
		private String name;
		private String address;
		private String city;
		private Availability availability;
		public Builder(String name) {
			this.name = name;
		}
		public Builder name(String name) {
			this.name = name;
			return this;

		}

		public Builder address(String address) {
			this.address = address;
			return this;

		}

		public Builder city(String city) {
			this.city = city;
			return this;

		}

		public Builder availability(Availability availability) {
			this.availability = availability;
			return this;

		}

		public Barbershop build() {
			return new Barbershop(this);
		}

	}

}