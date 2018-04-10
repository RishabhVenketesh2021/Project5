package musicpreferencevisualization;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataCollector {
    private String musicInputFilename;
    private String surveyInputFilename;
    private LinkedListSortable<Song> songList;
    private LinkedListSortable<Person> personList;
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
        songList = new LinkedListSortable<Song>();
        personList = new LinkedListSortable<Person>();
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
//                String[] personParams = splitCommas(temp, numSongs*2+5);
                String[] personParams = temp.split(",", -1);
//                String[] personParams = new String[numSongs*2+5];
//                for(int k = 0; k < personParams.length; k++) {
//                    if (k<holder.length) {
//                        personParams[k] = holder[k];
//                    }
//                    else {
//                        personParams[k] = "";
//                    }
//                    
//                }
                
                int[] answers = new int[2*numSongs];
                for (int i = 5; i < personParams.length; i++) {
                    if (personParams[i].equals("Yes")) {
                        answers[i-5] = 1;
                    }
                    else if (personParams[i].equals("No")) {
                        answers[i-5] = 0;
                    }
                    else if(personParams[i].equals("")) {
                        answers[i-5] = -1;
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


//    private String[] splitCommas(String input, int sizeArray) {
//        int beg = 0;
//        int end = 0;int count = 0;
//        String[] retArray = new String[sizeArray];
//        for(int i = 0; i<input.length(); i++) {
//            if(input.charAt(i)==',') {
//                end = i-1;
//                retArray[count] = input.substring(beg, end+1);
//                count++;
//                beg = i+1;
//            }
//        }
//        return null;
//    }
    private void fillHobby() {
        for (int i = 0; i < numPeople; i++) {
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
            songList.get(i).setHeardAndLike(representation);
        }
    }


    public LinkedListSortable<Song> getSongList() {
        return songList;
    }


    public LinkedListSortable<Person> getPersonList() {
        return personList;
    }


    public int getNumSongs() {
        return numSongs;
    }


    public int getNumPeople() {
        return numPeople;
    }

}
