package adventureGame;

public class ToolStore extends NormalLocation {

	public ToolStore(Player player) {
		super(player, "Tool Store");

	}

	@Override
	public boolean getLocation() {
		boolean b = true;
		System.out.println();
		System.out.println("Now you are in the Tool Store !");
		System.out.println("1. Weapons \n" + "2. Armor \n" + "3. Exit");
		System.out.print("Do your choice: ");
		while (b) {
			try {
				int id = sc.nextInt();

				if (id > 0 && id < 4) {
					switch (id) {
					case 1:
						buyWeapon();
						break;
					case 2:
						buyArmor();
						break;
					default:
						break;
					}
					b = false;
				} else {
					System.out.println("Wrong number! Try again:  ");
				}
			} catch (Exception ex) {
				sc.next();
				System.out.println("Wrong symbol! Try again: ");
			}
		}

		return true;
	}

	public void showArmorMenu() {
		System.out.println();
		System.out.println("1. Light --> protection=1, \t price=15 \n" + "2. Medium --> protection=3, \t price=25 \n"
				+ "3. Heavy --> protection=5, \t price=40 \n" + "4. Exit");
	}

	public void buyArmor() {
		int a;
		boolean b = true;
		showArmorMenu();
		System.out.println("Money in your account: " + player.getMoney());
		System.out.print("Choose the armor which you want to buy: ");
		while (b) {
			try {
				a = sc.nextInt();
				if (a > 0 && a < 4) {
					switch (a) {
					case 1:
						selectArmor("Light", 1, 15);
						break;
					case 2:
						selectArmor("Medium", 3, 25);
						break;
					case 3:
						selectArmor("Heavy", 5, 40);
						break;
					default:
						break;
					}
					b = false;
				} else {
					System.out.println("Wrong number! Try again:  ");
				}
			} catch (Exception ex) {
				sc.next();
				System.out.println("Wrong symbol! Try again:  ");
			}
		}

	}

	public void selectArmor(String aName, int engelleme, int price) {
		int changeMoney;
		int totalHealtyness;
		changeMoney = player.getMoney() - price;
		totalHealtyness = player.getHealthyness() + engelleme;

		if (price > player.getMoney()) {
			System.out.println("You don't have enough money !");
			buyArmor();
		} else {
			player.setHealthyness(totalHealtyness);
			player.setMoney(changeMoney);
			System.out.println();
			System.out.println("**After buying an Armor**");
			System.out.println(player.toString() + "\nArmor you bought: " + aName);
		}

	}

	public void showWeaponMenu() {
		System.out.println();
		System.out.println("1. Gun --> damage=2, \t price=25 \n" + "2. Sword --> damage=3, \t price=35 \n"
				+ "3. Trifle --> damage=7,  price=45 \n" + "4. Exit");
	}

	public void buyWeapon() {
		int w;
		boolean b = true;

		showWeaponMenu();
		System.out.println("Money in your account: " + player.getMoney());
		System.out.print("Choose the weapon which you want to buy: ");
		while (b) {
			try {
				w = sc.nextInt();
				if (w > 0 && w < 4) {
					switch (w) {
					case 1:
						selectWeapon("Gun", 2, 5);
						break;
					case 2:
						selectWeapon("Sword", 3, 35);
						break;
					case 3:
						selectWeapon("Trifle", 7, 45);
						break;
					default:
						break;
					}
					b = false;
				} else {
					System.out.println("Wrong number! Try again: ");
				}
			} catch (Exception ex) {
				sc.next();
				System.out.println("Wrong symbol! Try again: ");
			}
		}

	}

	public void selectWeapon(String wName, int dam, int price) {
		int changeMoney;
		int totalDamage;
		changeMoney = player.getMoney() - price;
		totalDamage = player.getDamage() + dam;

		if (price > player.getMoney()) {
			System.out.println("You don't have enough money !");
			buyWeapon();
		} else {
			player.setDamage(totalDamage);
			player.setMoney(changeMoney);
			System.out.println();
			System.out.println("**After buying a Weapon**");
			System.out.println(player.toString() + "\nWeapon you bought: " + wName);
		}

	}

}
