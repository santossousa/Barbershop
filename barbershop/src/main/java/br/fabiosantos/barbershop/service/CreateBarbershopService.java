package br.fabiosantos.barbershop.service;

import br.fabiosantos.barbershop.domain.Availability;
import br.fabiosantos.barbershop.domain.Barbershop;
import br.fabiosantos.barbershop.exception.BarbershopAlreadyRegisteredException;
import br.fabiosantos.barbershop.ports.in.AvailabilityCommand;
import br.fabiosantos.barbershop.ports.in.CreateBarbershopCommand;
import br.fabiosantos.barbershop.ports.in.CreateBarbershopUseCase;
import br.fabiosantos.barbershop.ports.out.BarbershopRepositoryPort;
import br.fabiosantos.barbershop.ports.out.CreatedBarbershop;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateBarbershopService implements CreateBarbershopUseCase {

    private BarbershopRepositoryPort barbershopRepositoryPort;
    public CreateBarbershopService(BarbershopRepositoryPort barbershopRepositoryPort) {
    	this.barbershopRepositoryPort = barbershopRepositoryPort;
    }

    @Override
    public CreatedBarbershop create(CreateBarbershopCommand command) {
        barbershopRepositoryPort.load(command.getName())
                .ifPresent(barbershop -> { throw new BarbershopAlreadyRegisteredException(barbershop.getName());} );

        Availability availability = createAvailability(command);
        Barbershop barbershop = createBarberhop(command, availability);

        Barbershop savedBarbershop = barbershopRepositoryPort.save(barbershop);

        return CreatedBarbershop.of(savedBarbershop);
    }

    private Availability createAvailability(CreateBarbershopCommand command) {
        AvailabilityCommand availabilityCommand = command.getAvailabilityCommand();

        Availability availability = Availability.of(availabilityCommand.getDaysOfWeek(),
                availabilityCommand.getOpenTime(),
                availabilityCommand.getCloseTime(),
                availabilityCommand.getDuration());
        return availability;
    }

    private Barbershop createBarberhop(CreateBarbershopCommand command, Availability availability) {
        return new Barbershop.Builder(command.getName())
                .address(command.getAddress())
                .city(command.getCity())
                .availability(availability)
                .build();
    }
}
