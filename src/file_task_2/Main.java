package file_task_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {

	static String pathGames = "//home//scarp55//games//";
	static String dirSavegames = pathGames + "savegames//";
	static String zipSaves = pathGames + "savegames//saves.zip";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameProgress elf = new GameProgress("elf", 100, 100, 50, 100);
		GameProgress ork = new GameProgress("ork", 80, 120, 40, 150);
		GameProgress human = new GameProgress("human", 120, 80, 60, 120);
		saveGame(dirSavegames, elf);
		saveGame(dirSavegames, ork);
		saveGame(dirSavegames, human);
		File dir = new File(dirSavegames);
		List<File> list = new ArrayList<>();
		for (File file : dir.listFiles()) {
			if (file.isFile())
				list.add(file);
		}
		zipFiles(zipSaves, list);
		for (File file:list) {
			file.delete();
		}

	}

	public static void saveGame(String path, GameProgress player) {
		try (FileOutputStream fos = new FileOutputStream(path + player.getName() + ".dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(player);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void zipFiles(String pathZip, List<File> list) {
		try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(pathZip))) {
			for (File file : list) {
				try (FileInputStream fis = new FileInputStream(file.getAbsolutePath())) {
					ZipEntry entry = new ZipEntry(file.getName());
					zout.putNextEntry(entry);
					byte[] buffer = new byte[fis.available()];
					fis.read(buffer);
					zout.write(buffer);
					zout.closeEntry();
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}	
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}
