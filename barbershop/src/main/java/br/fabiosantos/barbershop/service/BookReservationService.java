package br.fabiosantos.barbershop.service;

import br.fabiosantos.barbershop.domain.Barbershop;
import br.fabiosantos.barbershop.domain.Customer;
import br.fabiosantos.barbershop.domain.Reservation;
import br.fabiosantos.barbershop.exception.BarbershopNotFoundException;
import br.fabiosantos.barbershop.ports.in.BookReservationCommand;
import br.fabiosantos.barbershop.ports.in.BookReservationUseCase;
import br.fabiosantos.barbershop.ports.in.CustomerCommand;
import br.fabiosantos.barbershop.ports.out.BarbershopRepositoryPort;
import br.fabiosantos.barbershop.ports.out.BookedReservation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookReservationService implements BookReservationUseCase {

    private final BarbershopRepositoryPort barbershopRepositoryPort;

    public BookReservationService(BarbershopRepositoryPort barbershopRepositoryPort2) {
    	barbershopRepositoryPort = barbershopRepositoryPort2;
		// TODO Auto-generated constructor stub
	}

	@Override
    public BookedReservation book(BookReservationCommand command) {
        Barbershop barbershop = barbershopRepositoryPort.load(command.getBarbershopName())
                .orElseThrow(() -> new BarbershopNotFoundException(command.getBarbershopName()));

        CustomerCommand customerCommand = command.getCustomerCommand();
        Customer customer = create(customerCommand);
        Reservation reservation = create(command, customer);

        barbershop.add(reservation);
        barbershopRepositoryPort.save(barbershop);

        return BookedReservation.of(barbershop.getName(), reservation.getDate(),
                reservation.getDayOfWeek(), reservation.getTime(),
                customer.getName());
    }

    private Customer create(CustomerCommand customerCommand) {
        return Customer.of(customerCommand.getName(),
                customerCommand.getEmail(),
                customerCommand.getPhone());
    }

    private Reservation create(BookReservationCommand command, Customer customer) {
        return Reservation.of(customer,
                command.getDate(),
                command.getDayOfWeek(),
                command.getTime());
    }
}
