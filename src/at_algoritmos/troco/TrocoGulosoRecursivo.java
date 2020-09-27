package at_algoritmos.troco;

import java.util.ArrayList;
import java.util.HashMap;

public class TrocoGulosoRecursivo {
	ArrayList<Double> troco = new ArrayList<>();
	
	public static ArrayList<Double> fazerTroco(ArrayList<Double> troco, double[] grana, double quantia) {
		
		
		double flag = 0.00;
		
		for (double g : grana) {
			if (g == quantia) {				
				troco.add(g);
				return troco;
			}
			if (g < quantia) {
				flag = g;				
			}
		}	
		troco.add(flag);
		double trocoTemp = Math.round((quantia - flag)*100.0)/100.0;		

		return fazerTroco(troco, grana, trocoTemp);
	}
	
	public static HashMap<Double, Integer> fazerTrocoHash(HashMap<Double, Integer> grana, double quantia){
		
		double flag = 0.00;
		
		for (Double g : grana.keySet()) {
			if (g == quantia) {				
				grana.put(g, grana.get(g) + 1);				
				return grana;
			}
			if (g < quantia) {				
				flag = g;				
			}
		}	
//		troco.add(flag);
		grana.put(flag, grana.get(flag) + 1);
		double trocoTemp = Math.round((quantia - flag)*100.0)/100.0;
		if (trocoTemp <= 0) {
			return grana;
		}

		return fazerTrocoHash(grana, trocoTemp);
	}
	
	
	
	
	
	
	

}
