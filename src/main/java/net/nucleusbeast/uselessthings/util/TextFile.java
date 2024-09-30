package net.nucleusbeast.uselessthings.util;

import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.impl.game.minecraft.MinecraftGameProvider;
import net.nucleusbeast.uselessthings.UselessThings;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextFile {

    public TextFile() {
        super();
    }

    private static final Path path = Paths.get(FabricLoader.getInstance().getGameDir().toFile() + "/config/useless-text.txt");

    public static List<String> Load(){
        if (path.toFile().exists()){

            try (Stream<String> lines = Files.lines( path ))
            {
                //filterring comments
                List<String> filtered = lines.filter(s -> !s.contains("#") && !s.isEmpty()).collect(Collectors.toList());
                return filtered;
            }
            catch (IOException e)
            {
                UselessThings.LOGGER.info(e.toString());
                e.printStackTrace();
                return null;
            }
        }
        else{
            if (Create()){
                return Load();
            }else{
                Throwable e = new Throwable("File not found and could not be created!");
                return null;
            }
        }
    }

    public static boolean Create(){
        try {
            Files.createDirectories(path.getParent());
            Files.createFile(path);
        }catch (Exception e){
            UselessThings.LOGGER.info(e.toString());
            e.printStackTrace();
            return false;
        }
        try {
            FileWriter myWriter = new FileWriter(path.toString());
            //write initial lines
            myWriter.write("#This is a comment\n");
            myWriter.write("#Every line represents a random massage!\n");
            myWriter.write("\n");
            myWriter.write("Hello you there\n");
            myWriter.write("Ethereal is the best!\n");
            myWriter.write("\n");
            myWriter.write("#This is how u get player name\n");
            myWriter.write("%player% is the best player ever\n");
            myWriter.write("\n");
            myWriter.write("I love u!\n");
            myWriter.write("Just saying hello to %player% and hoping you are having a great day!\n");
            myWriter.write("Its really nice having you hold me!\n");
            myWriter.write("\n");
            myWriter.write("\n");
            myWriter.write("#Feel free to add as many lines as u want. This is useless anyway!\n");
            myWriter.write("#NOTE: for any changes to take effect you need to restart client!!\n");
            myWriter.write("#IMPORTANT: Mod curently doesn't support special characters\n");
            myWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            UselessThings.LOGGER.info(e.toString());
            e.printStackTrace();
            return false;
        }
    }

}
