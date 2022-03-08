package br.fabiosantos.barbershop.exception;

public class BarbershopAlreadyRegisteredException extends BusinessException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5640731380346879443L;

	public BarbershopAlreadyRegisteredException(String barbershopName) {
        super(String.format("Barbershop with name %s already exists!", barbershopName), 409);
    }
}
