package fr.diginamic.recensement.services;

import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.services.exceptions.ExceptionDept;
import fr.diginamic.recensement.services.exceptions.ExceptionPasConforme;
import fr.diginamic.recensement.services.exceptions.ExceptionReg;
import fr.diginamic.recensement.services.exceptions.ExceptionVille;
import fr.diginamic.recensement.services.exceptions.ExcpetionMinSupMax;

/**
 * Classe repr�sentant un service
 * 
 * @author DIGINAMIC
 *
 */
public abstract class MenuService {

	/**
	 * M�thode abstraite de traitement que doivent poss�der toutes les m�thodes de
	 * services
	 * 
	 * @param lignes  lignes du fichier
	 * @param scanner scanner
	 * @throws ExceptionPasConforme 
	 * @throws ExcpetionMinSupMax 
	 * @throws ExceptionDept 
	 * @throws ExceptionReg 
	 * @throws ExceptionVille 
	 */
	public abstract void traiter(Recensement recensement, Scanner scanner) throws ExceptionPasConforme, ExcpetionMinSupMax, ExceptionDept, ExceptionReg, ExceptionVille;
}
