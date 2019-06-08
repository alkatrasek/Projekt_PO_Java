package struktura;

import java.util.ArrayList;
import java.util.List;

public class Osoba
{
	int stolik;
	int miejsce;
	List<Zamowienie> zamowienia=new ArrayList<Zamowienie>();
	
	Osoba(int s, int m)
	{
		stolik=s;
		miejsce=m;
	}
	
	void dodajZamowienie(Zamowienie z)
	{
		zamowienia.add(z);
	}
	
	void przesadzka(Osoba o)
	{
		int s=o.miejsce;
		o.miejsce=miejsce;
		miejsce=s;
	}
	
	String sprawdz()
	{
		String s="";
		for(Zamowienie z : zamowienia)
		{
			if (z.getStatus()!=2) s+=z.getNazwa()+" ";
		}
		if (s=="") return "Wszystkie zamówienia zrealizowane";
		else return "Nie zrealizowa³eœ: "+s;
	}
}
