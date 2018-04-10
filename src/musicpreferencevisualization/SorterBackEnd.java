package musicpreferencevisualization;

import java.io.*;

@SuppressWarnings("unused")
public class SorterBackEnd {
    private Hobby hobby;
    private Major major;
    private Region region;
    private DataCollector dataCollector;
    private LinkedListSortable<Song> songList;


    public SorterBackEnd(String songFilename, String surveyFilename) {
        dataCollector = new DataCollector(songFilename,
            surveyFilename);
        dataCollector.createPeople();
        int[][] songArray = new int[dataCollector.getNumSongs()][4];
        hobby = new Hobby(songArray);
        major = new Major(songArray);
        region = new Region(songArray);
    }


    public void sortSongs(String representation, String sortType) {
        dataCollector.fillSongs(representation);
        songList = dataCollector.getSongList();
        songList.sort(sortType);
        output(representation);
    }


    public void output(String representation) {
        songList.output(representation);
    }


    public LinkedListSortable<Song> getSongList() {
        return songList;
    }
    
}
