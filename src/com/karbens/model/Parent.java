package com.karbens.model;

import java.util.ArrayList;

public class Parent {
	
	private String mName = "";
	private String mContentUrl = "";
	public int mHas_child =0;
	private String mParentViewTime ="";
	private int mSlideBgPath = 0; // changes to string later
	private int mTimeInterval = 0;
	public ArrayList<Child> mChildArr = null;
	
	

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getmContentUrl() {
		return mContentUrl;
	}

	public void setmContentUrl(String mContentUrl) {
		this.mContentUrl = mContentUrl;
	}

	public int getmHas_child() {
		return mHas_child;
	}

	public void setmHas_child(int mHas_child) {
		this.mHas_child = mHas_child;
	}

	public String getmParentViewTime() {
		return mParentViewTime;
	}

	public void setmParentViewTime(String mParentViewTime) {
		this.mParentViewTime = mParentViewTime;
	}

	public int getmSlideBgPath() {
		return mSlideBgPath;
	}

	public void setmSlideBgPath(int mSlideBgPath) {
		this.mSlideBgPath = mSlideBgPath;
	}

	public int getmTimeInterval() {
		return mTimeInterval;
	}

	public void setmTimeInterval(int mTimeInterval) {
		this.mTimeInterval = mTimeInterval;
	}

	public ArrayList<Child> getmChildArr() {
		return mChildArr;
	}

	public void setmChildArr(ArrayList<Child> mChildArr) {
		this.mChildArr = mChildArr;
	}



}
