package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {

	public static void main(String[] args) {

		// Create an ExecutorService with a fixed thread pool of 5 threads
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		// Submit tasks to the executor service
		for (int i = 0; i < 10; i++) {
			executorService.submit(new Task(i));
		}

		// Shut down the executor service
		executorService.shutdown();
	}
}

class Task implements Runnable {
	private final int taskId;

	public Task(int taskId) {
		this.taskId = taskId;
	}

	@Override
	public void run() {
		System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());

	}

}


// Write a code for Immutable class

final class ImmutaClass{


	 private final String name;
	 private final int age;
	 
	 public ImmutaClass(String name, int age){
		this.name = name;
		this.age = age;
	 }
	 
	 public String getName(){
	 return name;
	 
	 }
	 
	 public int getAge(){
	 return age;
	 }

	}
