package JavaProgramsEx;

public class SingletonEx {
	
	private SingletonEx() {}   // private Constructor
	
	private static SingletonEx instance = null ;
	
	private static SingletonEx getInstance() {
		
		if(instance == null) {
			
			instance = new SingletonEx();
		}
		
		return instance;
	}

	public void getMessage() {
		
		
		System.out.println("This is the singleton Instance");
	}
	
	public static void main(String[] args) {
	

		SingletonEx instance2 = SingletonEx.getInstance();
		
		instance2.getMessage();
	}

}
