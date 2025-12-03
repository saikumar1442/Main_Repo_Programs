package examples.lambda;

import java.util.ArrayList;

public class Lambda implements FunctionalInterfaceEx{

	public static void main(String[] args) {
		
//		FunctionalInterfaceEx fi = () -> System.out.println("calling the ZERO parameter"); 
//
//		FunctionalInterfaceEx.finding(); 
//		fi.find();
//		fi.apply();
//		
//		FunctionalInterface2 fi2 = (x, y) -> x + y;
//		
//		System.out.print(fi2.add(2, 8));
//		
//		
//		ArrayList<Integer> arrayList = new ArrayList<>();
//		
//		arrayList.add(1);
//		arrayList.add(2);
//		arrayList.add(3);
//		arrayList.add(4);
//		
//		arrayList.forEach(n -> System.out.println("arrayList values :: "+n));
//		
//		arrayList.forEach(n -> {
//			if(n%2 ==0)
//				System.out.println("Even Numbers : "+n);
//		});
		
		FunctionalInterfaceEx fi = new Lambda();
		fi.apply();
		
		FunctionalInterfaceEx fii = new InterfaceImpl();
		fii.apply();
	}

	@Override
	public void apply() {
		System.out.println("calling the apply method....");
		
	}

}
