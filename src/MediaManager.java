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
            library.get(i).showInfo();
        }
    }

    public int getTotalRuntimeMinutes() {
        int total = 0;
        for (int i=0; i<library.size(); i++) {
            total = total + library.get(i).getRuntimeMinutes();
        }
        return total;
    }

    public void searchByTitle(String text) {
        boolean found = false;
        for (Media m: library) {
            if(m.getTitle().toLowerCase().contains(text.toLowerCase())){
                found = true;
                m.showInfo();
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

}
