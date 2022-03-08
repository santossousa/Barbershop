package br.fabiosantos.barbershop.ports.out;

import java.util.Optional;

import br.fabiosantos.barbershop.domain.Barbershop;


public interface BarbershopRepositoryPort {
	Optional<Barbershop> load(String barbershopName);

    Barbershop save(Barbershop barbershop);

}
