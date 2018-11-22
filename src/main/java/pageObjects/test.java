package pageObjects;

public class test {

	public static void main(String[] args) {
		boolean r1=false, r2=true,r3=true,r4=false;
		
		System.out.println("before R1" + r1);
		r1=r2&&r3&&r4;
		System.out.println("after R1" + r1);

	}

}
