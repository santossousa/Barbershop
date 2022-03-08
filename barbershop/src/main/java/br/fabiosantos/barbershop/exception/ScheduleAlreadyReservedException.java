package br.fabiosantos.barbershop.exception;

import br.fabiosantos.barbershop.domain.Customer;

public class ScheduleAlreadyReservedException  extends BusinessException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7323831263391322063L;

	public ScheduleAlreadyReservedException(Customer customer) {
        super(String.format("Schedule informed by customer %s is already registered", customer), 400);
    }
}
