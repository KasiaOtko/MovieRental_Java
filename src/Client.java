import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
    public String login;
    public String password;
    private String repeatPassword;
    public List<Movie> rentalMoviesList;

    public double penalty;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public List<Movie> getRentalMoviesList() {
        return rentalMoviesList;
    }

    public void setRentalMoviesList(List<Movie> rentalMoviesList) {
        this.rentalMoviesList = rentalMoviesList;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public Client() {}

    public Client(String name, String surname, String telNumber, String mail, String login, String password) {
        super(name, surname, telNumber, mail);
        this.login = login;
        this.password = password;
        rentalMoviesList = new ArrayList<Movie>();
        this.penalty = 0;
    }




}
