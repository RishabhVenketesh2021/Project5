package musicpreferencevisualization;

import java.util.LinkedList;
@SuppressWarnings("unused")
public class SorterBackEnd {
    private Hobby hobby;
    private Major major;
    private Region region;
    private DataCollector dataCollector;
    private LinkedList<Song> songList;


    public SorterBackEnd() {
        dataCollector = new DataCollector("SongListTest1",
            "MusicSurveyDataTest1.csv");
        dataCollector.createPeople();
        int[][] songArray = new int[dataCollector.getNumSongs()][4];
        hobby = new Hobby(songArray);
        major = new Major(songArray);
        region = new Region(songArray);
    }


    public void sortSongs(String representation) {
        dataCollector.fillSongs(representation);
    }

    public void output() {
        //format text file output
    }

    public LinkedList<Song> getSongList() {
        return songList;
    }
}
