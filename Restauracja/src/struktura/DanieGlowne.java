package struktura;

public class DanieGlowne extends Zamowienie
{
	public DanieGlowne(String n, float c, int s, int m)
	{
		super(n, c, s, m);

	}
	
	public DanieGlowne(String n, float c, int s, int m, String su, float suc, String d, float dc)
	{
		super(n, c+suc+dc, s, m);
		surowka=su;
		dodatki=d;

	}
	String surowka;
	String dodatki;

}
