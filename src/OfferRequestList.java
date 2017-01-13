import java.util.ArrayList;
public class OfferRequestList {
	ArrayList<OfferRequest> list;
	ArrayList<OfferRequest> filter;
	public OfferRequestList(){
		list = new ArrayList<OfferRequest>();
		filter = new ArrayList<OfferRequest>();
	}
	
	public ArrayList<OfferRequest> filterForOfferer(int ID){
		filter.clear();
		for(OfferRequest request:list){
			if((request.getOfferer()==ID)&&(request.getStatus()==0))
					filter.add(request);
		}
		return filter;
	}
	
	public ArrayList<OfferRequest> filterForRequester(int ID){
		filter.clear();
		filter.clear();
		for(OfferRequest request:list){
			if((request.getOfferer()==ID)&&(request.getStatus()!=0))
					filter.add(request);
		}
		return filter;
	}
	
	public OfferRequest findByID(int id){
		for(OfferRequest request:list){
			if(request.getID()==id)
				return request;
		}
		return null;
	}
	
	public void add(OfferRequest o){
		list.add(o);
	}
	
	public void updateList(ArrayList<OfferRequest> newList){
		for(OfferRequest o : newList){
			for(int i = 0;i<list.size();i++){
				if(o.getID()==list.get(i).getID())
					list.set(i, o);
			}
		}
			
	}
	
}
