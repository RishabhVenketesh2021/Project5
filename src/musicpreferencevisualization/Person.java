package musicpreferencevisualization;

public class Person {
    private int hobbyIndex;
    private int majorIndex;
    private int regionIndex;
    private int[] answers;


    public Person(
        int HobbyIndex,
        int MajorIndex,
        int RegionIndex,
        int[] Answers) {
        hobbyIndex = HobbyIndex;
        majorIndex = MajorIndex;
        regionIndex = RegionIndex;
        answers = Answers;
    }


    public int getHobbyIndex() {
        return hobbyIndex;
    }


    public int getMajorIndex() {
        return majorIndex;
    }


    public int getRegionIndex() {
        return regionIndex;
    }


    public boolean hasHeard(int i) { 
        return answers[2 * (i)] == 1;
    }

    
    public boolean hasAnswered(int i) {
        return answers[2 * (i)] != -1 && answers[2 * (i) + 1] != -1;
    }

    public boolean hasLiked(int i) { 
        return answers[2 * (i) + 1] == 1;
    }
}
