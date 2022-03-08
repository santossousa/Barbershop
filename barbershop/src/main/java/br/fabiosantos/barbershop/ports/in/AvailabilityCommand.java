package br.fabiosantos.barbershop.ports.in;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

import br.fabiosantos.barbershop.shared.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AvailabilityCommand extends SelfValidating<AvailabilityCommand> {

    @NotNull
    private final List<DayOfWeek> daysOfWeek;

    @NotNull
    private final LocalTime openTime;

    @NotNull
    private final LocalTime closeTime;

    @NotNull
    private final LocalTime duration;

    public AvailabilityCommand(List<DayOfWeek> daysOfWeek, LocalTime openTime, LocalTime closeTime, LocalTime duration) {
        this.daysOfWeek = daysOfWeek;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.duration = duration;
        this.validateSelf();
    }

	public List<DayOfWeek> getDaysOfWeek() {
		return daysOfWeek;
	}

	public LocalTime getOpenTime() {
		return openTime;
	}

	public LocalTime getCloseTime() {
		return closeTime;
	}

	public LocalTime getDuration() {
		return duration;
	}
    
}
