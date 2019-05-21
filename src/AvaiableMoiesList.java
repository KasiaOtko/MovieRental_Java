import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.time.LocalDateTime;
import java.util.Date;
//import Client;
//import Movie;


class AvaiableMoviesList {


    private String Name;
    private List<Movie> MovieList;

    public String getName() {
        return Name;
    }


    public List<Movie> getMovieList() {
        return MovieList;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setMovieList(List<Movie> movieList) {
        MovieList = movieList;
    }


    public AvaiableMoviesList()
    {
        MovieList = new ArrayList<Movie>();
    }

    public AvaiableMoviesList(String n)
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
        m.rentalDate.add(Calendar.MONTH,1);
    }

    public void ReturnMovie(Client c, Movie m)
    {
        c.rentalMoviesList.remove(m);
        MovieList.add(m);
    }

    public void Prolong(Movie m)
    {
        m.returnDate.add(Calendar.MONTH,1);
    }

    public List<Movie> GenresSearch(List<Movie> lm, Genres g)
    {
        List<Movie> newList = new ArrayList<Movie>();
        for(Movie m : lm)
        {
            if (m.genre == g)
            {
                newList.add(m);
            }
        }
        return newList;
    }

    public static void SaveXML(String FileName, AvaiableMoviesList l) throws IOException
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
        sb.append("Movies from : " + Name);
        for (Movie m : MovieList)
        {
            sb.append(m.toString());
        }
        return sb.toString();
    }


}
