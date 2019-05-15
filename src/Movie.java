import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Movie {
    private String title;
    private String description;
    private String director;
    private String releaseYear;
    public Genres genre;
    public Date rentalDate;
    public Date returnDate;

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

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) throws ParseException {
        //SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
        this.rentalDate = rentalDate;

    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Movie() {
        rentalDate = new Date(Long.MIN_VALUE);
        returnDate = new Date(Long.MIN_VALUE);
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
        return"Title: " + title + "\nGenre: " + genre + "\nDirector: " + director + "\nRelease Year: " + releaseYear + "\nDescription: " + description +"\n";
    }
}
