package adventureGame;

import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	boolean chooesenId = false;
	Scanner sc = new Scanner(System.in);

	public void login() {
		System.out.println("   WELCOME TO ADVENTURE GAME !   ");
		System.out.print("Before the start of the game enter your name: ");
		String name = sc.nextLine();
		player = new Player(name);
		player.selectCharacter();
		start();
	}

	public void start() {
		while (true) {
			showLocations();
			if (!location.getLocation()) {
				System.err.println("Game Over!");
				break;
			}
			if (player.getInventory().isFood() == true && player.getInventory().isFirewood() == true
					&& player.getInventory().isWater() == true && player.getInventory().isBanana() == true) {
				System.out.println("Congratulation , You won all prizes !!!");
				break;
			}
		}

	}

	public void showLocations() {
		boolean b = true;
		System.out.println();
		System.out.println("===================================================================");
		System.out.println();
		System.out.println("Areas: \n" + "1. Safe House --> You can full your healthy \n"
				+ "2. Cave --> You will come across zombies, and win food after defeat all enemies \n"
				+ "3. Forest --> You will come across vampires, and win firewood after defeat all enemies \n"
				+ "4. River --> You will come across bears, and win water after defeat all enemies \n"
				+ "5. Iceland --> You will come across king kong, and win banana after defeat all enemies \n"
				+ "6. Tool Store --> You can buy a weapon and an armor !");

		System.out.print("Insert the row number of the area which you want to go: ");
		while (b) {
			int loc;
			try {
				loc = sc.nextInt();
				while (loc < 1 || loc > 6) {
					System.out.print("Wrong number! Try again: ");
					loc = sc.nextInt();

				}
				switch (loc) {

				case 1:
					location = new SafeHouse(player);
					break;
				case 2:
					location = new Cave(player);
					break;
				case 3:
					location = new Forest(player);
					break;
				case 4:
					location = new River(player);
					break;
				case 5:
					location = new Iceland(player);
					break;
				case 6:
					location = new ToolStore(player);
					break;
				default:
					break;
				}
				b = false;
			} catch (Exception e) {
				sc.next();
				System.out.println("Wrong symbol! Try again: ");
			}
		}

	}
}
