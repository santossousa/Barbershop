package br.fabiosantos.barbershop.ports.in;

import br.fabiosantos.barbershop.ports.out.BarbershopRepositoryPort;
import br.fabiosantos.barbershop.ports.out.BookedReservation;
import br.fabiosantos.barbershop.service.BookReservationService;

public interface BookReservationUseCase {
	BookedReservation book(BookReservationCommand bookReservationCommand);

    public static BookReservationUseCase getInstance(BarbershopRepositoryPort barbershopRepositoryPort) {
        return new BookReservationService(barbershopRepositoryPort);
    }
}
