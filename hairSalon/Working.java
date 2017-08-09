package hairSalon;

public class Working {
	
	Boolean working;
	
	public Working(Boolean w)
	{
		working = w;
	}
	
	void setWorking(Boolean w)
	{
		working = w;
	}
	public synchronized Boolean shouldIWork()
	{
		return working;
	}
}
