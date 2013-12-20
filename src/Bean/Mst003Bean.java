package Bean;

public class Mst003Bean {
	int Level3Id;
	int Level2Id;
	String name;
	
	public Mst003Bean(){
	}
	public Mst003Bean(int Level3Id, int Level2Id, String name){
		setLevel3Id(Level3Id);
		setLevel2Id(Level2Id);
		setName(name);
	}
	
	public int getLevel3Id() {
		return Level3Id;
	}
	public void setLevel3Id(int level3Id) {
		Level3Id = level3Id;
	}
	public int getLevel2Id() {
		return Level2Id;
	}
	public void setLevel2Id(int level2Id) {
		Level2Id = level2Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
