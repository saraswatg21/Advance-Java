package week5.advancejava1.application;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import week5.advancejava1.SearchInput.TshirtSearchInput;
import week5.advancejava1.SearchOutput.TshirtSearchOutput;
import week5.advancejava1.data.Tshirt;
import week5.advancejava1.view.Input;
import week5.advancejava1.view.Output;

public class Application {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
        Input input = new Input();
        TshirtSearchInput tshirtSearchIp = input.getInput();
        
        TshirtSearchOutput tshirtSearchOp = new TshirtSearchOutput();
        ArrayList<Tshirt>matchedTShirts = tshirtSearchOp.getMatchingTshirts(tshirtSearchIp);
        
        Output output = new Output();
        output.displayOutput(matchedTShirts);
	}

}
