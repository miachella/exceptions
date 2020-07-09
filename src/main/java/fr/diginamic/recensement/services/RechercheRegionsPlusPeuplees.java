package fr.diginamic.recensement.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import fr.diginamic.recensement.entites.Recensement;
import fr.diginamic.recensement.entites.Region;
import fr.diginamic.recensement.entites.Ville;
import fr.diginamic.recensement.services.comparators.EnsemblePopComparateur;
import fr.diginamic.recensement.services.exceptions.ExceptionPasConforme;

/**
 * Affichage des 10 r�gions les plus peupl�es
 * 
 * @author DIGINAMIC
 *
 */
public class RechercheRegionsPlusPeuplees extends MenuService {

	@Override
	public void traiter(Recensement recensement, Scanner scanner) throws ExceptionPasConforme {

		System.out.println("Veuillez saisir un nombre de régions:");
		String nbRegionsStr = scanner.nextLine();
		
		if (!NumberUtils.isDigits(nbRegionsStr)) {
			throw new ExceptionPasConforme();
		}
		
		int nbRegions = Integer.parseInt(nbRegionsStr);

		// On r�cup�re la liste des villes du recensement
		List<Ville> villes = recensement.getVilles();

		// On cr�� une HashMap pour stocker les r�gions
		// - Cl�: nom de la r�gion
		// - Valeur: instance de r�gion
		Map<String, Region> mapRegions = new HashMap<>();

		// On parcourt les 35800 villes, une par une
		for (Ville ville : villes) {

			// On regarde si pour une ville donn�e, la r�gion existe dans la map ou non
			Region region = mapRegions.get(ville.getNomRegion());

			// Si la r�gion n'existe pas, on la cr��e
			if (region == null) {
				region = new Region(ville.getCodeRegion(), ville.getNomRegion());
				mapRegions.put(ville.getNomRegion(), region);
			}

			// Une fois qu'on a une r�gion, on lui ajoute la ville courante
			region.addVille(ville);
		}

		// Une fois la boucle termin�e, on va r�cup�rer toutes les r�gions qui sont dans
		// la HashMap pour les mettre dans une liste
		List<Region> regions = new ArrayList<Region>();
		regions.addAll(mapRegions.values());

		// On cr�� un comparateur de Region pour trier la liste des r�gions dans l'ordre
		// de populations d�croissantes.
		Collections.sort(regions, new EnsemblePopComparateur(false));

		// On affiche les 10 premi�re r�gions de la liste tri�e.
		for (int i = 0; i < nbRegions; i++) {
			Region region = regions.get(i);
			System.out.println("Region " + region.getNom() + " : " + region.getPopulation() + " habitants.");
		}

	}

}
