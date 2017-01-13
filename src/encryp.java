
public class encryp {
	static String charSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,./;-\'\"\\[]{}!@#$%^&*()-= ";
	static String shifted = charSet;

public static void main(String [] args){
	
	String test1 = "This IS a testing STring ";
	String test2 = "ANOTHER TEST STRING cooooming!";
	String temp= "";
	int byteShift = 30;
	shifted = byteShift(charSet,byteShift);
	
	
	System.out.println(charSet);
	System.out.println(shifted);
	System.out.println(test1);
	temp = encryption(test1);
	System.out.println(temp);
	temp = decryption(temp);
	System.out.println(temp);
	System.out.println(test2);
	temp = encryption(test2);
	System.out.println(temp);
	temp = decryption(temp);
	System.out.println(temp);
	}
	
	public static String byteShift(String ori, int shift){
		for(int i =0;i<shift;i++)
			ori = ori.substring(1)+ori.substring(0,1);
		return ori;
	}
	public static String encryption(String txt){
		String temp = "";
		for(char ch : txt.toCharArray()){
			temp+=shifted.charAt((int)charSet.indexOf(ch));
		}
		return temp;
	}
	
	public static String decryption(String txt){
		String temp = "";
		for(char ch : txt.toCharArray()){
			temp+=charSet.charAt((int)shifted.indexOf(ch));
		}
		return temp;
	}
}
