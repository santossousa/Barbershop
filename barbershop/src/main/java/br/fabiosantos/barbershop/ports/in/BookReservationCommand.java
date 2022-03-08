package br.fabiosantos.barbershop.ports.in;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import br.fabiosantos.barbershop.shared.SelfValidating;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class BookReservationCommand extends SelfValidating<BookReservationCommand> {

    @NotNull
    @NotEmpty
    private final String barbershopName;

    @NotNull
    private final LocalDate date;

    @NotNull
    private final DayOfWeek dayOfWeek;

    @NotNull
    private final LocalTime time;

    @NotNull
    private final CustomerCommand customerCommand;

    public BookReservationCommand(
            String barbershopName,
            LocalDate date,
            DayOfWeek dayOfWeek,
            LocalTime time,
            CustomerCommand customerCommand) {

        this.barbershopName = barbershopName;
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.time = time;
        this.customerCommand = customerCommand;
        
        this.validateSelf();
    }

	public String getBarbershopName() {
		return barbershopName;
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

	public CustomerCommand getCustomerCommand() {
		return customerCommand;
	}
    
}
