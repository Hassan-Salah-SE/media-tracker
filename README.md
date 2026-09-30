# Media Tracker

Authors: Hassan Salah

## Project idea
A console program for keeping track of movies, shows and anime I want to
watch or have watched. It calculates how much watch time is left and
lets me mark episodes as watched.

## Superclass
- Name: `Media`
- Common fields: title, genre, rating
- Common methods:
    - `showInfo()` – prints the information about the media
    - `getRuntimeMinutes()` – returns the total watch time in minutes
      (means the same thing in every subclass)

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

## Interface
- Name: `EpisodeTrackable`
- Method: `markEpisodeWatched()`
- Implemented by: `Show`, `Anime` (movies have no episodes, so `Movie`
  does not implement it)

## Menu
1. Add media
2. Remove media
3. Search by title
4. Show total hours left to watch
5. Mark an episode as watched

## Error scenarios
- Empty title when creating media (validated in the `Media` constructor,
  throws `IllegalArgumentException`)
- Rating outside the allowed range (over 10 or below 0)
- Filler episodes greater than total episodes in `Anime`
- User types letters or an empty answer where a number is expected in
  the menu (caught with try/catch so the program doesn't crash)

## Motivation
