package br.fabiosantos.barbershop.exception;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class TimeNotAvailableException extends BusinessException  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6818715821397640410L;

	public TimeNotAvailableException(LocalTime time) {
        super(String.format("The following time is not available for booking: %s", time.format(DateTimeFormatter.ofPattern("hh:mm"))), 400);
    }

}
