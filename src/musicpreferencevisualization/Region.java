package musicpreferencevisualization;

public class Region {
    public static int[] total;
    public static int[][] heard;
    public static int[][] liked;
    // two matrixes in which rows are songs and columns are types of regions


    public Region(int[][] SongArray) {
        heard = SongArray;
        liked = SongArray;
    }


    public static void update(Person p) {
        for (int i = 0; i < heard.length; i++) {
            total[p.getRegionIndex()] = total[p.getRegionIndex()] + 1;
            if (p.hasHeard(i)) {
                heard[i][p.getRegionIndex()] = heard[i][p.getRegionIndex()] + 1;
            }
            if (p.hasLiked(i)) {
                liked[i][p.getRegionIndex()] = liked[i][p.getRegionIndex()] + 1;
            }
        }
    }


    public static int getIndex(String category) {
        if (category.equals("Southwest")) {
            return 0;
        }
        else if (category.equals("Southeast")) {
            return 1;
        }
        else if (category.equals("Northwest")) {
            return 2;
        }
        else if (category.equals("Northeast")) {
            return 3;
        }
        else {
            throw new IllegalArgumentException(
                "Not a valid type of Region - refer to user specs");
        }
    }
}
