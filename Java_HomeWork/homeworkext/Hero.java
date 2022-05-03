package homeworkext;

public abstract class Hero {
	// 省略 getter/setter...
	
	private String name;
	private int level;
	private double exp;
	
	private AttackType atkType;
	private MoveType mvType;
	private DefendType dfType;
	
	public Hero() {
		this("David", 1, 0);
	}
	
	public Hero(String name, int level, double exp) {
		this.name = name;
		this.level = level;
		this.exp = exp;
	}
	
	public void showStatus() {
		System.out.println("英雄資訊(" + name + ") 等級:" + level + " 經驗值:" + exp);
	}
	
	public void setAttackType(AttackType atkType) {
		this.atkType = atkType;
	}
	
	public void attack() {
		atkType.attack();
	}

	public void setMoveType(MoveType mvType) {
		this.mvType = mvType;
	}
	
	public void move() {
		mvType.move();
	}
	
	public void setDefendType(DefendType dfType) {
		this.dfType = dfType;
	}
	
	public void defend() {
		dfType.defend();
	}
}
