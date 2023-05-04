package SearchInput;

import data.*;

public class TshirtSearchInput {
	private Color color;
	private Size size;
	private Gender gender;
	private OutputChoice outputChoice;
	
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public OutputChoice getOutputChoice() {
		return outputChoice;
	}
	public void setOutputPreference(OutputChoice outputChoice) {
		this.outputChoice = outputChoice;
	}
	
}
