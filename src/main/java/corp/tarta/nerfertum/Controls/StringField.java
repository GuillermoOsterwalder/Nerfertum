package corp.tarta.nerfertum.Controls;

public class StringField extends RestrictiveTextField{

private final String regex = "^(\\s*\\w*\\W*)*$";
	
	public StringField (int maxLenght){
		super();
		
		this.setMaxLength(maxLenght);
		this.setRestrict(regex);
		this.setNumericField(false);
	}
}
