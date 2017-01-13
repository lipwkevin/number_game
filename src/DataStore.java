
public class DataStore {
	private CustomerList customers;
	private OfferList offers;
	private OfferRequestList requests;
	private CabRequestList cabs;
	private LoginList login;
	
	private final String FILELOCATION_Customer = "";
	private final String FILELOCATION_Offer = "";
	private final String FILELOCATION_Request = "";
	private final String FILELOCATION_CabRequest = "";
	private final String FILELOCATION_Login = "";
	
	public DataStore(){
		customers = new CustomerList();
		offers = new OfferList();
		requests = new OfferRequestList();
		cabs = new CabRequestList();
		login = new LoginList();
	}
	
	public void addCustomer(Customer ppl){customers.add(ppl);}
	public void addLogin(String id, String pass){login.add(id, pass);}
	public void addOffer(Offer o){offers.add(o);	}
	public void addRequest(OfferRequest o){requests.add(o);}
	public void addCabRequest(CabRequest c){cabs.add(c);}
	
	public CustomerList getCustomers (){ return customers;}
	public OfferList getOffers (){ return offers;}
	public OfferRequestList getRequests (){ return requests;}
	public CabRequestList getCab (){ return cabs;}
	public LoginList getLogin (){ return login;}
	
	public boolean login(String id, String pass){
		return login.login(id,pass);
	}
	
	
	
}
