package one.digitalinnovationone.barbershop.repository.adapters.in;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;

import br.fabiosantos.barbershop.domain.Availability;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovationone.barbershop.repository.adapters.converter.LocalTimeConverter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class AvailabilityDB {

	private AvailabilityDB(List<String> daysOfWeek, LocalTime openTime, LocalTime closeTime, LocalTime duration) {

		this.daysOfWeek = daysOfWeek;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.duration = duration;
	}

	@DynamoDBAttribute(attributeName = "daysOfWeek")
	private List<String> daysOfWeek;

	@DynamoDBAttribute(attributeName = "OpenTime")

	@DynamoDBTypeConverted(converter = LocalTimeConverter.class)
	private LocalTime openTime;

	@DynamoDBAttribute(attributeName = "CloseTime")

	@DynamoDBTypeConverted(converter = LocalTimeConverter.class)
	private LocalTime closeTime;

	@DynamoDBAttribute(attributeName = "Duration")
	@DynamoDBTypeConverted(converter = LocalTimeConverter.class)
	private LocalTime duration;

	public static AvailabilityDB from(Availability availability) {
		List<String> daysOfWeek = availability.getDaysOfWeek().stream().map(DayOfWeek::name)
				.collect(Collectors.toList());

		return AvailabilityDB.builder().daysOfWeek(daysOfWeek).openTime(availability.getOpenTime())
				.closeTime(availability.getCloseTime()).duration(availability.getDuration()).build();
	}

	public static Availability to(AvailabilityDB availability) {
		List<DayOfWeek> daysOfWeek = availability.getDaysOfWeek().stream().map(DayOfWeek::valueOf)
				.collect(Collectors.toList());

		return Availability.builder().daysOfWeek(daysOfWeek).openTime(availability.getOpenTime())
				.closeTime(availability.getCloseTime()).duration(availability.getDuration()).build();
	}

	public List<String> getDaysOfWeek() {
		return daysOfWeek;
	}

	public void setDaysOfWeek(List<String> daysOfWeek) {
		this.daysOfWeek = daysOfWeek;
	}

	public LocalTime getOpenTime() {
		return openTime;
	}

	public void setOpenTime(LocalTime openTime) {
		this.openTime = openTime;
	}

	public LocalTime getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(LocalTime closeTime) {
		this.closeTime = closeTime;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}

	static class Builder {
		@DynamoDBAttribute(attributeName = "daysOfWeek")
		private List<String> daysOfWeek;

		@DynamoDBAttribute(attributeName = "OpenTime")

		@DynamoDBTypeConverted(converter = LocalTimeConverter.class)
		private LocalTime openTime;

		@DynamoDBAttribute(attributeName = "CloseTime")

		@DynamoDBTypeConverted(converter = LocalTimeConverter.class)
		private LocalTime closeTime;

		@DynamoDBAttribute(attributeName = "Duration")

		@DynamoDBTypeConverted(converter = LocalTimeConverter.class)
		private LocalTime duration;

		public Builder daysOfWeek(List<String> daysOfWeek) {
			this.daysOfWeek = daysOfWeek;
			return this;
		}

		public Builder openTime(LocalTime openTime) {
			this.openTime = openTime;
			return this;
		}

		public Builder closeTime(LocalTime closeTime) {
			this.closeTime = closeTime;
			return this;
		}

		public Builder duration(LocalTime duration) {
			this.duration = duration;
			return this;
		}

		public AvailabilityDB build() {
			return new AvailabilityDB(daysOfWeek,openTime,closeTime,duration);
		}

	}

	public static Builder builder() {

		return new Builder();
	}

}
