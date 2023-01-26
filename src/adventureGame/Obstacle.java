package adventureGame;

import java.util.Random;

public class Obstacle {
	private String obstacleName;
	private int damage, healthyness, award;
	private int maxNumber;

	public Obstacle(String obstacleName, int damage, int healthyness, int award, int maxNumber) {
		this.obstacleName = obstacleName;
		this.damage = damage;
		this.healthyness = healthyness;
		this.award = award;
		this.maxNumber = maxNumber;
	}

	public int obstacleCount() {
		Random random = new Random();
		return random.nextInt(this.maxNumber) + 1;
	}

	public String getObstacleName() {
		return obstacleName;
	}

	public void setObstacleName(String obstacleName) {
		this.obstacleName = obstacleName;
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

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}

	public int getMaxNumber() {
		return maxNumber;
	}

	public void setMaxNumber(int maxNumber) {
		this.maxNumber = maxNumber;
	}

}
