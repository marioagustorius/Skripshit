package components;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TextReader{
    
    public String directory;

    public TextReader() {
        
    }
    
    public TextReader(String directory) {
        this.directory = directory;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String textReader() throws IOException{
        String input="";
        Path path = Paths.get(getDirectory());
        DirectoryStream<Path> directoryStream = null;
        if (Files.isDirectory(path)) {
            directoryStream = Files.newDirectoryStream(path);
        } else {
            System.out.printf("%s does not exist%n", path);
        }

        for (Path p : directoryStream) {
            Scanner sc = new Scanner(new FileReader(p.toString()));
            while (sc.hasNext()) {
                input = input + sc.next() + " ";
            }
        }
        return input;
    }
} 
