package one.digitalinnovationone.barbershop.repository.adapters.in;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import br.fabiosantos.barbershop.domain.Barbershop;
import br.fabiosantos.barbershop.domain.Reservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamoDBTable(tableName = "Barbershop")
@ToString
public class BarbershopDB {

	@DynamoDBHashKey(attributeName = "Name")
	private String name;

	@DynamoDBAttribute(attributeName = "Address")
	private String address;

	@DynamoDBAttribute(attributeName = "City")
	private String city;

	@DynamoDBAttribute(attributeName = "Availability")
	private AvailabilityDB availability;

	@DynamoDBAttribute(attributeName = "Reservations")
	private List<ReservationDB> reservations;
	

	private BarbershopDB(String name, String address, String city, AvailabilityDB availability,
			List<ReservationDB> reservations) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.availability = availability;
		this.reservations = reservations;
	}

	public static BarbershopDB from(Barbershop barbershop) {
		List<ReservationDB> reservations = barbershop.getReservations().stream().map(ReservationDB::from)
				.collect(Collectors.toList());

		return BarbershopDB.builder().name(barbershop.getName()).address(barbershop.getAddress())
				.city(barbershop.getCity()).availability(AvailabilityDB.from(barbershop.getAvailability()))
				.reservations(reservations).build();
	}

	public static Barbershop to(BarbershopDB barbershopDB) {
		List<Reservation> reservations = barbershopDB.getReservations().stream().map(ReservationDB::to)
				.collect(Collectors.toList());

		return new Barbershop.Builder(barbershopDB.getName()).address(barbershopDB.getAddress())
				.city(barbershopDB.getCity()).availability(AvailabilityDB.to(barbershopDB.getAvailability()))
				.reservations(reservations).build();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAvailability(AvailabilityDB availability) {
		this.availability = availability;
	}

	public void setReservations(List<ReservationDB> reservations) {
		this.reservations = reservations;
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

	public AvailabilityDB getAvailability() {
		return availability;
	}

	public List<ReservationDB> getReservations() {
		return reservations;
	}
	public static class Builder{
		@DynamoDBHashKey(attributeName = "Name")
		private String name;

		@DynamoDBAttribute(attributeName = "Address")
		private String address;

		@DynamoDBAttribute(attributeName = "City")
		private String city;

		@DynamoDBAttribute(attributeName = "Availability")
		private AvailabilityDB availability;

		@DynamoDBAttribute(attributeName = "Reservations")
		private List<ReservationDB> reservations;
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
		public Builder availability(AvailabilityDB availability) {
			this.availability = availability;
			return this;
		}
		public Builder reservations(List<ReservationDB> reservations) {
			this.reservations = reservations;
			return this;
		}
		public BarbershopDB build() {
			return new BarbershopDB(name, address, city, availability, reservations);
		}
		
	}
	public static Builder builder() {
		return new Builder();
	}
	

}
