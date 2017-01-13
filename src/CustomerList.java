import java.util.ArrayList;


public class CustomerList {
	ArrayList<Customer> list;
	ArrayList<Customer> filter;
	public CustomerList(){
		this.list = new ArrayList();
		this.filter = new ArrayList();
	}
	
	public void add(Customer input){
		list.add(input);
	}
	
	
	public Customer findByID(int i){
		for(Customer ppl:list){
			if (ppl.getID()==i)
				return ppl;
		}
		return null;
	}
	
}
