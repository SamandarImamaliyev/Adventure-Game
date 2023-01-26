package adventureGame;

import java.util.Scanner;

public class Player {
	private Inventory inventory;
	private String name;
	private String character;
	private int damage;
	private int healthyness;
	private int permanentHealthyness;
	private int money;
	boolean choosenId = false;
	Scanner sc = new Scanner(System.in);

	public Player(String name) {
		this.name = name;
		this.inventory = new Inventory();
	}

	public void selectCharacter() {
		boolean b = true;
		while (!choosenId) {
			showMenu();
			while (b) {

				try {
					System.out.print("Insert the row number of the warrior which you want to choose: ");
					int id = sc.nextInt();
					switch (id) {
					case 1:
						initPlayer("Samurai", 5, 21, 15);
						b = false;
						break;
					case 2:
						initPlayer("Archer", 7, 18, 20);
						b = false;
						break;
					case 3:
						initPlayer("Knight", 8, 24, 5);
						b = false;
						break;
					case 4:
						initPlayer("Slinger", 10, 20, 10);
						b = false;
						break;
					default:
						System.out.println("Wrong number !");
					}
				} catch (Exception ex) {
					sc.next();
					System.out.println();
					System.out.println("Wrong symbol !");
				}
			}

		}

	}

	public void showMenu() {
		System.out.println();
		System.out.println("Character List: ");
		System.out.println("1. Samurai --> \t damage=5 \t healtyness=21 \t money=15 \n"
				+ "2. Archer --> \t damage=7 \t healtyness=18 \t money=20 \n"
				+ "3. Knight --> \t damage=8 \t healtyness=24 \t money=5 \n"
				+ "4. Slinger --> \t damage=10 \t healtyness=20 \t money=10");

	}

	private void initPlayer(String characterName, int damage, int healthyness, int money) {
		setCharacter(characterName);
		setDamage(damage);
		setHealthyness(healthyness);
		setMoney(money);
		setPermanentHealthyness(healthyness);
		System.out.println(this.toString());
		choosenId = true;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealthyness() {
		return healthyness;
	}

	public void setHealthyness(int healthyness) {
		this.healthyness = healthyness;
	}

	public int getPermanentHealthyness() {
		return permanentHealthyness;
	}

	public void setPermanentHealthyness(int permanentHealthyness) {
		this.permanentHealthyness = permanentHealthyness;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "\nPlayer name: " + getName() + "\nYour character: " + getCharacter() + " --> " + " damage: "
				+ getDamage() + ", " + " healthyness: " + getHealthyness() + ", " + " money: " + getMoney();
	}

}
