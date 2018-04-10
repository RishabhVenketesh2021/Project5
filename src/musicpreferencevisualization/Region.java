package musicpreferencevisualization;

public class Region {
    public static int[] total;
    public static int[][] heard;
    public static int[][] liked;
    // two matrixes in which rows are songs and columns are types of regions


    public Region(int[][] SongArray) {
        heard = new int[SongArray.length][4];
        liked = new int[SongArray.length][4];
        total = new int[4];
    }


    public static void update(Person p) {
        if(p.getRegionIndex()!=-1) {
            if(p.hasAnswered()) {
                total[p.getRegionIndex()] = total[p.getRegionIndex()] + 1;
            }
            for (int i = 0; i < heard.length; i++) {
                if (p.hasHeard(i)) {
                    heard[i][p.getRegionIndex()] = heard[i][p.getRegionIndex()] + 1;
                }
                if (p.hasLiked(i)) {
                    liked[i][p.getRegionIndex()] = liked[i][p.getRegionIndex()] + 1;
                }
            }
        }
    }


    public static int getIndex(String category) {
        if (category.equals("Northeast")) {
            return 0;
        }
        else if (category.equals("Southeast")) {
            return 1;
        }
        else if (category.equals("United States (other than Southeast or Northwest)")) {
            return 2;
        }
        else if (category.equals("Outside of United States")) {
            return 3;
        }
        else {
            return -1;
        }
    }
}
