package edu.northeastern.cs5200.models;




	
	

public enum Role {

	
	//owner, admin, writer, editor,reviewer
	
	owner(1,"owner"),
	admin(2,"admin"),
	writer(3,"writer"),
	editor(4,"editor"),
	reviewer(5,"reviewer");
	
	private int key;
	private String value;
	
	 Role(int key, String value){
		this.key = key;
		this.value = value;
	}
	
	public static String getById(int key) {
	
		for(Role r: values()) {
			if(r.key == key) {
				return r.value;
			}
		}
		return null;
	}
}




