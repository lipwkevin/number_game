
public class CabRequest {
	private String name;
	private String phone;
	private String time;
	private String startPoint;
	private String endPoint;
	private int id;

	public CabRequest(String name, String phone, String time, String startPoint, String endPoint,int cabRequestNum){
		this.name=name;
		this.phone=phone;
		this.time=time;
		this.startPoint=startPoint;
		this.endPoint=endPoint;
		this.id=cabRequestNum;
	}
	
	public int returnCabRequestNum(){
		return id;
	}
	
	public String getPhone(){
		return this.phone;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getID(){
		return this.id;
	}
}