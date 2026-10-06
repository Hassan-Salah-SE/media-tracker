// Movie is a subclass of Media. It adds a length in minutes.

public class Movie extends Media {
    private int lengthMinutes;

    public Movie (String title, String genre, double rating, int lengthMinutes) {

        super (title, genre, rating);

        if (lengthMinutes <= 0) {
            throw new IllegalArgumentException("The length of the movie can not be " + lengthMinutes);
        }
        this.lengthMinutes = lengthMinutes;
    }

    @Override
    public int getRuntimeMinutes () {
        return lengthMinutes;
    }

    @Override
     public void showInfo () {
        System.out.println(getTitle()+ " (" + getGenre()+"), rating: "+ getRating()+ ", length: " +
                lengthMinutes / 60 + "h, " + lengthMinutes % 60 + "min");
    }

}
