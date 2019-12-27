package fr.formation.Classe;

public enum CarteDev {
	Chevalier(14), PointDeVictoire(5), ProgresRoute(2), ProgresDecouverte(2), ProgresMonopole(2);

	private int occurences;

	public int getOccurences() {
		return occurences;
	}

	public void setOccurences(int occurences) {
		this.occurences = occurences;
	}

	CarteDev(int occurences) {
		this.occurences = occurences;
	}
}
