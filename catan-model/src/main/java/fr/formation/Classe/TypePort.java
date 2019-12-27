package fr.formation.Classe;

public enum TypePort {
	Port(4), PortArgile(1), PortBois(1), PortMinerai(1), PortLaine(1), PortBle(1);
	
	private int occurences;

	public int getOccurences() {
		return occurences;
	}

	public void setOccurences(int occurences) {
		this.occurences = occurences;
	}

	TypePort(int occurences) {
		this.occurences = occurences;
	}
}
