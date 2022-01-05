import java.util.ArrayList;
import java.util.List;

public class Sequences {
	// ENUMS
	public enum basesADN {
		A,C,T,G	
	}

	// ATTRIBUTES
	private List<List<basesADN>> listePossible;
	private List<basesADN> translatedInput;
	private long nbTotCombinaisons;
	private int lengthSeq;

	public Sequences() {
		this.listePossible = new ArrayList<>();
		this.translatedInput = new ArrayList<>();
	}
	

	public void translateStringToEnum(String input) {
		char charArray[] = input.toCharArray();
		for(char elt : charArray) {
			switch(elt) {
				case 'A':
					this.translatedInput.add(basesADN.A);
					break;
				case 'C':
					this.translatedInput.add(basesADN.C);
					break;
				case 'G':
					this.translatedInput.add(basesADN.G);
					break;
				case 'T':
					this.translatedInput.add(basesADN.T);
					break;
			}
		}
		
	}
	
	public void getSequences(int lengthTot) {
		this.lengthSeq=lengthTot;
		this.getSequences(lengthTot, 0, new ArrayList<basesADN>());
	}

	public void parseList() {
		this.nbTotCombinaisons = this.listePossible.size();
		if (!this.listePossible.isEmpty()) {
			int i = this.lengthSeq;
			int nbComb = this.translatedInput.size();
			while(i <= nbComb) {
				List<basesADN> currSeq = new ArrayList<basesADN>();
				for(int j = this.lengthSeq;j>0;j--) {
					currSeq.add(this.translatedInput.get(i-j));
				}
				this.listePossible.remove(currSeq);
				i +=1;
			}
		} else {
			System.out.println("Impossible de recuperer une sequence vide");
		}
	}
	
	public void printNbSeq() {
		System.out.println("Nombre de sequences de " + lengthSeq + "bases non présentes : " + this.listePossible.size() + " sur " + this.nbTotCombinaisons);
	}
	
	public void printSequences() {
		for (List<basesADN> seq : this.listePossible) {
			for(basesADN base : seq) {
				switch(base) {
					case A:
						System.out.print('A');	
						break;
					case C:
						System.out.print('C');	
						break;
					case G:
						System.out.print('G');	
						break;
					case T:
						System.out.print('T');	
						break;
				}
			}
			System.out.print("\n");
		}
	}
	
	private void getSequences(int lengthTot, int lengthCurr, List<basesADN> listCurr) {
		if(lengthTot > lengthCurr) {
			// Adenine
			List<basesADN> listA = new ArrayList<>(listCurr);
			listA.add(basesADN.A);

			// Cytosine
			List<basesADN> listC = new ArrayList<>(listCurr);
			listC.add(basesADN.C);

			// Guanine
			List<basesADN> listG = new ArrayList<>(listCurr);
			listG.add(basesADN.G);

			// Thymine
			List<basesADN> listT = new ArrayList<>(listCurr);
			listT.add(basesADN.T);

			this.getSequences(lengthTot, lengthCurr+1, listA);
			this.getSequences(lengthTot, lengthCurr+1, listC);
			this.getSequences(lengthTot, lengthCurr+1, listG);
			this.getSequences(lengthTot, lengthCurr+1, listT);
			
		} else {
			this.listePossible.add(listCurr);
		}
	}

}
