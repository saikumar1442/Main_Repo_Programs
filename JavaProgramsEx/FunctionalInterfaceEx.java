package examples.lambda;

public interface FunctionalInterfaceEx {

	void apply();

	default void find() {

		System.out.println("calling the default method ....");

	}

	static void finding() {
		
		System.out.println("calling the static method....");
	}
}
