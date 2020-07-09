package fr.diginamic.recensement.services;

import java.util.List;
import java.util.Scanner;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.exceptions.ExceptionDept;
import fr.diginamic.recensement.services.exceptions.ExceptionReg;

/**
 * Recherche et affichage de la population d'une r�gion
 * 
 * @author DIGINAMIC
 *
 */
public class RecherchePopulationRegionService extends MenuService {

	@Override
	public void traiter(Recensement rec, Scanner scanner) throws ExceptionReg {

		System.out.println("Quel est le nom (ou le d�but de nom) de la r�gion recherch�e ? ");
		String choix = scanner.nextLine();

		List<Ville> villes = rec.getVilles();
		
		if (((Ville) villes).getNomRegion().contains(choix)) {
			throw new ExceptionReg();
		}
		
		int somme = 0;
		String nom = null;
		for (Ville ville : villes) {
			if (ville.getNomRegion().toLowerCase().equals(choix.toLowerCase())
					|| ville.getCodeRegion().toLowerCase().equals(choix.toLowerCase())) {
				somme += ville.getPopulation();
				nom = ville.getNomRegion();
			}
		}
		if (somme > 0) {
			System.out.println("Population de la r�gion " + nom + " : " + somme);
		} else {
			System.out.println("R�gion " + choix + " non trouv�e.");
		}
	}

}
