package musicpreferencevisualization;

public class Major {
    public static int[] total;
    public static int[][] heard;
    public static int[][] liked;
    // two matrixes in which rows are songs and columns are types of majors


    public Major(int[][] SongArray) {
        heard = new int[SongArray.length][4];
        liked = new int[SongArray.length][4];
        total = new int[4];
    }


    public static void update(Person p) {
        if (p.getMajorIndex() != -1) {
            if (p.hasAnswered()) {
                total[p.getMajorIndex()] = total[p.getMajorIndex()] + 1;
            }
            for (int i = 0; i < heard.length; i++) {
                if (p.hasHeard(i)) {
                    heard[i][p.getMajorIndex()] = heard[i][p.getMajorIndex()]
                        + 1;
                }
                if (p.hasLiked(i)) {
                    liked[i][p.getMajorIndex()] = liked[i][p.getMajorIndex()]
                        + 1;
                }
            }
        }
    }


    public static int getIndex(String category) {
        if (category.equals("Computer Science")) {
            return 0;
        }
        else if (category.equals("Other Engineering")) {
            return 1;
        }
        else if (category.equals("Math or CMDA")) {
            return 2;
        }
        else if (category.equals("Other")) {
            return 3;
        }
        else {
            return -1;
        }
    }
}
