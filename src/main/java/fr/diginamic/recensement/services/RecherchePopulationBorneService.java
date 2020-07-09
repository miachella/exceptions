package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.exceptions.ExceptionPasConforme;
import fr.diginamic.recensement.services.exceptions.ExcpetionMinSupMax;

/**
 * Recherche et affichage de toutes les villes d'un d�partement dont la
 * population est comprise entre une valeur min et une valeur max renseign�es
 * par l'utilisateur.
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationBorneService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws ExceptionPasConforme, ExcpetionMinSupMax {

		System.out.println("Quel est le code du département recherché ? ");
		String choix = scanner.nextLine();
		
		if (!NumberUtils.isDigits(choix)) {
			throw new ExceptionPasConforme();
		}

		System.out.println("Choississez une population minimum (en milliers d'habitants): ");
		String saisieMin = scanner.nextLine();
		
		if (!NumberUtils.isDigits(saisieMin) || Integer.parseInt(saisieMin) < 0) {
			throw new ExceptionPasConforme();
		}
		
		System.out.println("Choississez une population maximum (en milliers d'habitants): ");
		String saisieMax = scanner.nextLine();
		
		if (!NumberUtils.isDigits(saisieMax) || Integer.parseInt(saisieMax) < 0) {
			throw new ExceptionPasConforme();
		}
		
		if (Integer.parseInt(saisieMax) < Integer.parseInt(saisieMin)) {
			throw new ExcpetionMinSupMax();
		}

		int min = Integer.parseInt(saisieMin) * 1000;
		int max = Integer.parseInt(saisieMax) * 1000;

		List<Ville> villes = rec.getVilles();
		for (Ville ville : villes) {
			if (ville.getCodeDepartement().equalsIgnoreCase(choix)) {
				if (ville.getPopulation() >= min && ville.getPopulation() <= max) {
					System.out.println(ville);
				}
			}
		}
	}

}
