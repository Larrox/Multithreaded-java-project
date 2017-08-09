package hairSalon;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Hairdresser implements Runnable {
	Working working;
	String name;
	BlockingQueue<Customer> queue;
	InteractionHashMap smallTalks;
	
	public Hairdresser(String name, BlockingQueue<Customer> queue, Working working, InteractionHashMap smallTalks) {
		this.working = working;
		this.queue = queue;
		this.name = name;
		this.smallTalks = smallTalks;
	}
	
	@Override
	public void run() {
		while (working.shouldIWork()) {
			try {
				cut(queue.poll(5, TimeUnit.SECONDS));
			} catch (InterruptedException e) {
				System.out.println(name + " error.");
			}
		}
		System.out.println("\t\t\t\t" + name + " is going home.");
	}
	
	private  void cut(Customer c) {
		if (c != null) {
			System.out.println("\t" + name + ": \"Hello, " + c.getName() + "!" +
			smallTalks.getASmallTalk(c.getName()) + "\"");
			System.out.println("\t\t" + name + " is cutting " + c.getName() + ".");
			
			try {
				Thread.sleep(c.getHairLength());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\t\t\t" + name + " has finished cutting " + c.getName() + ".");
		}
	}
}
