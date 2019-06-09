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
	
	String getNazwa() {return nazwa;}
	
	void setNazwa(String n)
	{
		nazwa=n;
	}
	
	float getCena() {return cena;}
	
	int getStatus() {return status;}
	
	void setStatus(int i)
	{
		status=i;
	}
	
	void setMijsce(int s, int m)
	{
		stolik=s;
		miejsce=m;
	}
	
	int getMijsce()
	{
		return miejsce;
	}
	
	int getStolik()
	{
		return stolik;
	}
}