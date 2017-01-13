import java.util.ArrayList;


public class OfferList {
	private ArrayList<Offer> offers;
	private ArrayList<Offer> matched;

	public OfferList(){
		offers= new ArrayList<Offer>();
		matched= new ArrayList<Offer>();
	}

	public void add(Offer o){
		offers.add(o);
	}
	
	public Offer findByID(int i){
		for(Offer ppl:offers){
			if (ppl.getID()==i)
				return ppl;
		}
		return null;
	}
	
	public ArrayList<Offer> filter(String time,String start,String end,int seat){
		matched.clear();
		
		if(time!=null)
			filterTime(time);
		if(start!=null)
			filterStart(start);
		if(end!=null)
			filterEnd(end);
		if(seat!=0)
			filterSeat(seat);
		
		return matched;
	}
	public void filterTime(String time){
		ArrayList<Offer> matched= new ArrayList<Offer>();
		for(Offer o:offers){
			if (o.getTime().equals(time)){
				matched.add(o);
			}
		}
		
	}
	public void filterStart(String startPlace){
		ArrayList<Offer> matched= new ArrayList<Offer>();
		for(Offer o:offers){
			if (o.getStart().equals(startPlace)){
				matched.add(o);
			}
		}
		
	}
	public void filterEnd(String endPlace){
		ArrayList<Offer> matched= new ArrayList<Offer>();
		for(Offer o:offers){
			if (o.getEnd().equals(endPlace)){
				matched.add(o);
			}
		}
		
	}
	public void filterSeat(int seats){
		ArrayList<Offer> matched= new ArrayList<Offer>();
		for(Offer o:offers){
			if (o.getSeats()<=seats){
				matched.add(o);
			}
		}
		
	}
	

}

