
public class Anime extends Media implements EpisodeTrackable {
    private int totalEpisodes;
    private int fillerEpisodes;
    private int episodeLength;
    private int episodesWatched;

    public Anime (String title, String genre, double rating, int totalEpisodes, int fillerEpisodes,
                  int episodeLength) {
        super(title, genre, rating);

        if (totalEpisodes <= 0) {
            throw new IllegalArgumentException("The number of episodes should be greater than 0 but is " + totalEpisodes);
        }
        if (fillerEpisodes > totalEpisodes) {
            throw new IllegalArgumentException("Filler episodes (" + fillerEpisodes
                    + ") cannot be greater than total episodes (" + totalEpisodes + ")");
        }
        if (fillerEpisodes < 0) {
            throw new IllegalArgumentException("Filler episodes can not be negative but is " + fillerEpisodes);
        }
        if (episodeLength <= 0) {
            throw new IllegalArgumentException("The length of the episode must be longer than 0 and can't be " + episodeLength);
        }

        this.totalEpisodes = totalEpisodes;
        this.fillerEpisodes = fillerEpisodes;
        this.episodeLength = episodeLength;
        this.episodesWatched = 0;
    }
        @Override
        public int getRuntimeMinutes() {
            return (totalEpisodes - fillerEpisodes) * episodeLength;
        }

        @Override
        public void showInfo() {
            System.out.println(getTitle()+ " (" + getGenre() + "), rating: " + getRating()+ ", total episodes: " +
                    totalEpisodes+ ", filler episodes: "+ fillerEpisodes + ", episodes watched: " + episodesWatched);
        }

        @Override
        public void markEpisodeWatched() {
        if (episodesWatched == (totalEpisodes - fillerEpisodes)) {
            throw new IllegalStateException("You have watched all non-filler episodes!");
        }
        episodesWatched++;
        }



}
