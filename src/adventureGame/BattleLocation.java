package adventureGame;

public abstract class BattleLocation extends Location {
	protected Obstacle obstacle;
	protected String award;

	public BattleLocation(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.name = name;
		this.obstacle = obstacle;
		this.award = award;
	}

	@Override
	public boolean getLocation() {
		int obsCount = obstacle.obstacleCount();
		System.out.println();
		System.out.println("Now you are in the " + this.getName() + " \n" + "Be careful! Here has " + obsCount + " "
				+ obstacle.getObstacleName());
		System.out.print("<F>ight or <R>un: ");

		String selectedCase = sc.nextLine();
		if (selectedCase.equalsIgnoreCase("f")) {
			if (combat(obsCount)) {
				System.out.println("You killed all the enemies in the " + this.getName());
				if (this.award.equalsIgnoreCase("Food") && player.getInventory().isFood() == false) {
					System.out.println("You won " + this.award);
					player.getInventory().setFood(true);
				} else if (this.award.equalsIgnoreCase("Water") && player.getInventory().isWater() == false) {
					System.out.println("You won " + this.award);
					player.getInventory().setWater(true);
				} else if (this.award.equalsIgnoreCase("Firewood") && player.getInventory().isFirewood() == false) {
					System.out.println("You won " + this.award);
					player.getInventory().setFirewood(true);
				} else if (this.award.equalsIgnoreCase("Banana") && player.getInventory().isBanana() == false) {
					System.out.println("You won " + this.award);
					player.getInventory().setBanana(true);
				}
				playerStats();
				return true;

			}
			if (player.getHealthyness() <= 0) {
				System.err.println("You are dead !");
				return false;
			}
		} else if (selectedCase.equalsIgnoreCase("r")) {
			
		} else {
			System.out.println();
			System.out.println("Wrong symbol! ");
		}
		return true;
	}

	public boolean combat(int obsCount) {
		int defObsHealth = obstacle.getHealthyness();
		System.out.println();
		System.out.println("**********************BATTLE******************************");
		for (int i = 0; i < obsCount; i++) {

			playerStats();
			System.out.println();
			System.out.println("Enemy " + (i + 1));
			enemyStats();

			while (obstacle.getHealthyness() > 0 && player.getHealthyness() > 0) {
				System.out.print("<H>it or <R>un: ");
				String hit = sc.nextLine();
				if (hit.equalsIgnoreCase("h")) {

					if (player.getHealthyness() > 0) {
						System.out.println();
						System.out.println("You hit.");
						obstacle.setHealthyness(obstacle.getHealthyness() - player.getDamage());
						afterHit();
					} else {
						System.out.println("You died...");
						return false;
					}

					if (obstacle.getHealthyness() > 0) {
						System.out.println();
						System.out.println(obstacle.getObstacleName() + " hit you.");
						player.setHealthyness(player.getHealthyness() - obstacle.getDamage());
						if (player.getHealthyness() <= 0) {
							return false;
						}
						afterHit();
					} else {
						System.out.println(obstacle.getObstacleName() + " died !");
						player.setMoney(player.getMoney() + obstacle.getAward());
					}

				} else if (hit.equalsIgnoreCase("r")) {
					return false;

				} else {
					System.out.println();
					System.out.println("Wrong symbol! ");
				}

			}
			obstacle.setHealthyness(defObsHealth);

		}
		return true;
	}

	public void playerStats() {
		System.out.println();
		System.out.println("Player's Information: ");
		System.out.println();
		System.out.println("Healthy: " + player.getHealthyness() + "\nDamage: " + player.getDamage() + "\nMoney: "
				+ player.getMoney());
		if (player.getInventory().getWeaponName() != null) {
			System.out.println("Weapon: " + player.getInventory().getWeaponName());
		}
		if (player.getInventory().getArmorName() != null) {
			System.out.println("Armor: " + player.getInventory().getArmorName());
		}

	}

	public void enemyStats() {
		System.out.println();
		System.out.println("Enemy's Information: ");
		System.out.println();
		System.out.println("Healthy: " + obstacle.getHealthyness() + "\nDamage: " + obstacle.getDamage() + "\nMukafat: "
				+ obstacle.getAward());
	}

	public void afterHit() {
		if (obstacle.getHealthyness() > 0 && player.getHealthyness() > 0) {
			System.out.println(obstacle.getObstacleName() + "'s healthy : " + obstacle.getHealthyness());
			System.out.println("Player's healthy: " + player.getHealthyness());
		}

	}
}
