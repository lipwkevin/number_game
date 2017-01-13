import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class testcase {
	public static void main(String [] args) throws FileNotFoundException, UnsupportedEncodingException{
		DataStore data = new DataStore();
		
		int[] ID = {1,2,3,4,5,6,7,8,9};
		String [] cusName = {"test1","tester","tester","123","465","2165423","48","dsa","sd"};
		String [] cusEmail = {"gtfj5hu76/-0p[;jk","fr vhyujoh vgrf","CXF V","ESRTGHYUJTD","defvgthu","dcfgh","xcfgv","fc","fs4v !@#"};
		String [] cusPhone = {"fauinh","aoifuhm","cfd","asd","sacdjo","ascd","ascd","acsd","sca"};
		String [] id ={"1","2","3","4","5","6","7","8","9"};
		
		int [] offerer = {1,1,1,2,2,2,3,3,3};
		int [] requester = {7,7,7,7,7,8,9,8,8};
		String [] joining = {"123","123","132","456","321","123","456","321","123"};
		String time = "201412251630";
		String [] startPoint = {"mcmaster","123","asdfasdf","asf","d","df","d","f","d"};
		String [] endPoint = {"sd","sd","sd","sd","sd","sd","dafd","a","f"};
		String [] startRegion = {"123","123","123","321","321","456","456","321","456"};
		String [] endRegion = {"456","321","123","456","321","123","456","321","123"};
		int [] seat = {1,2,3,1,2,3,1,2,3};
		
		String pass = "123";
		
		System.out.println(cusName[4]);
		//System.out.println(cusEmail[5]);
		//System.out.println(cusPhone[5]);
		//System.out.println(ID[5]);

		//initialize
		for(int i = 0;i<9;i++){
			data.addCustomer(new Customer(cusName[i],cusPhone[i],ID[i],cusEmail[i]));
			data.addOffer(new Offer(ID[i],time,startPoint[i],endPoint[i],startRegion[i],endRegion[i],seat[i],offerer[i]));
			System.out.println(""+ID[i]);
			data.addRequest(new OfferRequest(ID[i],requester[i],offerer[i]));
			data.addLogin(id[i], pass);
		}
		
		//end of initializer
		
		//start of write
		PrintWriter writerCus = new PrintWriter("Cutomers", "UTF-8");
		PrintWriter writerOffer = new PrintWriter("Offers", "UTF-8");
		PrintWriter writerRequest = new PrintWriter("Requests", "UTF-8");
		PrintWriter writerLogin = new PrintWriter("Logins", "UTF-8");
		String seperator = "/*********************/";
		Object test;
		System.out.println("START:");
		for(int i = 0;i<9;i++){
			test = data.getCustomers().findByID(ID[i]);
			writerCus.println(""+((Customer) test).getName());	
			writerCus.println(""+((Customer) test).getPhone());
			writerCus.println(""+((Customer) test).getEmail());
			writerCus.println(""+((Customer) test).getID());
			writerCus.println(""+seperator);
			test = data.getOffers().findByID(ID[i]);
			writerOffer.println(""+((Offer) test).getID());	
			writerOffer.println(""+((Offer) test).getOfferer());
			writerOffer.println(""+((Offer) test).getTime());
			writerOffer.println(""+((Offer) test).getStartPoint());
			writerOffer.println(""+((Offer) test).getEndPoint());
			writerOffer.println(""+((Offer) test).getStart());
			writerOffer.println(""+((Offer) test).getEnd());
			writerOffer.println(""+((Offer) test).getSeats());
			writerOffer.println(""+seperator);
			test = data.getRequests().findByID(ID[i]);
			writerRequest.println(""+((OfferRequest) test).getID());	
			writerRequest.println(""+((OfferRequest) test).getOfferer());
			writerRequest.println(""+((OfferRequest) test).getRequester());
			writerRequest.println(""+((OfferRequest) test).getStatus());
			writerRequest.println(""+seperator);
			test= data.getLogin().printValue();
			ArrayList l1 = ((ArrayList<ArrayList<String>>) test).get(0);
			ArrayList l2 = ((ArrayList<ArrayList<String>>) test).get(1);
			writerLogin.println(""+l1.get(i));
			writerLogin.println(""+l2.get(i));
			writerLogin.println(""+seperator);
		}
		writerCus.close();
		writerRequest.close();
		writerOffer.close();
		writerLogin.close();
		
		//end of print
		
//		test = data.getCustomers().findByID(5);
//		System.out.println("Customer 4:"+ ((Customer) test).getName());	
//		test = data.getCustomers().findByID(11);
//		boolean temp = null==test;
//		System.out.println("Customer DNE:"+  temp);
//		temp = data.login(id[3], pass);
//		System.out.println("login pass:"+  temp);
//		temp = data.login(id[3], "WRONG");
//		System.out.println("login fail:"+  !temp);
		
	}
}
