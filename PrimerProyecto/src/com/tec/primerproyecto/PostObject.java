package com.tec.primerproyecto;

import android.provider.MediaStore.Images;

public class PostObject {
	int idPost;
	String head;
	int idUser;
	String postDate;
	String postDescription;
	Images picture;
	double lat;
	double lon;
	
	public PostObject() {
		// TODO Auto-generated constructor stub
	}
	
	public PostObject(int id, String h, int idU, String pD, String pDesc, double la, double lo) {
		idPost = id;
		head = h;
		idUser = idU;
		postDate = pD;
		postDescription = pDesc;
		//picture = pic;
		lat = la;
		lon = lo;
	}
	
	@Override
	public String toString(){
		return this.head;
	}
}
