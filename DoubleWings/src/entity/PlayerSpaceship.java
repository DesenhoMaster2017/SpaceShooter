package entity;

public class PlayerSpaceship extends GameEntity {
	
	private static final String spriteImagePath = "src/assets/img/temp_player.png"; 
	
	private Shield shield;
	
	public PlayerSpaceship() {
		super(spriteImagePath, 3);
		this.shield = new Shield(this);
	}
	
	public PlayerSpaceship(double x, double y) {
		super(spriteImagePath, 3);
		this.shield = new Shield(this);
		this.x = x - this.width / 2;
		this.y = y;
	}

	@Override
	public void didContact(GameEntity entity){
		if (entity.getClass() == Shield.class){
			
		}else if (entity.getClass() == Enemy.class){
			
			entity.receiveDamage(100); // test purposes
			this.receiveDamage(20); // test purposes
			
		}else {
			
		}
	}
	
	public Shield getShield() {
		return this.shield;
	}
	
}
