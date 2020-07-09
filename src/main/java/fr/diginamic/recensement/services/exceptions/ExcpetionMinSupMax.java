package fr.diginamic.recensement.services.exceptions;

public class ExcpetionMinSupMax extends Exception {
	public ExcpetionMinSupMax() {
		super("Vous devez rentrer le minimum inférieur au maximum demandé.");
	}
}
