package br.com.ufc.quixada.apriori.data.model;

public class Director {
	private Integer directorId;
	private String name;
	
	public Director() {
		this.directorId = 0;
		this.name = "";
	}
	
	public Integer getDirectorId() {
		return directorId;
	}
	public void setDirectorId(Integer directorId) {
		this.directorId = directorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Director [directorId=" + directorId + ", name=" + name + "]";
	}
	
	

}
