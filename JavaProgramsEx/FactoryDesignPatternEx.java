package JavaProgramsEx;


interface Product{
	
	void display();
}


class ProductA implements Product{
	
	@Override
	public void display() {

		System.out.println("Product A Display Method");
	}
	
}

class ProductB implements Product{

	@Override
	public void display() {
		
		System.out.println("Product B Display Method");
		
	}
	
}	

interface Factory{
	
	Product factoryMethod();
}

class FactoryA implements Factory {
	
	@Override
	public Product factoryMethod() {
		return new ProductA();
	}
}
	
class FactoryB implements Factory {
	
	@Override
	public Product factoryMethod() {
		return new ProductB();
	}
}	



public class FactoryDesignPatternEx {

	public static void main(String[] args) {
		
		
		FactoryA factoryA = new FactoryA();
		
		Product factoryMethod = factoryA.factoryMethod();
		
		factoryMethod.display();
		
		
		FactoryB factoryB = new FactoryB();
		
		Product factoryMethod2 = factoryB.factoryMethod();
		
		factoryMethod2.display();

	}

}
