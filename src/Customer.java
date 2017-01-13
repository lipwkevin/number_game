import java.util.ArrayList;


public class Customer {
	private String name;
	private String phone;
	private int id;
	private String email;
	private ArrayList profile;
	
	public Customer(String name,String phone,int id,String email){
		this.name = name;
		this.phone = phone;
		this.id = id;
		this.email = email;
		this.profile = new ArrayList();
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public int getID(){
		return this.id;
	}
	
	public String getEmail(){
		return this.email;
	}
	
}

