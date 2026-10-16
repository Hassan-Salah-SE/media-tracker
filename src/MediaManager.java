import java.util.ArrayList;


public class MediaManager {
    private ArrayList<Media> library = new ArrayList<>();

    public void addMedia (Media media) {
        library.add(media);
    }

    public void showAll() {
        if (library.isEmpty()) {
            System.out.println("The library is empty!");
            return;
        }

        for (int i = 0; i < library.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.println(library.get(i).getInfo());
        }
    }


    public boolean isEmpty() {
        return library.isEmpty();
    }

    public void searchByTitle(String text) {
        boolean found = false;
        for (Media m: library) {
            if(m.getTitle().toLowerCase().contains(text.toLowerCase())){
                found = true;
                System.out.println(m.getInfo());
            }
        }
        if (!found) {
            System.out.println("No media found with this title.");
        }
    }

    public void removeMedia(int number) {
        if ((number <1) || (number > library.size())) {
            throw new IllegalArgumentException("The number must be between 1 and "+ library.size());
        }
        library.remove(number -1);

    }
    public void markEpisodeWatched(int number) {
        if ((number<1) || (number> library.size())){
            throw new IllegalArgumentException("The number must be between 1 and "+ library.size());
        }
        Media item = library.get(number -1);
        if (item instanceof EpisodeTrackable tracker) {
            tracker.markEpisodeWatched();
            System.out.println("Episode marked as watched");
        } else {
            throw new IllegalArgumentException("This media has no episodes to mark.");
        }
    }


        public int getRemainingRuntimeMinutes() {
        int total = 0;
        for (int i = 0; i < library.size(); i++) {
            total = total + library.get(i).getRemainingMinutes();
        }
        return total;
    }

}
