package com.example.movielistxml.model

data class ListItem(
    val id: Int,
    val name: String,
    val rating: Double,
    val description: String,
    val imageResName: String,
    val link: String
)

// Hardcoded data
val listItems = listOf(
    ListItem(
        1, "Toy Story", 8.3,
        "A cowboy doll is profoundly threatened and jealous when a new spaceman action figure supplants him as top toy in a boy's bedroom.",
        "pixar1",
        "https://www.imdb.com/title/tt0114709/?ref_=ls_t_1"
    ),
    ListItem(
        2, "A Bug's Life", 7.2,
        "A misfit ant, looking for \"warriors\" to save his colony from greedy grasshoppers, recruits a group of bugs that turn out to be an inept circus troupe.",
        "pixar2",
        "https://www.imdb.com/title/tt0120623/?ref_=ls_t_2"
    ),
    ListItem(
        3, "Toy Story 2", 7.9,
        "When Woody is stolen by a toy collector, Buzz and his friends set out on a rescue mission to save Woody before he becomes a museum toy.",
        "pixar3",
        "https://www.imdb.com/title/tt0120363/?ref_=ls_t_3"
    ),
    ListItem(
        4, "Monster's Inc", 8.1,
        "In order to power the city, monsters have to scare children so that they scream. However, the children are toxic to the monsters...",
        "pixar4",
        "https://www.imdb.com/title/tt0198781/?ref_=ls_t_4"
    ),
    ListItem(
        5, "Finding Nemo", 8.2,
        "After his son is captured in the Great Barrier Reef and taken to Sydney, a timid clownfish sets out on a journey to bring him home.",
        "pixar5",
        "https://www.imdb.com/title/tt0266543/?ref_=ls_t_5"
    ),
    ListItem(
        6, "The Incredibles", 8.0,
        "While trying to lead a quiet suburban life, a family of undercover superheroes are forced into action to save the world.",
        "pixar6",
        "https://www.imdb.com/title/tt0317705/?ref_=ls_t_6"
    ),
    ListItem(
        7, "Cars", 7.3,
        "On the way to the biggest race of his life, a hotshot rookie race car gets stranded in a rundown town.",
        "pixar7",
        "https://www.imdb.com/title/tt0317219/?ref_=ls_t_7"
    ),
    ListItem(
        8, "Ratatouille", 8.1,
        "A rat who can cook makes an unusual alliance with a young kitchen worker at a famous Paris restaurant.",
        "pixar8",
        "https://www.imdb.com/title/tt0382932/?ref_=ls_t_8"
    ),
    ListItem(
        9, "WALL-E", 8.4,
        "A robot responsible for cleaning a waste-covered Earth meets another robot and falls in love with her.",
        "pixar9",
        "https://www.imdb.com/title/tt0910970/?ref_=ls_t_9"
    ),
    ListItem(
        10, "Up", 8.3,
        "78-year-old Carl Fredricksen travels to South America in his house equipped with balloons, inadvertently taking a young stowaway.",
        "pixar10",
        "https://www.imdb.com/title/tt1049413/?ref_=ls_t_10"
    )
)
