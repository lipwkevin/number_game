
public class Offer {
	private int offererNum;
	private String time;//in format : YYYY-MM-DD-HH-MM
	private String startPoint;
	private String endPoint;
	private String startRegion;
	private String endRegion;
	private int seats;
	private int id;
	
	
	public Offer(int id,String time, String startPoint, String endPoint,String startRegion,String endRegion, int seats, int offerNum){
		this.id=id;
		this.time=time;
		this.startPoint=startPoint;
		this.endPoint=endPoint;
		this.startRegion = startRegion;
		this.endRegion = endRegion;
		this.seats=seats;
		this.offererNum=offerNum;
	}

	public int getOfferer(){
		return offererNum;
	}
	public String getTime(){
		return time;
	}
	public String getStart(){
		return startRegion;
	}
	public String getEnd(){
		return endRegion;
	}
	public int getSeats(){
		return seats;
	}
	
	public int getID(){
		return id;
	}
	public String getStartPoint(){
		return startPoint;
	}
	
	public String getEndPoint(){
		return endPoint;
	}
	public void seatTake(int i){
		this.seats = seats-i;
	}
}

