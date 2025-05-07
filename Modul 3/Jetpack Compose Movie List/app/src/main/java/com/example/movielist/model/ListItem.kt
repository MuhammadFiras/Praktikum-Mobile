package com.example.movielist.model

data class ListItem(
    val id: Int,
    val name: String,
    val rating: Double,
    val description: String,
    val imageResName: String, // just the drawable resource name, without extension
    val link: String
)

val listItems = listOf(
    ListItem(
        id = 1,
        name = "Toy Story",
        rating = 8.3,
        description = "A cowboy doll is profoundly threatened and jealous when a new spaceman action figure supplants him as top toy in a boy's bedroom.",
        imageResName = "pixar1",
        link = "https://www.imdb.com/title/tt0114709/?ref_=ls_t_1"
    ),
    ListItem(
        id = 2,
        name = "A Bug's Life",
        rating = 7.2,
        description = "A misfit ant, looking for 'warriors' to save his colony from greedy grasshoppers, recruits a group of bugs that turn out to be an inept circus troupe.",
        imageResName = "pixar2",
        link = "https://www.imdb.com/title/tt0120623/?ref_=ls_t_2"
    ),
    ListItem(
        id = 3,
        name = "Toy Story 2",
        rating = 7.9,
        description = "When Woody is stolen by a toy collector, Buzz and his friends set out on a rescue mission to save Woody before he becomes a museum toy property with his roundup gang Jessie, Prospector, and Bullseye.",
        imageResName = "pixar3",
        link = "https://www.imdb.com/title/tt0120363/?ref_=ls_t_3"
    ),
    ListItem(
        id = 4,
        name = "Monster's Inc",
        rating = 8.1,
        description = "In order to power the city, monsters have to scare children so that they scream. However, the children are toxic to the monsters, and after a child gets through, two monsters realize things may not be what they think.",
        imageResName = "pixar4",
        link = "https://www.imdb.com/title/tt0198781/?ref_=ls_t_4"
    ),
    ListItem(
        id = 5,
        name = "Finding Nemo",
        rating = 8.2,
        description = "After his son is captured in the Great Barrier Reef and taken to Sydney, a timid clownfish sets out on a journey to bring him home.",
        imageResName = "pixar5",
        link = "https://www.imdb.com/title/tt0266543/?ref_=ls_t_5"
    ),
    ListItem(
        id = 6,
        name = "The Incredibles",
        rating = 8.0,
        description = "While trying to lead a quiet suburban life, a family of undercover superheroes are forced into action to save the world.",
        imageResName = "pixar6",
        link = "https://www.imdb.com/title/tt0317705/?ref_=ls_t_6"
    ),
    ListItem(
        id = 7,
        name = "Cars",
        rating = 7.3,
        description = "On the way to the biggest race of his life, a hotshot rookie race car gets stranded in a rundown town and learns that winning isn't everything in life.",
        imageResName = "pixar7",
        link = "https://www.imdb.com/title/tt0317219/?ref_=ls_t_7"
    ),
    ListItem(
        id = 8,
        name = "Ratatouille",
        rating = 8.1,
        description = "A rat who can cook makes an unusual alliance with a young kitchen worker at a famous Paris restaurant.",
        imageResName = "pixar8",
        link = "https://www.imdb.com/title/tt0382932/?ref_=ls_t_8"
    ),
    ListItem(
        id = 9,
        name = "WALL-E",
        rating = 8.4,
        description = "A robot who is responsible for cleaning a waste-covered Earth meets another robot and falls in love with her. Together, they set out on a journey that will alter the fate of mankind.",
        imageResName = "pixar9",
        link = "https://www.imdb.com/title/tt0910970/?ref_=ls_t_9"
    ),
    ListItem(
        id = 10,
        name = "Up",
        rating = 8.3,
        description = "78-year-old Carl Fredricksen travels to South America in his house equipped with balloons, inadvertently taking a young stowaway.",
        imageResName = "pixar10",
        link = "https://www.imdb.com/title/tt1049413/?ref_=ls_t_10"
    )
)