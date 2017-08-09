package hairSalon;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class CustomerCreator implements Runnable {
	BlockingQueue<Customer> customers;
	int customersLimit;
	int customersWelcomed;
	Working working;
	String[] names;
	
	public CustomerCreator(BlockingQueue<Customer> customers, int customersLimit, Working working) {
		this.customers = customers;
		this.customersLimit = customersLimit;
		this.customersWelcomed = 0;
		this.working = working;
		
		names = new String[20];
		
		names[0] = "Mirek";
		names[1] = "Jarek";
		names[2] = "Lukasz";
		names[3] = "Stefan";
		names[4] = "Karol";
		names[5] = "Marcin";
		names[6] = "Afrodyta";
		names[7] = "Linda";
		names[8] = "Alfons";
		names[9] = "Bozydar";
		names[10] = "Gertruda";
		names[11] = "Sambor";
		names[12] = "Kasjusz";
		names[13] = "Betty";
		names[14] = "Kamila";
		names[15] = "Aurelia";
		names[16] = "Ada";
		names[17] = "Tomasz";
		names[18] = "Bartosz";
		names[19] = "Szymon";
	}
	
	public void run()
	{
		Random rand = new Random();
		while (customersWelcomed < customersLimit) {
			try {
				Thread.sleep(rand.nextInt(1000));
				Customer c = new Customer(names[rand.nextInt(20)], rand.nextInt(4000)+1000);
				System.out.println(c.getName() + " has visited our hair salon.");
				customers.put(c);
				customersWelcomed++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while (!customers.isEmpty()){}
		working.setWorking(false);
	}

	public int getCustomersLimit() {
		return customersLimit;
	}

	public int getCustomersWelcomed() {
		return customersWelcomed;
	}
	
}
