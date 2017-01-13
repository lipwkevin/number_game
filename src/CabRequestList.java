import java.util.ArrayList;


public class CabRequestList {
	private ArrayList<CabRequest> list;
	
	public CabRequestList(){
		list = new ArrayList<CabRequest>();
	}
	
	public CabRequest CabReqeustList(int id){
		for(CabRequest c:list){
			if(c.getID() == id)
				return c;
		}
		return null;
	}
	
	public void add(CabRequest c){
		list.add(c);
	}
	
	public CabRequest findByID(int i){
		for(CabRequest ppl:list){
			if (ppl.getID()==i)
				return ppl;
		}
		return null;
	}
	
}
