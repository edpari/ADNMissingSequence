import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Sequences nSeq = new Sequences();
		String sequenceInput = getSequence("D:/InputPFE/ncbi_dataset/data/genomic.fna");
		 nSeq.translateStringToEnum(sequenceInput);
		 nSeq.getSequences(8);
		 nSeq.parseList();
		 nSeq.printNbSeq();
	}
	
	private static String getSequence(String filename) {
		String sequenceInput = "";
		try (Scanner sc = new Scanner(new File(filename))) {
			// Skip first line
			sc.nextLine();
			while (sc.hasNextLine()) {
				sequenceInput += sc.nextLine().trim();
			}
		} catch(FileNotFoundException e) {
			System.out.println("Fichié non trouvé");
		}
		return sequenceInput;
	}

}
