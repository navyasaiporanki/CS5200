package edu.northeastern.cs5200.models;

public enum Priviledge {
	
	

	create(1,"create"),
	read(2,"read"),
	update(3,"update"),
	delete(4,"delete");
	
	
	private int key;
	private String value;
	
	Priviledge(int key, String value){
		this.key = key;
		this.value = value;
	}
	
	public static String getPriviledgeById(int keyId) {
		
		for(Priviledge p : values()) {
			if(p.key == keyId) {
				return p.value;
			}
		}
		return null;
	}
	
}
