package adventureGame;

public class SafeHouse extends NormalLocation {

	public SafeHouse(Player player) {
		super(player, "Safe House");
	}

	@Override
	public boolean getLocation() {

		player.setHealthyness(player.getPermanentHealthyness());
		System.out.println();
		System.out.println("Now you are in the Safe House and your Healthy is full: " + player.getHealthyness());

		return true;
	}
}
