package br.fabiosantos.barbershop.ports.in;


import br.fabiosantos.barbershop.shared.SelfValidating;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CreateBarbershopCommand extends SelfValidating<CreateBarbershopCommand> {

    @NotNull
    private final String name;

    @NotNull
    private final String address;

    @NotNull
    private final String city;

    @NotNull
    private final AvailabilityCommand availabilityCommand;

    public CreateBarbershopCommand(String name, String address, String city, AvailabilityCommand availabilityCommand) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.availabilityCommand = availabilityCommand;
        this.validateSelf();
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

	public AvailabilityCommand getAvailabilityCommand() {
		return availabilityCommand;
	}
    
}