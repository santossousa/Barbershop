package br.fabiosantos.barbershop.ports.in;


import br.fabiosantos.barbershop.ports.out.BarbershopRepositoryPort;
import br.fabiosantos.barbershop.ports.out.CreatedBarbershop;
import br.fabiosantos.barbershop.service.CreateBarbershopService;

public interface CreateBarbershopUseCase {
	CreatedBarbershop create(CreateBarbershopCommand createBarbershopCommand);

	public static CreateBarbershopUseCase getInstance(BarbershopRepositoryPort barbershopRepositoryPortImpl) {
        return new CreateBarbershopService(barbershopRepositoryPortImpl);
    }
}
