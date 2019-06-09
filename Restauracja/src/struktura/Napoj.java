package struktura;

public class Napoj extends Zamowienie
{
	Napoj(String n, float c, int s, int m, float p)
	{
		super(n, c, s, m);
		pojemnosc=p;
	}
	
	

	float pojemnosc;
	
}
