package com.karbens.model;
          
import java.util.ArrayList;

import android.R.string;

public class Brand {

	private String mName = "";
	private int mId = 0;
	private ArrayList<Content> mContentArr= null;
	
	
	public int getmId() {
		
		return mId;
	}
	
	
	public void setmId(int mId) {
		
		this.mId = mId;
	}
	
	
	public String getmName() {
		
		return mName;
	}
	
	
	public void setmName(String mName) {
		this.mName = mName;
	}
	public ArrayList<Content> getmContentArr() {
		return mContentArr;
	}
	public void setmContentArr(ArrayList<Content> mContentArr) {
		this.mContentArr = mContentArr;
	}
}
