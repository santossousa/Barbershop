package br.fabiosantos.barbershop.ports.out;

import br.fabiosantos.barbershop.domain.Barbershop;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreatedBarbershop {

    private final String name;
    private final String address;
    private final String city;
    

    public CreatedBarbershop(String name, String address, String city) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
	}

	public static CreatedBarbershop of(Barbershop barbershop) {
        return new CreatedBarbershop(barbershop.getName(),
                barbershop.getAddress(),
                barbershop.getCity());
    }

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}
    
}
