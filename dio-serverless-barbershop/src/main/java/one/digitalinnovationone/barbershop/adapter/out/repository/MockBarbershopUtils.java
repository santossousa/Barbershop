package one.digitalinnovationone.barbershop.adapter.out.repository;


import static one.digitalinnovationone.barbershop.adapter.out.repository.MockAvailabilityUtils.createAvailability;

import br.fabiosantos.barbershop.domain.Barbershop;


public class MockBarbershopUtils {

    public static Barbershop createBarbershop() {
        var expectedName = "Fabio";
        var expectedAddress = "Zona rural";
        var expectedCity = "Tamboril";

        var barbershop = new Barbershop.Builder(expectedName)
                .address(expectedAddress)
                .city(expectedCity)
                .availability(createAvailability())
                .build();
        return barbershop;
    }
}
