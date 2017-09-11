package fr.demos.formation;

public class Climatisation {
	private double temperature;
	private double pression;
	private int humidite;
	private String nom;
	private long dateMesure;
	
	
	
	public Climatisation(double temperature, double pression, int humidite,
			String nom) {
		super();
		this.temperature = temperature;
		this.pression = pression;
		this.humidite = humidite;
		this.nom = nom;
		this.dateMesure= System.currentTimeMillis();
	}
	public double getTemperature() {
		return temperature;
	}
	public double getPression() {
		return pression;
	}
	public int getHumidite() {
		return humidite;
	}
	public String getNom() {
		return nom;
	}
	public long getDateMesure() {
		return dateMesure;
	}

}
