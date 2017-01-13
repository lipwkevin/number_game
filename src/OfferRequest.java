
public class OfferRequest {
	
	private int id;
	private int requesterNum;
	private int offererNum;
	private int status;
	/* posible states
	 * 0 : offerer undecided
	 * 1 : offerer rejected
	 * 2 : oferrer accepted
	 * 
	 */

	public OfferRequest(int offerNum, int requesterNum, int offererNum){
		this.id=offerNum;
		this.requesterNum=requesterNum;
		this.offererNum=offererNum;
		this.status=0;
	}
	
	public int getID(){
		return this.id;
	}
	
	public int getRequester(){
		return this.requesterNum;
	}
	
	public int getOfferer(){
		return this.offererNum;
	}
	
	public int getStatus(){
		return this.status;
	}
	
	public void accept(){
		this.status = 2;
	}
	
	public void reject(){
		this.status = 1;
	}
}

