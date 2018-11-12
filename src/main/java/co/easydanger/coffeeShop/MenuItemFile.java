package co.easydanger.coffeeShop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//methods to deal with writing to and reading from the text file.
public class MenuItemFile {

	private static Path filePath = Paths.get("Inventory.txt");

	public static List<String> toList(List<MenuItem> pList) {
		List<String> lines = new ArrayList<>();
		for (MenuItem item : pList) {
			String[] parts = { item.getName(), Double.toString(item.getPrice()), item.getDescription(),
					item.getClass().getName() };
			lines.add(parts[0] + "~~~" + parts[1] + "~~~" + parts[2] + "~~~" + parts[3]);
		}
		return lines;
	}

	public static void fileExist() throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
	}

	public static List<MenuItem> read() throws IOException {
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<MenuItem> menu = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("~~~");
				if (parts[3].equalsIgnoreCase("Coffee")) {
					MenuItem mi = new Coffee();
					mi.setName(parts[0]);
					mi.setPrice(Double.parseDouble(parts[1]));
					mi.setDescription(parts[2]);
					menu.add(mi);
				} else {
					MenuItem mi = new MenuItem();
					mi.setName(parts[0]);
					mi.setPrice(Double.parseDouble(parts[1]));
					mi.setDescription(parts[2]);
					menu.add(mi);
				}
			}
			return menu;
		} catch (NoSuchFileException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	public static void writeApp(MenuItem mi) throws IOException {
		fileExist();
		String line = mi.getName() + "~~~" + Double.toString(mi.getPrice()) + "~~~" + mi.getDescription() + "~~~"
				+ mi.getClass().getName();
		List<String> linesToAdd = Arrays.asList(line);
		Files.write(filePath, linesToAdd, StandardOpenOption.APPEND);
	}

	public static void writeTrun(List<MenuItem> miList) throws IOException {
		fileExist();
		List<String> linesToAdd = toList(miList);
		Files.write(filePath, linesToAdd, StandardOpenOption.TRUNCATE_EXISTING);
	}
}
