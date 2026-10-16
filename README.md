# Media Tracker

Authors: Hassan Salah

## Project idea
A console program for keeping track of movies, shows and anime I want to
watch or have watched. It calculates how much watch time is left and
lets me mark episodes as watched.

## Superclass
- Name: Media
- Common fields (private, accessed through getters): title, genre, rating
- The constructor validates the values and throws IllegalArgumentException
  if the title is empty or the rating is outside 0-10.
- Methods overridden by the subclasses: showInfo(), getRuntimeMinutes()
- getRemainingMinutes() returns getRuntimeMinutes() by default and is
    overridden by Show and Anime, which track watched episodes.

## Subclasses

1. Movie
    - Extra field: lengthMinutes
    - getRuntimeMinutes(): returns lengthMinutes
    - showInfo(): prints title, genre, rating and the length as hours and minutes

2. Show (implements EpisodeTrackable)
    - Extra fields: seasons, episodesPerSeason, episodeLength, episodesWatched
    - getRuntimeMinutes(): seasons * episodesPerSeason * episodeLength
    - getRemainingMinutes(): (total episodes - episodesWatched) * episodeLength
    - markEpisodeWatched(): increases episodesWatched by one
    - showInfo(): prints title, genre, rating, seasons and episodes watched
      out of the total number of episodes

3. Anime (implements EpisodeTrackable)
    - Extra fields: totalEpisodes, fillerEpisodes, episodeLength, episodesWatched
    - getRuntimeMinutes(): (totalEpisodes - fillerEpisodes) * episodeLength
    - getRemainingMinutes(): (totalEpisodes - fillerEpisodes - episodesWatched) * episodeLength
    - markEpisodeWatched(): increases episodesWatched by one
    - showInfo(): prints title, genre, rating, total episodes, filler
      episodes and episodes watched

## Interface
- Name: EpisodeTrackable
- Method: markEpisodeWatched()
- Implemented by: Show, Anime (movies have no episodes, so Movie
  does not implement it)
- Used polymorphism in MediaManager.markEpisodeWatched(): the object is
    taken from the list as a Media and checked with instanceof EpisodeTrackable.
    If it implements the interface, markEpisodeWatched() is called, and the
    correct version runs for Show or Anime.

## Menu
1. Add media
2. Show all
3. Search by title
4. Remove media
5. Total hours left to watch
6. Mark episode as watched
0. Exit

Menu handles the menu flow and user input. It prints the options, reads input with 
Scanner in a while loop, uses a switch statement to pick the action and calls MediaManager
to do the actual work.

Main creates a Menu and starts the program.

## MediaManager
 Holds the ArrayList<Media> library and contains the logic
for adding, removing, searching by title and calculating the remaining
watch time.

## Error scenarios
- Empty title when creating media (validated in the Media constructor,
  throws `IllegalArgumentException`)
- Rating outside the allowed range (over 10 or below 0)
- Filler episodes greater than total episodes in Anime
- User types letters or an empty answer where a number is expected in
  the menu (caught with try/catch so the program doesn't crash)
- Removing a media number outside the list (`IllegalArgumentException`)
- Marking an episode on a `Movie`, which has no episodes
  (`IllegalArgumentException`)
- Marking an episode when everything is already watched
  (`IllegalStateException`)

## Motivation


- Validation in the constructors: I put the checks (empty title, rating
  outside 0-10, filler episodes greater than total episodes) in the constructors
  instead of in the menu. The effect is that an invalid object can never be
  created
- A separate interface for episodes: I made EpisodeTrackable an interface
  that only Show and Anime implement, instead of putting
  markEpisodeWatched() in Media. A movie has no episodes, so it would get a
  method that makes no sense. MediaManager can use
  instanceof to check if something can be marked, and a new type with
  episodes can be added by implementing the same interface.
- Logic in MediaManager, interaction in Menu: The list, the searching and 
 the calculation of remaining time are in MediaManager, and Menu reads input and calls it. 
 It is clear where to look when something is wrong. A limitation is that 
 The domain classes still print some output themselves, so the logic is still not fully independent of the console:
 updated Show, Anime and Movie to return text with getInfo() instead of printing but MediaManager still prints.
- Filler is excluded from the runtime of Anime: I calculate runtime as
  (totalEpisodes - fillerEpisodes) * episodeLength, because the goal of the
  program is to show how much time I actually need to watch. The effect is that
  the total time left is more useful, but it also means filler episodes can
  never be counted as watched.
- The library disappears when the program closes. Saving to a file would need file 
handling and new error scenarios, which is a more difficult step.

