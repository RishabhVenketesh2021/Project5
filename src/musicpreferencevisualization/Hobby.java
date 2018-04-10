package musicpreferencevisualization;

public class Hobby {
    public static int[] total;
    public static int[][] heard;
    public static int[][] liked;
    public static int[][] remove;
    // two matrixes in which rows are songs and columns are types of hobbies


    public Hobby(int[][] SongArray) {
        heard = new int[SongArray.length][4];
        liked = new int[SongArray.length][4];
        total = new int[4];
        remove = new int[SongArray.length][4];
    }


    public static void update(Person p) {
        if (p.getHobbyIndex() != -1) {
            total[p.getHobbyIndex()] = total[p.getHobbyIndex()] + 1;

            for (int i = 0; i < heard.length; i++) {
                if (p.hasAnswered(i)) {
                    if (p.hasHeard(i)) {
                        heard[i][p.getHobbyIndex()] = heard[i][p
                            .getHobbyIndex()] + 1;
                    }
                    if (p.hasLiked(i)) {
                        liked[i][p.getHobbyIndex()] = liked[i][p
                            .getHobbyIndex()] + 1;
                    }
                }
                else {
                    remove[i][p.getHobbyIndex()]++;
                }
            }

        }
    }


    public static int getIndex(String category) {

        if (category.equals("reading")) {
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
            return -1;
        }
    }
}
