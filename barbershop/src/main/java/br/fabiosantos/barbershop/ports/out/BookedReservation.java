package br.fabiosantos.barbershop.ports.out;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookedReservation {

    private final String barbershopName;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private final LocalDate date;

    private final DayOfWeek dayOfWeek;

    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonFormat(pattern = "HH:mm")
    private final LocalTime time;

    private final String customerName;

    public static BookedReservation of(String barbershopName, LocalDate date,
                                       DayOfWeek dayOfWeek, LocalTime time, String customerName) {
        return new BookedReservation(barbershopName, date, dayOfWeek, time, customerName);
    }

	public BookedReservation(String barbershopName, LocalDate date, DayOfWeek dayOfWeek, LocalTime time,
			String customerName) {
		super();
		this.barbershopName = barbershopName;
		this.date = date;
		this.dayOfWeek = dayOfWeek;
		this.time = time;
		this.customerName = customerName;
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

	public String getCustomerName() {
		return customerName;
	}
    

}
