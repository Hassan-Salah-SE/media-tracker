# Media Tracker

Authors: Hassan Salah

## Project idea
A console program for keeping track of movies, shows and anime I want to
watch or have watched. It calculates how much watch time is left and
lets me mark episodes as watched.

## Superclass
- Name: `Media`
- Common fields (private, accessed through getters): title, genre, rating
- The constructor validates the values and throws IllegalArgumentException
  if the title is empty or the rating is outside 0-10.
- Methods overridden by the subclasses: `showInfo()`, `getRuntimeMinutes()`

## Subclasses

1. `Movie`
    - Extra field: lengthMinutes
    - `getRuntimeMinutes()`: returns lengthMinutes
    - `showInfo()`: prints title, genre and the length as hours and minutes

2. `Show`
    - Extra fields: seasons, episodesPerSeason, episodeLength, episodesWatched
    - `getRuntimeMinutes()`: seasons * episodesPerSeason * episodeLength
    - `showInfo()`: prints title, genre, seasons and episodes watched

3. `Anime`
    - Extra fields: totalEpisodes, fillerEpisodes, episodeLength, episodesWatched
    - `getRuntimeMinutes()`: (totalEpisodes - fillerEpisodes) * episodeLength
    - `showInfo()`: prints title, genre, number of filler episodes and how
      many minutes are saved by skipping filler
   
both Anime and Show implement EpisodeTrackable

## Interface
- Name: `EpisodeTrackable`
- Method: `markEpisodeWatched()`
- Implemented by: `Show`, `Anime` (movies have no episodes, so `Movie`
  does not implement it)

## Menu
1. Add media
2. Show all
3. Search by title
4. Remove media
5. Total hours left to watch
6. Mark episode as watched
0. Exit

## Error scenarios
- Empty title when creating media (validated in the `Media` constructor,
  throws `IllegalArgumentException`)
- Rating outside the allowed range (over 10 or below 0)
- Filler episodes greater than total episodes in `Anime`
- User types letters or an empty answer where a number is expected in
  the menu (caught with try/catch so the program doesn't crash)

## Motivation
