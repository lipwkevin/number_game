
public class Security {
	private final static String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890,./;\'\"\\!@#$%^&*()-=";
	private static String shifted = charSet;
	private final int byteShift = 6;
	
	public Security(){
		shifted = charSet.substring(byteShift) + charSet.substring(0, byteShift);
		System.out.println(shifted);
	}
	
	public String encryption(String txt){
		String temp = "";
		for(char ch : txt.toCharArray()){
			temp+=shifted.charAt((int)charSet.indexOf(ch));
		}
		return temp;
	}
	
	public String decryption(String txt){
		String temp = "";
		for(char ch : txt.toCharArray()){
			temp+=charSet.charAt((int)shifted.indexOf(ch));
		}
		return temp;
	}
	
	public static void main(String [] args){
		Security security = new Security();
		String test1 = "kevin";
		String test2 = security.encryption(test1);
		String temp= test2;
		
		
		System.out.println("BEFORE	"+temp);
		for(int i = 1;i<20;i++){
		temp = security.decryption(temp);
		System.out.println("round : "+i+"  "+temp);
		}
		
//		System.out.println(temp);
//		for(int i = 0;i<20;i++){
//		temp = security.decryption(temp);
//		System.out.println("round : "+i+"  "+temp);
//		}
		
		
//		System.out.println(charSet);
//		System.out.println(shifted);
//		//System.out.println(test1);
//		temp = security.encryption(test1);
//		System.out.println(temp);
//		temp = security.encryption(temp);
//		System.out.println(temp);
//		temp = security.decryption(temp);
//		System.out.println(temp);
//		temp = security.decryption(temp);
//		System.out.println(temp);
//		//System.out.println(test2);
//		temp = security.encryption(test2);
//		//System.out.println(temp);
//		temp = security.decryption(test2);
//		System.out.println(temp);
		
	}
	
}

