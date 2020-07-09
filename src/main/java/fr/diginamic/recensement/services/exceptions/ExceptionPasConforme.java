package fr.diginamic.recensement.services.exceptions;

public class ExceptionPasConforme extends Exception {
	public ExceptionPasConforme() {
		super("Vous devez rentrer un chiffre positif.");
	}
}
