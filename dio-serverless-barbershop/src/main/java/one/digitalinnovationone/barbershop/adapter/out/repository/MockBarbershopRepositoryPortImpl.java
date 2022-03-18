package one.digitalinnovationone.barbershop.adapter.out.repository;


import java.util.Optional;

import br.fabiosantos.barbershop.domain.Barbershop;
import br.fabiosantos.barbershop.ports.out.BarbershopRepositoryPort;

public class MockBarbershopRepositoryPortImpl implements BarbershopRepositoryPort {

    @Override
    public Optional<Barbershop> load(String barbershopName) {
//        return Optional.of(BarbershopUtils.createBarbershop());
        return Optional.empty();
    }

    @Override
    public Barbershop save(Barbershop barbershop) {
        return MockBarbershopUtils.createBarbershop();
    }
}
