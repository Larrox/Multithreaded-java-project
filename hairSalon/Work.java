package hairSalon;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Work {

	public static void main(String[] args) {

		int customersLimit = 10;
		
		Working working = new Working(true);
		
		BlockingQueue<Customer> customers = new LinkedBlockingQueue<Customer>();
		
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(
				6, 
				6, 
				1L, 
				TimeUnit.SECONDS, 
				new LinkedBlockingQueue<Runnable>());
		
		InteractionHashMap smallTalks = new InteractionHashMap();
		
		CustomerCreator cc = new CustomerCreator(customers, customersLimit, working);
		
		Runnable[] runnables = new Runnable[6];
		runnables[0] = new Hairdresser("Irka",customers, working, smallTalks);
		runnables[1] = new Hairdresser("Mirka", customers, working, smallTalks);
		runnables[2] = new Hairdresser("Eliza", customers, working, smallTalks);
		runnables[3] = new Hairdresser("Andzela", customers, working, smallTalks);
		runnables[4] = new Hairdresser("Buazej", customers, working, smallTalks);
		runnables[5] = cc;
		
		for (Runnable runnable : runnables)
			tpe.execute(runnable);
		
		
		while (tpe.getActiveCount() != 0){}
		tpe.shutdown();
		
		System.out.println("\nWe're done for today. Please come back tomorrow!");
	}

}
