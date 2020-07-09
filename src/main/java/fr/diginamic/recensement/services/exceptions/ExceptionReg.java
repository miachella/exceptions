package fr.diginamic.recensement.services.exceptions;

public class ExceptionReg extends Exception {
	public ExceptionReg() {
		super("Cette région n'existe pas.");
	}
}
