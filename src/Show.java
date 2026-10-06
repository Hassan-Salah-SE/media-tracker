public class Show extends Media{

    private int seasons;
    private int episodesPerSeason;
    private int episodeLength;
    private int episodesWatched;

    public Show (String title, String genre, double rating, int seasons, int episodesPerSeason, int episodeLength) {
        super (title, genre, rating);

        if (seasons <= 0) {
            throw new IllegalArgumentException("Seasons must be greater than 0 but they were " + seasons);
        }
        if (episodeLength <= 0) {
            throw new IllegalArgumentException("The length of the episode must be longer than 0 but it was " + episodeLength);

        }
        if (episodesPerSeason <= 0) {
            throw new IllegalArgumentException("The number of episodes per season should be higher than 0");
        }
        this.seasons = seasons;
        this.episodesPerSeason = episodesPerSeason;
        this.episodeLength = episodeLength;
        this.episodesWatched = 0;




    }

}
