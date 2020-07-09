package fr.diginamic.recensement.services.exceptions;

public class ExceptionDept extends Exception {
	public ExceptionDept() {
		super("Ce département n'existe pas.");
	}
}
