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

import co.easydanger.coffeeShop.entity.User;

public class UserFile {

	private static Path filePath = Paths.get("users.txt");

	public static List<String> toList(List<User> uList) {
		List<String> lines = new ArrayList<>();
		for (User item : uList) {
			String[] parts = { item.getName(), item.getFname(), item.getLname(), item.getEmail(), item.getPhone(),
					item.getPword() };
			lines.add(parts[0] + "~~~" + parts[1] + "~~~" + parts[2] + "~~~" + parts[3] + "~~~" + parts[4] + "~~~"
					+ parts[5]);
		}
		return lines;
	}

	public static void fileExist() throws IOException {
		if (Files.notExists(filePath)) {
			Files.createFile(filePath);
		}
	}

	public static List<User> read() throws IOException {
		try {
			List<String> lines = Files.readAllLines(filePath);
			List<User> users = new ArrayList<>();
			for (String line : lines) {
				String[] parts = line.split("~~~");
				User us = new User();
				us.setName(parts[0]);
				us.setFname(parts[1]);
				us.setLname(parts[2]);
				us.setEmail(parts[3]);
				us.setPhone(parts[4]);
				us.setPword(parts[5]);
				users.add(us);

			}
			return users;
		} catch (NoSuchFileException ex) {
			return new ArrayList<>();
		} catch (IOException ex) {
			ex.printStackTrace();
			return new ArrayList<>();
		}
	}

	public static void writeApp(User us) throws IOException {
		fileExist();
		String line = us.getName() + "~~~" + us.getFname() + "~~~" + us.getLname() + "~~~" + us.getEmail() + "~~~" + us.getPhone() + "~~~" + us.getPword();
		List<String> linesToAdd = Arrays.asList(line);
		Files.write(filePath, linesToAdd, StandardOpenOption.APPEND);
	}

	public static void writeTrun(List<User> usList) throws IOException {
		fileExist();
		List<String> linesToAdd = toList(usList);
		Files.write(filePath, linesToAdd, StandardOpenOption.TRUNCATE_EXISTING);
	}
}
