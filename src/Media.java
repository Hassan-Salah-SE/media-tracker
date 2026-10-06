public class Media {
    private String title;
    private String genre;
    private double rating;


    public Media (String title, String genre, double rating) {

        if ((title == null)  || (title.isBlank())) {
            throw new IllegalArgumentException ("Title cannot be empty");
        }
        if (rating < 0 || rating > 10) {
        throw new IllegalArgumentException("Rating must be between 0 and 10, but was " + rating);
         }
        this.title = title;
        this.genre = genre;
        this.rating = rating;

    }
        public String getTitle() {

        return this.title;
        }

        public String getGenre() {

        return this.genre;
        }
        public double getRating() {

        return this.rating;
        }

        public void showInfo () {

        System.out.println(title + " (" + genre + "), rating: " + rating);
        }

        public int getRuntimeMinutes () {

        return 0;
        }



}