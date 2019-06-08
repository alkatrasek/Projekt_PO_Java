package struktura;

public abstract class Zamowienie
{
	String nazwa;
	float cena;
	int status;
	
	Zamowienie(String n)
	{
		nazwa=n;
		status=0;
		cena=0;
	}
	
	Zamowienie(String n, float c)
	{
		nazwa=n;
		status=0;
		cena=c;
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
	
}