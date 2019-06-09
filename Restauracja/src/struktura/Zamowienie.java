package struktura;

public abstract class Zamowienie
{
	String nazwa;
	float cena;
	int status;
	int stolik=0;
	int miejsce=0;
	
	Zamowienie(String n, int s, int m)
	{
		nazwa=n;
		status=0;
		cena=0;
		stolik=s;
		miejsce=m;
	}
	
	Zamowienie(String n, float c, int s, int m)
	{
		nazwa=n;
		status=0;
		cena=c;
		stolik=s;
		miejsce=m;
	}
	
	public String getNazwa() {return nazwa;}
	
	public void setNazwa(String n)
	{
		nazwa=n;
	}
	
	public float getCena() {return cena;}
	
	public int getStatus() {return status;}
	
	public void setStatus(int i)
	{
		status=i;
	}
	
	public void setMiejsce(int s, int m)
	{
		stolik=s;
		miejsce=m;
	}
	
	public int getMiejsce()
	{
		return miejsce;
	}
	
	public int getStolik()
	{
		return stolik;
	}
}