package hairSalon;

import java.util.concurrent.ConcurrentHashMap;

public class InteractionHashMap {
	private ConcurrentHashMap<String, String> interactions = new ConcurrentHashMap<>();
	
	public InteractionHashMap() {
		interactions.put("Mirek", "What's up?");
		interactions.put("Jarek", "Have you cured your stomach problems?");
		interactions.put("Karol", "Looking good!");
		interactions.put("Afrodyta", "Nice to see you again!");
		interactions.put("Bozydar", "Oh, you got fatter again.");
		interactions.put("Sambor", "I met your moter last week.");
		interactions.put("Betty", "New shoes?");
		interactions.put("Kamila", "I told you not to come back! Ok, it's last time I cut you.");
		interactions.put("Ada", "Buongiorno!");
		
	}
	
	public String getASmallTalk(String key)
	{

		if (interactions.containsKey(key))
			return " " + interactions.get(key);
		else
			return "";
	}
}
