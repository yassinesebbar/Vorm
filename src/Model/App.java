package Model;

public class App {

    private FileHandler fileHander;

    public  App() {
        fileHander = new FileHandler();
    }

    public String[] getData(){
        return fileHander.readFile();
    }

}
