package week5.advancejava1.SearchOutput;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import week5.advancejava1.Csv.TshirtCsv;
import week5.advancejava1.SearchInput.TshirtSearchInput;
import week5.advancejava1.data.*;
import week5.advancejava1.comparator.*;


public class TshirtSearchOutput {
	Scanner scn;
	
	public ArrayList<Tshirt>getMatchingTshirts(TshirtSearchInput tshirtsSerachIp) throws FileNotFoundException{
		 
		ArrayList<Tshirt>tshirt = new ArrayList<Tshirt>();
		ArrayList<Tshirt>allTshirtData = TshirtCsv.getAllTshirts();
		
		String inputFormat = String.format("%s,%s,%s", tshirtsSerachIp.getColor(),tshirtsSerachIp.getSize(),tshirtsSerachIp.getGender());
		
		String outputFormat;
		String output = tshirtsSerachIp.getOutputChoice().name();
		
		System.out.println("Your choice of Output Preference is : ");
		
		for(Tshirt allTshirtDataiterator : allTshirtData) {
			
			outputFormat = String.format("%s,%s,%s", allTshirtDataiterator.getColor(),allTshirtDataiterator.getSize(),allTshirtDataiterator.getGender());
			
			if(inputFormat.equalsIgnoreCase(outputFormat))
				tshirt.add(allTshirtDataiterator);
			
		}
		
		if(output.equalsIgnoreCase("Price")) {
			
			Collections.sort(tshirt,new PriceComparator());
			System.out.println(output);
			
		}else if(output.equalsIgnoreCase("Rating")) {
			
			Collections.sort(tshirt,new RatingComparator());
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
