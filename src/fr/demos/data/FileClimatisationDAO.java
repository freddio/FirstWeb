package fr.demos.data;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import fr.demos.formation.Climatisation;

public class FileClimatisationDAO implements ClimatisationDAO {

	private String nomFichier;
	public FileClimatisationDAO(String nomFichier){
		this.nomFichier=nomFichier;
	}
	
	
	@Override
	public void sauve(Climatisation cl) throws Exception {
		List<Climatisation> liste=null;
		try {
			liste = this.rechercheTout();
		}
		catch(Exception e){
			// si la recherche plante, ce n'est pas forcément un pb : le fichier n'existe pas encore
			System.out.println(e.getMessage());
			// on crée la liste car on ne l'a pas récupérée depuis le fichier
			liste = new ArrayList<>();
		}
		
		// on complete la liste retrouvée avec le nouvel élément
		
		liste.add(cl);
		// on écrit la nouvelle liste
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(nomFichier)));) {
			oos.writeObject(liste);
			oos.flush();
		}
		
	}

	@Override
	public List<Climatisation> rechercheTout() throws Exception {
		ArrayList<Climatisation> listeClims=null;
		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(nomFichier)));) {

			listeClims = (ArrayList<Climatisation>) ois.readObject();
		}
		return listeClims;
	}

	@Override
	public List<Climatisation> recherche(String critere) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nombre(String critere) {
		List<Climatisation> liste=null;
		int nb=0;
		try {
			liste = this.rechercheTout();
			nb=liste.size();
		}
		catch(Exception e){
			// si la recherche plante, ce n'est pas forcément un pb : le fichier n'existe pas encore
			System.out.println(e.getMessage());
		}
		return nb;
	}

}











