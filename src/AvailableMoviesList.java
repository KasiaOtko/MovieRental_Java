import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;

public class AvailableMoviesList {
    private String Name;
    private ArrayList<Movie> MovieList;

    public String getName() {
        return Name;
    }


    public List<Movie> getMovieList() {
        return MovieList;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        MovieList = movieList;
    }


    public AvailableMoviesList()
    {
        MovieList = new ArrayList<Movie>();
    }

    public AvailableMoviesList(String n)
    {
        this.Name = n;
    }

    public void AddMovie(Movie m)
    {
        MovieList.add(m);
    }

    public void RentingMovie(Client c, Movie m)
    {
        c.rentalMoviesList.add(m);
        MovieList.remove(m);
        m.rentalDate = Calendar.getInstance();
        //Formatting rentalDate
        //DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
        //DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //String date = dateFormat.format(m.rentalDate);
       // try {
       //     m.rentalDate = new SimpleDateFormat("dd-MM-yyyy").parse(date);
       // } catch (ParseException e) {
       //     e.printStackTrace();
        //}

        //String rentalDate_
        m.returnDate=Calendar.getInstance();
        m.returnDate.add(Calendar.MONTH, 1);



    }

    public void ReturnMovie(Client c, Movie m)
    {
        c.rentalMoviesList.remove(m);
        MovieList.add(m);
    }

    public void Prolong(Movie m)
    {
        //Calendar cal = Calendar.getInstance();
        m.returnDate.add(Calendar.MONTH, 1);
    }

    public ArrayList<Movie> GenresSearch(ArrayList<Movie> lm, Genres g)
    {
        ArrayList<Movie> newList = new ArrayList<Movie>();
        for(Movie m : lm)
        {
            if (m.genre == g)
            {
                newList.add(m);
            }
        }
        return newList;
    }

    public static void SaveXML(String FileName, AvailableMoviesList l) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(FileName);
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            @Override
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :"+e.toString());
            }
        });
        encoder.writeObject(l);
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

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Movies: \n" );
        for (Movie m : MovieList)
        {
            sb.append(m.toString());
        }
        return sb.toString();
    }





}
