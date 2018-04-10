package musicpreferencevisualization;

import java.awt.Color;
import CS2114.Window;
import CS2114.Button;
import CS2114.Shape;
import CS2114.TextShape;
import CS2114.WindowSide;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 * This Class will create the window and the graphs within the window.
 * 
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
     * 
     * @param songFilename
     *            song csv filename is needed
     * @param surveyFilename
     *            survey data csv is needed.
     */

    VisualWindow(String songFilename, String surveyFilename) {
        program = new SorterBackEnd(songFilename, surveyFilename);
        program.sortSongs("Hobby", "Title");
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
        window.setSize(1000, 520);
        addGraph(program.getSongList());
        
        
        
    }


    public void addGraph(LinkedListSortable<Song> songList) {
        for (int i = 0; i < songList.size(); i++) {
            if ((i+1) % 9 == 1) {
                makeGraph(12, 8, songList.get(i));
            }
            else if ((i+1) % 9 == 2) {
                makeGraph(300,8,songList.get(i));
            }
            else if ((i+1) % 9 == 3) {
                makeGraph(550,8,songList.get(i));
            }
            else if ((i +1) % 9 == 4) {
                makeGraph(12,160,songList.get(i));
            }
            else if ((i+1 )% 9 == 5) {
                makeGraph(300,160,songList.get(i));
            }
            else if ((i+1) % 9 == 6) {
                makeGraph(570,160,songList.get(i));
            }
            else if ((i+1) % 9 == 7) {
                makeGraph(12,312,songList.get(i));
            }
            else if ((i+1) % 9 == 8) {
                makeGraph(300,312,songList.get(i));
            }
            else if ((i+1) % 9 == 0) {
                makeGraph(570,312,songList.get(i));
            }
        }      
        
        
    }


    /**
     * makes the graphs per each song and displays them in the proper spot.
     * 
     * @param xposition
     * 
     * @param yposition
     * @return
     */
    private void makeGraph(int x, int y, Song song) {

        TextShape line1 = new TextShape(x, y, song.getTitle());
        line1.setBackgroundColor(Color.WHITE);
        TextShape line2 = new TextShape(x+line1.getWidth()/4, y + 15, song.getName());
        line2.setBackgroundColor(Color.WHITE);
        Shape blackBar = new Shape(x+(line1.getWidth()/2)-8, y + 30, 8, 52, Color.BLACK);
        Shape magBar = new Shape(x, y + 30, line1.getWidth(), 13, Color.MAGENTA);
        Shape bluBar = new Shape(x,y+43,line1.getWidth(),13,Color.BLUE);
        Shape oraBar = new Shape(x,y+56,line1.getWidth(),13,Color.ORANGE);
        Shape greBar = new Shape(x,y+69,line1.getWidth(),13,Color.GREEN);
        
        
        window.addShape(blackBar);
        window.addShape(magBar);
        window.addShape(bluBar);
        window.addShape(oraBar);
        window.addShape(greBar);
        window.addShape(line1);
        window.addShape(line2);

    }
}
