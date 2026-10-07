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


}
