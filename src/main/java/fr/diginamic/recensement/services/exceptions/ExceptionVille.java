package fr.diginamic.recensement.services.exceptions;

public class ExceptionVille extends Exception {
	public ExceptionVille() {
		super("Cette ville n'existe pas.");
	}
}
