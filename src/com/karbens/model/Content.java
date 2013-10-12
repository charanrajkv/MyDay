package com.karbens.model;

import java.util.ArrayList;

public class Content {
	
	 private String mName = "";
	 private int mId =0;
	 private ArrayList<Parent> mParentArr = null;
	
	 
	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public ArrayList<Parent> getmParentArr() {
		return mParentArr;
	}

	public void setmParentArr(ArrayList<Parent> mParentArr) {
		this.mParentArr = mParentArr;
	}
	 
	

}
