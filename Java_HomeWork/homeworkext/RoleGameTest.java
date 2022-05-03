package homeworkext;

public class RoleGameTest {

	public static void main(String[] args) {
		Hero saber = new SwordMan("亞拉岡", 1, 0);
		Hero archer = new ArrowMan("勒苟拉斯", 1, 0);
		
		saber.showStatus();
		saber.setAttackType(new AttackSword());
		saber.setMoveType(new MoveRun());
		saber.setDefendType(new DefendShield());
		saber.attack();
		saber.move();
		saber.defend();
		
		archer.showStatus();
		archer.setAttackType(new AttackArrow());
		archer.setMoveType(new MoveRun());
		archer.setDefendType(new DefendShield());
		archer.attack();
		archer.move();
		archer.defend();
	}

}
