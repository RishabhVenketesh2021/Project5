package musicpreferencevisualization;

/**
 * 
 * The Song class stories all relevant information about a song. Each song will
 * be stored as a song object.
 * These songs can than be called upon for information and storied in an List.
 * 
 * @author Jonathan ljon15
 * @version 1.0
 * 
 */
public class Song {
    // ~~~~~~~~~~~ Fields ~~~~~~~~~~~~~~~
    private String name;
    private String title;
    private String genre;
    private int releaseYear;
    private int[] heard;
    private int[] liked;
    private int[] total;
    private int index;


    // ~~~~~~~~~~~~~~~~~~ Constructor ~~~~~~~~~~~~~~~~~~~~~
    public Song(
        String Name,
        String Title,
        String Genre,
        int ReleaseYear,
        int Index) {
        name = Name;
        title = Title;
        genre = Genre;
        releaseYear = ReleaseYear;
        index = Index;
    }


    // ~~~~~~~~~~~~~~~~~~~ Methods ~~~~~~~~~~~~~~~~~~~~~~~~~
    public int compareTo(Song other, String type) {
        if (type == "Name") {
            return name.compareTo(other.name);
        }
        else if (type == "Title") {
            return title.compareTo(other.title);
        }
        else if (type == "Year") {
            return releaseYear - other.releaseYear;
        }
        else if (type == "Genre") {
            return genre.compareTo(other.genre);
        }
        else {
            throw new IllegalArgumentException(
                "Not a valid type of comparsion - refer to user specs");
        }
    }


    /**
     * Getter method that returns the name of the band
     * 
     * @return name - band's name - is a string
     */
    public String getName() {
        return name;
    }


    /**
     * Getter method that returns the title of the song
     * 
     * @return title - is a string
     */
    public String getTitle() {
        return title;
    }


    /**
     * Getter method that returns the song's genre.
     * 
     * @return genre - genre the song falls under - is a string
     */
    public String getGenre() {
        return genre;
    }


    /**
     * Getter method that returns the year the song was released.
     * 
     * @return releaseYear - year the song was released - is an int
     */
    public int getReleaseYear() {
        return releaseYear;
    }


    /**
     * Getter method that returns the index of the song in the list
     * 
     * @return index - is an int - location of song
     */
    public int getIndex() {
        return index;
    }


    /**
     * 
     * 
     * @param representation
     */
    public void setHeardAndLike(String representation) {
        if (representation == "Hobby") {
            heard = Hobby.heard[index];
            liked = Hobby.liked[index];
            total = Hobby.total;
        }
        else if (representation == "Major") {
            heard = Major.heard[index];
            liked = Major.liked[index];
            total = Major.total;
        }
        else if (representation == "Region") {
            heard = Region.heard[index];
            liked = Region.liked[index];
            total = Region.total;
        }
        else {
            throw new IllegalArgumentException(
                "Not a valid category to represent - refer to user specs");
        }
    }


    /**
     * Getter method to return the amount of times the song has been heard by major
     * 
     * @return heard - is an int - 
     */
    public int[] getHeard() {
        return heard;
    }


    /**
     * Getter method to return the amount of times the song has been liked by major.
     * 
     * @return liked - is an int - likes for the song by major
     */
    public int[] getLiked() {
        return liked;
    }


    /**
     * Getter method to returns the grand total for each major. Used to find
     * percentage
     * 
     * @return total - is an int - grand total of people in the major 
     */
    public int[] getTotal() {
        return total;
    }
}
