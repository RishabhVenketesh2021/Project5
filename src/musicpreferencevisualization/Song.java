package musicpreferencevisualization;

public class Song {
    private String name;
    private String title;
    private String genre;
    private int releaseYear;
    private int[] heard;
    private int[] liked;
    private int[] total;
    private int index;


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


    public String getName() {
        return name;
    }


    public String getTitle() {
        return title;
    }


    public String getGenre() {
        return genre;
    }


    public int getReleaseYear() {
        return releaseYear;
    }


    public int getIndex() {
        return index;
    }


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


    public int[] getHeard() {
        return heard;
    }


    public int[] getLiked() {
        return liked;
    }


    public int[] getTotal() {
        return total;
    }


    public int percentage(int a, int b) {
        if (b == 0) {
            return 0;
        }
        return (int)(100.00 * (double)a / (double)b);
    }
}
