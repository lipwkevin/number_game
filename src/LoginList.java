import java.util.ArrayList;


public class LoginList {
	private ArrayList<String> id;
	private ArrayList<String> password;
	public LoginList(){
		id = new ArrayList<String>();
		password = new ArrayList<String>();
	}
	
	public void add(String id,String pass){
		this.id.add(id);
		this.password.add(pass);

	}
	
	public boolean login(String login, String pass){
		int i = this.id.indexOf(login);
		if(i!=-1)
			return (this.password.get(i).equals(pass));
		return false;
	}
	
	public ArrayList<ArrayList<String>> printValue(){
		ArrayList<ArrayList<String>> temp = new ArrayList<ArrayList<String>>();
		temp.add(id);
		temp.add(password);
		//System.out.println(temp.toString());
		return temp;
	}
}
