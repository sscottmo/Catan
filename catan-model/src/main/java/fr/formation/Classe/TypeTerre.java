package fr.formation.Classe;

public enum TypeTerre {
	Bois(4), Argile(3), Minerai(3), Laine(4), Ble(4);
	
	private int occurences;

	public int getOccurences() {
		return occurences;
	}

	public void setOccurences(int occurences) {
		this.occurences = occurences;
	}

	TypeTerre(int occurences) {
		this.occurences = occurences;
	}
}
