package br.fabiosantos.barbershop.utils;
import static br.fabiosantos.barbershop.utils.AvailabilityUtils.createAvailability;
import br.fabiosantos.barbershop.domain.Barbershop;

public class BarbershopUtils {

    public static Barbershop createBarbershop() {
        var expectedName = "Barbearia do Rodrigo";
        var expectedAddress = "Avenida Paulista 201";
        var expectedCity = "São Paulo";

        var barbershop = new Barbershop.Builder(expectedName)
                .address(expectedAddress)
                .city(expectedCity)
                .availability(createAvailability())
                .build();
        return barbershop;
    }
}

