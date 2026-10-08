import java.util.Scanner;

public class Menu {
    private MediaManager manager = new MediaManager();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("1. Add media");
            System.out.println("2. Show all");
            System.out.println("3. Search by title");
            System.out.println("4. Remove media");
            System.out.println("5. Total hours left to watch");
            System.out.println("6. Mark episode as watched");
            System.out.println("0. Exit");
            System.out.println("Choose: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addMediaFromInput();
                    break;
                case "2":
                    manager.showAll();
                    break;
                case "3":
                    searchMedia();
                    break;
                case "4":
                    removeMedia();
                    break;
                case "5":
                    showTotalTime();
                    break;
                case "6":
                    markWatched();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    public void addMediaFromInput() {
        System.out.println("Type 1 for Movie, 2 for Show, 3 for Anime");
        String type = scanner.nextLine();

        try{
            System.out.println("Title: ");
            String title = scanner.nextLine();
            System.out.println("Genre: ");
            String genre = scanner.nextLine();
            System.out.println("Rating(1-10): ");
            double rating = Double.valueOf(scanner.nextLine());

            if(type.equals("1")){
                System.out.println("Length in minutes: ");
                int length = Integer.valueOf(scanner.nextLine());
                manager.addMedia(new Movie(title, genre, rating, length));
            } else if (type.equals("2")) {
                System.out.println("Number of seasons: ");
                int seasons = Integer.valueOf(scanner.nextLine());
                System.out.println("Number of episodes per season: ");
                int episodes = Integer.valueOf(scanner.nextLine());
                System.out.println("Episodes length: ");
                int epLength = Integer.valueOf(scanner.nextLine());
                manager.addMedia(new Show(title, genre, rating, seasons, episodes, epLength));
            } else if (type.equals("3")) {
                System.out.println("Total episodes: ");
                int total = Integer.valueOf(scanner.nextLine());
                System.out.println("Total filler episodes: ");
                int filler = Integer.valueOf(scanner.nextLine());
                System.out.println("Episodes length: ");
                int length = Integer.valueOf(scanner.nextLine());
                manager.addMedia(new Anime(title, genre, rating, total, filler, length));
            } else {
                System.out.println("Invalid type!");
                return;
            }  System.out.println("Added.");
        } catch (NumberFormatException e) {
                System.out.println("Please type a valid number.");
        }  catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
        }

    }

    public void searchMedia() {
        System.out.println("Search for: ");
        String text = scanner.nextLine();
        manager.searchByTitle(text);
    }

    public void showTotalTime(){
        int min = manager.getTotalRuntimeMinutes();
        System.out.println("Total: " + min/60 + "h " + min%60 +"min");
    }
    public void removeMedia(){
        manager.showAll();
        System.out.println("Number to remove: ");
        try {
            int number = Integer.valueOf(scanner.nextLine());
            manager.removeMedia(number);
            System.out.println("Removed.");
        } catch (NumberFormatException e) {
            System.out.println("Please type a number.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    public void markWatched() {
        manager.showAll();
        System.out.println("Number to mark ");
        try {
            int number = Integer.valueOf(scanner.nextLine());
            manager.markEpisodeWatched(number);
        } catch (NumberFormatException e) {
            System.out.println("Please type a number");

        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
        }

    }
}
