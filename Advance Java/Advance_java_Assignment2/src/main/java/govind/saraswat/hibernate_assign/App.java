package govind.saraswat.hibernate_assign;
import java.io.FileNotFoundException;



import java.util.ArrayList;
import java.util.List;

import data.Tshirt;
import SearchInput.TshirtSearchInput;
import SearchOutput.TshirtSearchOutput;
import view.Input;
import view.Output;

public class App {
	
public static void main(String[] args) throws FileNotFoundException
	{
        Input input = new Input();
        TshirtSearchInput tshirtSearchIp = input.getInput();
        
        TshirtSearchOutput tshirtSearchOp = new TshirtSearchOutput();
        ArrayList<Tshirt>matchedTShirts = tshirtSearchOp.getMatchingTshirts(tshirtSearchIp);
        
        Output output = new Output();
        output.displayOutput(matchedTShirts);
        
        Configure configure = new Configure();
        List<Tshirt> res = new ArrayList<Tshirt>();
        res = configure.searchItem("yellow","M","L");
        System.out.println(res);
	

	}
}
