package file_task_2;

import java.io.Serializable;

public class GameProgress implements Serializable {
	private static final long serialVersionUID = 1L;

	private String name;
	private int health;
	private int weapons;
	private int lvl;
	private double distance;

	public GameProgress(String name, int health, int weapons, int lvl, double distance) {
		this.name = name;
		this.health = health;
		this.weapons = weapons;
		this.lvl = lvl;
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "GameProgress{" + "health=" + health + ", weapons=" + weapons + ", lvl=" + lvl + ", distance=" + distance
				+ '}';
	}

	public String getName() {
		return name;
	}
	
	
}
