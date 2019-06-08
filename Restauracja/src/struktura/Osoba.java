package struktura;




import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Osoba
{
	int stolik;
	int miejsce;
	ObservableList<Zamowienie> zamowienia= FXCollections.observableArrayList();
	
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
