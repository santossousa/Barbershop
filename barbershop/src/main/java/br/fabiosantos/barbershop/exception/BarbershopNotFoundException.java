package br.fabiosantos.barbershop.exception;

public class BarbershopNotFoundException  extends BusinessException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3138976356455079838L;

	public BarbershopNotFoundException(String barbershopName) {
        super(String.format("Barbershop with name %s not found!", barbershopName), 409);
    }
}
