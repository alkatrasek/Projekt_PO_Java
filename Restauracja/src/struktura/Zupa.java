package struktura;

public class Zupa extends Zamowienie
{
	public Zupa(String n, float c, int s, int m)
	{
		super(n, c, s, m);
	}
	
	public Zupa(String n, float c, int s, int m, String d, float dc)
	{
		super(n, c+dc, s, m);
		dodatki=d;
	}
	

	String dodatki;

}
