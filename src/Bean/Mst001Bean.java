package Bean;

public class Mst001Bean {
	int Level1Id;
	String name;
	
	public Mst001Bean(){
	}
	public Mst001Bean(int Level1Id, String name){
		setLevel1Id(Level1Id);
		setName(name);
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
