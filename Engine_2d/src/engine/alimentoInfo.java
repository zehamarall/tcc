package engine;

public class alimentoInfo {

	String[] info;

	public alimentoInfo() {
		info =  new String[19];

		info[0] = "Energia";
		info[1] = "Energia";
		info[2] = "Energia";
		info[3] = "Energia";
		info[4] = "Energia";
		info[5] = "Imunidade";
		info[6] = "Imunidade";
		info[7] = "Imunidade";
		info[8] = "Energia";
		info[9] = "Energia";
		info[10] = "Energia";
		info[11] = "Energia";
		info[12] = "Imunidade";
		info[13] = "Energia";
		info[14] = "Imunidade";
		info[15] = "Imunidade";
		info[16] = "Imunidade";
		info[17] = "Energia";
		info[18] = "Imunidade";

	}
	
	public String alimentoCaracteristica(int i){
		return info[i];
	}
}
