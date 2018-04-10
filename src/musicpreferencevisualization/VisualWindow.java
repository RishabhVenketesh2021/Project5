package musicpreferencevisualization;

import java.awt.Color;
import CS2114.Window;
import CS2114.Button;
import CS2114.Shape;
import CS2114.WindowSide;

/**
 * This Class will create the window and the graphs within the window.
 * @author Jerin M (jerinm)
 * @version 1.0
 *
 */

public class VisualWindow {
    /**
     * the backend sorter class
     */
    private SorterBackEnd program;
    
    /**
     * window eveything is displayed in
     */
    private Window window;
    
    /**
     * creates main window and calls the backend as needed
     * @param songFilename
     *          song csv filename is needed
     * @param surveyFilename
     *          survey data csv is needed. 
     */
    

    VisualWindow(String songFilename, String surveyFilename) {
       // program = new SorterBackEnd(songFilename, surveyFilename);
       // program.sortSongs("Hobby", "Title");
        window = new Window();
        Button hobby = new Button("Represent Hobby");
        Button major = new Button("Represent Major");
        Button region = new Button("Represent Region");
        Button quit = new Button("Quit");
        window.addButton(hobby, WindowSide.SOUTH);
        window.addButton(major, WindowSide.SOUTH);
        window.addButton(region, WindowSide.SOUTH);
        window.addButton(quit, WindowSide.SOUTH);
        Button prev = new Button("<-- Prev");
        Button name = new Button("Sort by Artist Name");
        Button title = new Button("Sort by Song Title");
        Button year = new Button("Sort by Release Year");
        Button genre = new Button("Sort by Genre");
        Button next = new Button("Next -->");
        window.addButton(prev, WindowSide.NORTH);
        window.addButton(name, WindowSide.NORTH);
        window.addButton(title, WindowSide.NORTH);
        window.addButton(year, WindowSide.NORTH);
        window.addButton(genre, WindowSide.NORTH);
        window.addButton(next, WindowSide.NORTH);
        window.setSize(1000, 600);
        
    }


    public void addGraph(LinkedListSortable<Song> songList, int index2Start) {
        for (int i = 0; i < songList.size(); i++) {
            if(i%9 == 1)
            {
                
            }
            else if(i%9 == 2)
            {
                
            }
            else if(i%9 == 3)
            {
                
            }
            else if(i%9 == 4)
            {
                
            }
            else if(i%9 == 5)
            {
                
            }
            else if(i%9 == 6)
            {
                
            }
            else if(i%9 == 7)
            {
                
            }
            else if(i%9 == 8)
            {
                
            }
            else if(i%9 == 0)
            {
                
            }
        }
    }
    
    /**
     * makes the graphs per each song and displays them in the propper spot. 
     * 
     * @param xposition
     *      
     * @param yposition
     * @return
     */
    private void makeGraph(int xposition, int yposition, Song song)
    {
        Shape blackRect = new Shape()
    }
}
