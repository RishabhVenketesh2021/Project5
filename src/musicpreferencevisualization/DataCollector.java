package musicpreferencevisualization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class DataCollector {
    private String musicInputFilename;
    private String surveyInputFilename;
    private LinkedList<Song> songList;
    private LinkedList<Person> personList;
    private int numSongs;
    private int numPeople;


    public DataCollector(String musicinputfile, String surveyinputfile) {
        this.musicInputFilename = musicinputfile;
        this.surveyInputFilename = surveyinputfile;
    }


    @SuppressWarnings("resource")
    public void createPeople() {
        File musicInputFile = new File(musicInputFilename);
        File surveyInputFile = new File(surveyInputFilename);
        songList = new LinkedList<Song>();
        personList = new LinkedList<Person>();
        try {
            Scanner musicInputStream = new Scanner(musicInputFile);
            Scanner surveyInputStream = new Scanner(surveyInputFile);
            String temp = musicInputStream.nextLine();
            int index = 0;
            while (musicInputStream.hasNextLine()) {
                temp = musicInputStream.nextLine();
                String[] songParams = temp.split(",");
                Song newSong = new Song(songParams[1], songParams[0],
                    songParams[3], Integer.parseInt(songParams[2]), index);
                index++;
                songList.add(newSong);
                numSongs++;
            }
            temp = surveyInputStream.nextLine();
            while (surveyInputStream.hasNextLine()) {
                temp = surveyInputStream.nextLine();
                String[] personParams = temp.split(",");
                int[] answers = new int[personParams.length - 5];
                for (int i = 5; i < personParams.length; i++) {
                    if (personParams[i].equals("Yes")) {
                        answers[i] = 1;
                    }
                    else if (personParams[i].equals("No")) {
                        answers[i] = 0;
                    }
                    else {
                        throw new IllegalArgumentException("Invalid entry");
                    }
                }
                Person newPerson = new Person(Hobby.getIndex(personParams[4]),
                    Major.getIndex(personParams[2]), Region.getIndex(
                        personParams[3]), answers);
                personList.add(newPerson);
                numPeople++;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private void fillHobby() {
        for (int i = 0; i < personList.size(); i++) {
            Hobby.update(personList.get(i));
        }
    }


    private void fillMajor() {
        for (int i = 0; i < personList.size(); i++) {
            Major.update(personList.get(i));
        }
    }


    private void fillRegion() {
        for (int i = 0; i < personList.size(); i++) {
            Region.update(personList.get(i));
        }
    }


    public void fillSongs(String representation) {
        fillHobby();
        fillMajor();
        fillRegion();
        for (int i = 0; i < songList.size(); i++) {
            Song temp = songList.get(i);
            temp.setHeardAndLike(representation);
            songList.set(i, temp);
        }
    }


    public LinkedList<Song> getSongList() {
        return songList;
    }


    public LinkedList<Person> getPersonList() {
        return personList;
    }


    public int getNumSongs() {
        return numSongs;
    }


    public int getNumPeople() {
        return numPeople;
    }

}
