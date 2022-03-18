package br.fabiosantos.barbershop.domain;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class Availability {
	private final List<DayOfWeek> daysOfWeek;
	private LocalTime openTime = LocalTime.of(8, 0);

	private LocalTime closeTime = LocalTime.of(19, 0);;
	private final LocalTime duration;

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

	private Availability(List<DayOfWeek> daysOfWeek, LocalTime openTime, LocalTime closeTime, LocalTime duration) {
		this.daysOfWeek = daysOfWeek;
		validateAndInitialize(openTime, closeTime);
		this.duration = duration;
	}

	public static Availability of(List<DayOfWeek> daysOfWeek, LocalTime openTime, LocalTime closeTime,
			LocalTime duration) {
		return new Availability(daysOfWeek, openTime, closeTime, duration);
	}

	public void validateAndInitialize(LocalTime openTime, LocalTime closeTime) {
		this.openTime = openTime;
		if (closeTime.isBefore(this.openTime)) {
			throw new IllegalArgumentException("Close time must be greter than open time");
		}
		this.closeTime = closeTime;
	}

	public int dailyAvailableTime() {
		return (closeTime.getHour() - openTime.getHour()) / duration.getHour();
	}

	public List<DayOfWeek> getDaysOfWeek() {
		return daysOfWeek;
	}

	public static class Builder {
		private List<DayOfWeek> daysOfWeek;
		private LocalTime openTime;
		private LocalTime closeTime;
		private LocalTime duration;

		public Builder daysOfWeek(List<DayOfWeek> daysOfWeek) {
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

		public Availability build() {
			return new Availability(daysOfWeek, openTime, closeTime, duration);
		}

	}

	public static Builder builder() {
		return new Builder();
	}
}
