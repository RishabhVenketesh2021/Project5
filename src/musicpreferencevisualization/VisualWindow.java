package musicpreferencevisualization;

import CS2114.Button;
import CS2114.Window;
import CS2114.WindowSide;

public class VisualWindow {
    private SorterBackEnd program;
    private Window window;


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
        window.setSize(1000, 600);
    }
}
