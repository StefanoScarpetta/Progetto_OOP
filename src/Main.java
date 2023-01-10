import Classi.Gestione;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("src/StandardInput/StandardInput.txt");
        Scanner in = new Scanner(file);
        List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()), StandardCharsets.UTF_8);
        Gestione gestione = new Gestione(lines);

        

        // Creare funzioni task e stampare

    }
}