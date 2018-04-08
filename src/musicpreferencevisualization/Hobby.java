package musicpreferencevisualization;

public class Hobby {
    public static int[] total;
    public static int[][] heard;
    public static int[][] liked;
    // two matrixes in which rows are songs and columns are types of hobbies


    public Hobby(int[][] SongArray) {
        heard = SongArray;
        liked = SongArray;
    }


    public static void update(Person p) {
        for (int i = 0; i < heard.length; i++) {
            total[p.getHobbyIndex()] = total[p.getHobbyIndex()] + 1;
            if (p.hasHeard(i)) {
                heard[i][p.getHobbyIndex()] = heard[i][p.getHobbyIndex()] + 1;
            }
            if (p.hasLiked(i)) {
                liked[i][p.getHobbyIndex()] = liked[i][p.getHobbyIndex()] + 1;
            }
        }
    }


    public static int getIndex(String category) {
        if (category.equals("read")) {
            return 0;
        }
        else if (category.equals("art")) {
            return 1;
        }
        else if (category.equals("sports")) {
            return 2;
        }
        else if (category.equals("music")) {
            return 3;
        }
        else {
            throw new IllegalArgumentException(
                "Not a valid type of hobby - refer to user specs");
        }
    }
}
