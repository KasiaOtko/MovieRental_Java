import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountSystem {
    private List<Client> AccountsList;

    public List<Client> getAccountsList() {
        return AccountsList;
    }

    public void setAccountsList(List<Client> accountsList) {
        AccountsList = accountsList;
    }

    public AccountSystem()
    {
        AccountsList = new ArrayList<Client>();
    }

    public void AddAccount(Client c)
    {
        AccountsList.add(c);
    }

    public boolean IfExist(String nrL)
    {
        for(Client n : AccountsList)
        {
            if (n.login == nrL)
                return true;
        }
        return false;
    }

    public void DeleteAccount(Client c)
    {
        AccountsList.remove(c);
    }

    public Client CheckLoginPassword(String l, String p)
    {
        for(Client c : AccountsList)
        {
            if (c.login == l && c.password == p)
            {
                return c;
            }
        }
        return null;
    }
    public void EnterChanges(Client c, List<Movie> l)
    {
        Client client = c;
        c.rentalMoviesList = l;
    }

    public void PenaltyCharging(Client c) {
        Date now = new Date();
        for (Movie m:c.rentalMoviesList) {
            if (m.returnDate.getTime() < now.getTime()) {
                int days = now.getDay() - m.returnDate.getDay();
                c.penalty = days * 1;
            }
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(Client c : AccountsList)
        {
            sb.append(c.toString());
        }
        return sb.toString();
    }

    public static void SaveXML(String FileName, AccountSystem s) throws IOException {
        FileOutputStream fos = new FileOutputStream(FileName);
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            @Override
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :"+e.toString());
            }
        });
        encoder.writeObject(s);
        encoder.close();
        fos.close();
    }

    public static Object ReadXML(String FileName) throws IOException {
        FileInputStream fis = new FileInputStream(FileName);
        XMLDecoder decoder = new XMLDecoder(fis);
        Object decodedSettings = (Object) decoder.readObject();
        decoder.close();
        fis.close();
        return decodedSettings;
    }




}
