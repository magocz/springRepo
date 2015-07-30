package pl.spring.demo.to;

public class AthorTo {
	private String firstName;
	private String lastName;
	
	public AthorTo(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public AthorTo(String data){
		if(data != null && data.contains(" ")){
			this.firstName = data.split(" ")[0];
			this.lastName = data.split(" ")[1];
			return;
		}
		this.firstName = null;
		this.lastName = null;
		
	}
	
	@Override
	public String toString(){
		return this.firstName + " " + this.lastName;
	}
}
