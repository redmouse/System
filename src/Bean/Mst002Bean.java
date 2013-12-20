package Bean;

public class Mst002Bean {
	int Level2Id;
	int Level1Id;
	String name;
	
	public Mst002Bean(){
	}
	public Mst002Bean(int Level2Id, int Level1Id, String name){
		setLevel2Id(Level2Id);
		setLevel1Id(Level1Id);
		setName(name);
	}
	
	public int getLevel2Id() {
		return Level2Id;
	}
	public void setLevel2Id(int level2Id) {
		Level2Id = level2Id;
	}
	public int getLevel1Id() {
		return Level1Id;
	}
	public void setLevel1Id(int level1Id) {
		Level1Id = level1Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
