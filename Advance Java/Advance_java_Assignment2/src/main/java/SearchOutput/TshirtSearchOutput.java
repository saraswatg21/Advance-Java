package SearchOutput;

import java.io.FileNotFoundException;








import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Comparator.PriceComparator;
import Comparator.RatingComparator;
import data.*;
import SearchInput.TshirtSearchInput;





public class TshirtSearchOutput  {

Scanner scn;
	
	public ArrayList<Tshirt>getMatchingTshirts(TshirtSearchInput tshirtsSearchIp) throws FileNotFoundException{
		 
		ArrayList<Tshirt>tshirt = new ArrayList<Tshirt>();
		
		ArrayList<Tshirt>allTshirt = new ArrayList<Tshirt>();
		
		String inputFormat = String.format("%s,%s,%s", tshirtsSearchIp.getColor(),tshirtsSearchIp.getSize(),tshirtsSearchIp.getGender());
		
		String outputFormat;
		String output = tshirtsSearchIp.getOutputChoice().name();
		
		System.out.println("Your choice of Output Preference is : ");
		

		
		if(output.equalsIgnoreCase("Price")) {
			
			Collections.sort(tshirt,new PriceComparator());
			System.out.println(output);
			
		}else if(output.equalsIgnoreCase("Rating")) {
			
			Collections.sort(
					tshirt,new RatingComparator());
			System.out.println(output);
			
		}else {
			
			Collections.sort(tshirt,new PriceComparator());
			Collections.sort(tshirt, new RatingComparator());
			System.out.println(output);
			
		}
		
		System.out.println("\n\n");
		
		return tshirt;
	}

	
}
