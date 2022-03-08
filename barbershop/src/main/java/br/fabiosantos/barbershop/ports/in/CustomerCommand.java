package br.fabiosantos.barbershop.ports.in;

import br.fabiosantos.barbershop.shared.SelfValidating;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class CustomerCommand extends SelfValidating<CustomerCommand> {

    @NotEmpty
    @NotNull
    private final String name;

    @NotEmpty
    @NotNull
    private final String email;

    @NotEmpty
    @NotNull
    private final String phone;

    public CustomerCommand(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.validateSelf();
    }

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}
    
}
