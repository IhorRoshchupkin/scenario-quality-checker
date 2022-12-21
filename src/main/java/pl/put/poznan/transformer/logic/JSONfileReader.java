package pl.put.poznan.transformer.logic;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Klasa do otczytania pliku w formacie JSON oraz konwertowania w String
 *
 */
public class JSONfileReader
{
    /**
     * Funkcja do odczytywania pliku o wskazanym folderze
     * @param filename  nazwa pliku
     * @return          plik w formacie JSON
     */
    private File getFileFromResources(String filename)
    {
        ClassLoader classLoader = getClass().getClassLoader();

        URL resource = classLoader.getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException("File is not found!");
        } else {
            return new File(resource.getFile());
        }
    }

    /**
     * Funkcja do konwertowania JSON w String
     * @param filename nazwa pliku
     * @return         scenariusz w formacie String
     */
    public String toString(String filename)
    {
        File jar1 = new File(JSONfileReader.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        File jar2 = new File(JSONfileReader.class.getProtectionDomain().getCodeSource().getLocation().getPath());

        File jarDir = new File(JSONfileReader.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        jar1 = new File(jarDir.getParent());
        jar2 = new File(jar1.getParent());
        String java = jar2.getParent();
        java = java.replace("file:\\","");


        java = java+"\\"+filename+".json";
        System.out.print(java);
        
        
        String content = "";
        try {
            content = new String ( Files.readAllBytes( Paths.get(filepath.replaceAll("!",""))));

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
