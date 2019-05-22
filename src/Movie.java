import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.text.ParseException;
import java.util.Locale;
import java.util.Date;


public class Movie {
    private String title;
    private String description;
    private String director;
    private String releaseYear;
    public Genres genre;
    public Calendar rentalDate;
    public Calendar returnDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Genres getGenre() {
        return genre;
    }

    public void setGenre(Genres genre) {
        this.genre = genre;
    }

    public Calendar getRentalDate() {
        return rentalDate;
    }


    public void setRentalDate(Calendar rentalDate) throws ParseException {
        //SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        this.rentalDate = rentalDate;

    }

    public Calendar getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Calendar returnDate) {
        this.returnDate = returnDate;
    }

    public Movie() {
        rentalDate = Calendar.getInstance();
        returnDate = Calendar.getInstance();
    }

    public Movie(String title, String description, String director, String releaseYear, Genres genre) {
        this.title = title;
        this.description = description;
        this.director = director;
        this.releaseYear = releaseYear;
        this.genre = genre;
    }

    @Override
    public String toString() {

        if(rentalDate==returnDate)
        {
            return"Title: " + title + "\nGenre: " + genre + "\nDirector: " + director + "\nRelease Year: " + releaseYear + "\nDescription: " + description +"\n";
        }
        else
        {

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            String date1 = sdf.format(rentalDate.getTime());
            String date2 = sdf.format(returnDate.getTime());

            return"Title: " + title + "\nGenre: " + genre + "\nDirector: " + director + "\nRelease Year: " + releaseYear + "\nDescription: " + description +"\nData wypożyczenia " + date1  + "\nData oddania: "+date2;
        }
    }
}
