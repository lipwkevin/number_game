import java.util.ArrayList;
import java.util.Collections;

public class NumberPool {
	int numCap;
	ArrayList<Integer>used = new ArrayList<Integer>();
	ArrayList<Integer> pool = new ArrayList<Integer>();
	
	public NumberPool(int numCap){
		this.numCap = numCap;
		for(int i=0;i<numCap;i++){
			pool.add(i);
		}
		reset();
	}
	
	public void reset(){
		pool.addAll(used);
		used.clear();
		pool.remove(0);
		used.add(0);
		pool.remove(1);
		used.add(1);
		pool.remove(2);
		used.add(2);
		pool.remove(3);
		used.add(3);	
	}
	
	public int next(int i,int num){
		int x = i+1;
		if(x>=numCap)
			x=0;
		if(used.contains(x))
			x = next(x,num);
		else{
			used.remove((Object)num);
			pool.add(num);
			used.add(x);
			pool.remove((Object)x);
		}
		return x;
	}
	
	public int prev(int i,int num){
		int x = i-1;
		if(x<0)
			x=numCap-1;
		if(used.contains(x))
			x = prev(x,num);
		else{
			used.remove((Object)num);
			pool.add(num);
			used.add(x);
			pool.remove((Object)x);
		}
		return x;
	}

}
