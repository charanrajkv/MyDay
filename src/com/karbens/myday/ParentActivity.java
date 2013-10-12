package com.karbens.myday;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.ArrayList;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.VideoView;
import android.webkit.WebSettings;
import android.widget.MediaController;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import android.widget.MediaController;
import com.karbens.model.Brand;
import com.karbens.model.Child;
import com.karbens.model.Content;
import com.karbens.model.Parent;
import com.viewpagerindicator.LinePageIndicator;


public class ParentActivity extends FragmentActivity {
	
	long img_array[] = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img5_1,R.drawable.img5_2,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img8_1,R.drawable.img9,R.drawable.img10,
			            R.drawable.img11,R.drawable.img11_1,R.drawable.img11_2,R.drawable.img11_3,R.drawable.img11_4,R.drawable.img11_5,R.drawable.img11_6,/*R.drawable.img12,R.drawable.img13,R.drawable.img13_1,R.drawable.img13_2,R.drawable.img14,R.drawable.img15,R.drawable.img16,R.drawable.img16_1,R.drawable.img17,R.drawable.img18,R.drawable.img19,R.drawable.img20,
			            R.drawable.img21,R.drawable.img22,R.drawable.img22_1,R.drawable.img22_2,R.drawable.img23,R.drawable.img24,R.drawable.img25,R.drawable.img26,R.drawable.img27,R.drawable.img28,R.drawable.img29,R.drawable.img30,
			            R.drawable.img31,R.drawable.img32,R.drawable.img32_1,R.drawable.img33,R.drawable.img34,R.drawable.img35,R.drawable.img36,R.drawable.img37,R.drawable.img38,R.drawable.img39,R.drawable.img40,
			            R.drawable.img41,R.drawable.img42,R.drawable.img43,R.drawable.img44,R.drawable.img45,R.drawable.img46,R.drawable.img47,R.drawable.img48,R.drawable.img48_1,R.drawable.img49,R.drawable.img50,
			            R.drawable.img51,R.drawable.img52,R.drawable.img53,R.drawable.img54,R.drawable.img55,R.drawable.img55_1,R.drawable.img56,R.drawable.img57,R.drawable.img58,R.drawable.img59,R.drawable.img60,
			            R.drawable.img61,R.drawable.img61_1,R.drawable.img61_2,R.drawable.img61_3,R.drawable.img61_4,R.drawable.img61_5,R.drawable.img61_6,R.drawable.img62,R.drawable.img63,R.drawable.img64,R.drawable.img65,R.drawable.img65_1,R.drawable.img66,R.drawable.img67,R.drawable.img68,R.drawable.img69,R.drawable.img70,
			            R.drawable.img71,R.drawable.img71_1,R.drawable.img71_2,R.drawable.img72,R.drawable.img73,R.drawable.img74,R.drawable.img75,R.drawable.img76,R.drawable.img77,R.drawable.img78,R.drawable.img78_1,R.drawable.img78_2,R.drawable.img78_3,R.drawable.img78_4,R.drawable.img78_5,R.drawable.img78_6,R.drawable.img79,R.drawable.img80,
			            R.drawable.img81,R.drawable.img82,R.drawable.img83,R.drawable.img84,R.drawable.img85,R.drawable.img85_1,R.drawable.img86 */};
	
	LinePageIndicator mIndicator = null;
	ViewPager  mPager = null;
	ParentAdapter mAdapter =null;
	LayoutInflater layoutInflater =null;
	Brand mBrand = null;
	Content mContent = null;
	Parent mParent = null;
	Child mChild = null;
	WebView mWebView = null;
	LinearLayout mLinearLay = null;
	DisplayMetrics dm = null;
	
	ArrayList<Parent> mParentArr = new ArrayList<Parent>();
	ArrayList<Content> mContentArr = new ArrayList<Content>(); 
    ArrayList<Child> mChildArr = null;
    
    //final static String TARGET_BASE_PATH = Environment.getExternalStorageDirectory();//"/sdcard/";
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_parent);
		
		
		
		// dump to sdcard
		
		
		
		copyAssets();
		
		
		
		// dump to sdcard
		
		
		dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics( dm );
        
		
		/*** Brand ***/
        mBrand	= new Brand();
        mBrand.setmName("Addidas");
        mBrand.setmId(2);
        
        /*** Content ***/
        mContent = new Content();
        mContent.setmId(3);
        mContent.setmName("presentation 1");
        
        /*** Parent ***/
        mParent = new Parent();
        mParent.setmName("Slide 1");
        mParent.setmSlideBgPath(R.drawable.img1);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 1 video");
        mChild.setmType(1);
        mChild.setmFilePath("mylan_add.mp4");
        mChild.setmFrame("150,150,300,300");
        
        mChildArr.add(mChild);
        mChild = null;*/
        
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
       
        
        mParentArr.add(mParent); // Adding a parent to the array
        mParent = null;
        
        System.out.println(mParentArr.get(0).getmChildArr().size());
        
        /*** Parent ***/
        mParent = new Parent();
        mParent.setmName("Slide 2");
        mParent.setmSlideBgPath(R.drawable.img2);
       
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        
        /***Child **/
        mChild = new Child();
        mChild.setmName("Child 1 video");
        mChild.setmType(1);
        mChild.setmFilePath("mylan_add.mp4");
        mChild.setmFrame("150,150,150,150");
        
        mChildArr.add(mChild);
        mChild = null;
        
        
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
       
        mParentArr.add(mParent); // Adding a parent to the array
        mParent = null;
        
        System.out.println(mParentArr.get(1).getmChildArr().size());
        //System.out.println(mChild.getmType());
        
        
        /*** Parent ***/
        mParent = new Parent();
        mParent.setmName("Slide 3");
        mParent.setmSlideBgPath(R.drawable.img3);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent to the array
        mParent = null;
        
        System.out.println(mParentArr.get(2).getmChildArr().size());
        
        
        /*** Parent ***/
        mParent = new Parent();
        mParent.setmName("Slide 4");
        mParent.setmSlideBgPath(R.drawable.img4);
       
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent to the array
        mParent = null;
        
        System.out.println(mParentArr.get(3).getmChildArr().size());
        
        
        /*** Parent ***/
        mParent = new Parent();
        mParent.setmName("Slide 5");
        mParent.setmSlideBgPath(R.drawable.img5);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        

        /***Child ***/
        mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img5_1.png");
        mChild.setmFrame("70,370,420,210");
        
        mChildArr.add(mChild);
        mChild = null;
        

        /***Child ***/
        mChild = new Child();
        mChild.setmName("Child 2");
        mChild.setmType(0);
        mChild.setmFilePath("img5_2.png");
        mChild.setmFrame("530,370,420,215");
        
        mChildArr.add(mChild);
        mChild = null;
        
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent to the array
        mParent = null;
        
       
        System.out.println(mParentArr.get(4).getmChildArr().size());
        
         
        /*** Parent ***/
        mParent = new Parent();
        mParent.setmName("Slide 6");
        mParent.setmSlideBgPath(R.drawable.img6);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(5).getmChildArr().size());
        
        
        /*** Parent ***/
        mParent = new Parent();
        mParent.setmName("Slide 7");
        mParent.setmSlideBgPath(R.drawable.img7);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(6).getmChildArr().size());
        
        
        /*** Parent ***/
        mParent = new Parent();
        mParent.setmName("Slide 8");
        mParent.setmSlideBgPath(R.drawable.img8);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        
        /***Child ***/
        mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img8_1.png");
        mChild.setmFrame("670,370,250,210");
        
        mChildArr.add(mChild);
        mChild = null;
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(7).getmChildArr().size());
        
        /*** Parent ***/
        mParent = new Parent();
        mParent.setmName("Slide 9");
        mParent.setmSlideBgPath(R.drawable.img9);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        /*** Parent ***/
        mParent = new Parent();
        mParent.setmName("Slide 10");
        mParent.setmSlideBgPath(R.drawable.img10);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(9).getmChildArr().size());
        
        
        /*** Parent ***/
        mParent = new Parent();
        mParent.setmName("Slide 11");
        mParent.setmSlideBgPath(R.drawable.img11);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        
        /***Child ***/
        mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img11_1.png");
        mChild.setmFrame("115,60,400,175");
        
        mChildArr.add(mChild);
        mChild = null;
        
        /***Child ***/
        mChild = new Child();
        mChild.setmName("Child 2");
        mChild.setmType(0);
        mChild.setmFilePath("img11_2.png");
        mChild.setmFrame("510,60,400,175");
        
        
        mChildArr.add(mChild);
        mChild = null;
        
        /***Child ***/
        mChild = new Child();
        mChild.setmName("Child 3");
        mChild.setmType(0);
        mChild.setmFilePath("img11_3.png");
        mChild.setmFrame("115,235,400,175");
        
        mChildArr.add(mChild);
        mChild = null;
        
        /***Child ***/
        mChild = new Child();
        mChild.setmName("Child 4");
        mChild.setmType(0);
        mChild.setmFilePath("img11_4.png");
        mChild.setmFrame("510,235,400,175");
        
        mChildArr.add(mChild);
        mChild = null;
        
        /***Child ***/
        mChild = new Child();
        mChild.setmName("Child 5");
        mChild.setmType(0);
        mChild.setmFilePath("img11_5.png");
        mChild.setmFrame("115,413,400,175");
        

        mChildArr.add(mChild);
        mChild = null;
        
        /***Child ***/
        mChild = new Child();
        mChild.setmName("Child 6");
        mChild.setmType(0);
        mChild.setmFilePath("img11_6.png");
        mChild.setmFrame("510,413,400,175");
        

        mChildArr.add(mChild);
        mChild = null;
        
        
        
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(10).getmChildArr().size());
        
        
        /*** Parent **
        mParent = new Parent();
        mParent.setmName("Slide 12");
        mParent.setmSlideBgPath(R.drawable.img12);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(11).getmChildArr().size());
        
        
        /*** Parent **
        mParent = new Parent();
        mParent.setmName("Slide 13");
        mParent.setmSlideBgPath(R.drawable.img13);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        
        mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img13_1.png");
        mChild.setmFrame("295,280,210,135");
        
        
        mChildArr.add(mChild);
        mChild = null;
        
        mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img13_2.png");
        mChild.setmFrame("587,280,215,135");
        
        
        mChildArr.add(mChild);
        mChild = null;
        
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(12).getmChildArr().size());
        
        
        /*** Parent **
        mParent = new Parent();
        mParent.setmName("Slide 14");
        mParent.setmSlideBgPath(R.drawable.img14);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(13).getmChildArr().size());
        
        
        /*** Parent **
        mParent = new Parent();
        mParent.setmName("Slide 15");
        mParent.setmSlideBgPath(R.drawable.img15);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(14).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 16");
        mParent.setmSlideBgPath(R.drawable.img16);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        
        mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img16_1.png");
        mChild.setmFrame("160,250,430,220");
        
        
        mChildArr.add(mChild);
        mChild = null;
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(15).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 17");
        mParent.setmSlideBgPath(R.drawable.img17);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(16).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 18");
        mParent.setmSlideBgPath(R.drawable.img18);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(17).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 19");
        mParent.setmSlideBgPath(R.drawable.img19);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(18).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 20");
        mParent.setmSlideBgPath(R.drawable.img20);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(19).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 21");
        mParent.setmSlideBgPath(R.drawable.img21);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(20).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 22");
        mParent.setmSlideBgPath(R.drawable.img22);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img22_1.png");
        mChild.setmFrame("235,280,220,138");
        
        
        mChildArr.add(mChild);
        mChild = null;
        
        mChild = new Child();
        mChild.setmName("Child 2");
        mChild.setmType(0);
        mChild.setmFilePath("img22_2.png");
        mChild.setmFrame("548,280,220,138");
        
        
        mChildArr.add(mChild);
        mChild = null;
        
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(21).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 23");
        mParent.setmSlideBgPath(R.drawable.img23);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(22).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 24");
        mParent.setmSlideBgPath(R.drawable.img24);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(23).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 25");
        mParent.setmSlideBgPath(R.drawable.img25);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(24).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 26");
        mParent.setmSlideBgPath(R.drawable.img26);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(25).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 27");
        mParent.setmSlideBgPath(R.drawable.img27);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(26).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 28");
        mParent.setmSlideBgPath(R.drawable.img28);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(27).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 29");
        mParent.setmSlideBgPath(R.drawable.img29);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(28).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 30");
        mParent.setmSlideBgPath(R.drawable.img30);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(29).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 31");
        mParent.setmSlideBgPath(R.drawable.img31);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(30).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 32");
        mParent.setmSlideBgPath(R.drawable.img32);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        
        /***Child *
        mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img32_1.png");
        mChild.setmFrame("772,452,150,130");
        
        
        mChildArr.add(mChild);
        mChild = null;
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(31).getmChildArr().size());
        
        /*** Parent **
        mParent = new Parent();
        mParent.setmName("Slide 33");
        mParent.setmSlideBgPath(R.drawable.img33);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(32).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 34");
        mParent.setmSlideBgPath(R.drawable.img34);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(33).getmChildArr().size());
        
        
        /*** Parent **
        mParent = new Parent();
        mParent.setmName("Slide 35");
        mParent.setmSlideBgPath(R.drawable.img35);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(34).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 36");
        mParent.setmSlideBgPath(R.drawable.img36);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(35).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 37");
        mParent.setmSlideBgPath(R.drawable.img37);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(36).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 38");
        mParent.setmSlideBgPath(R.drawable.img38);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(37).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 39");
        mParent.setmSlideBgPath(R.drawable.img39);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(38).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 40");
        mParent.setmSlideBgPath(R.drawable.img40);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(39).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 41");
        mParent.setmSlideBgPath(R.drawable.img41);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(40).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 42");
        mParent.setmSlideBgPath(R.drawable.img42);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(41).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 43");
        mParent.setmSlideBgPath(R.drawable.img43);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(42).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 44");
        mParent.setmSlideBgPath(R.drawable.img44);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(43).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 45");
        mParent.setmSlideBgPath(R.drawable.img45);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(44).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 46");
        mParent.setmSlideBgPath(R.drawable.img46);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(45).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 47");
        mParent.setmSlideBgPath(R.drawable.img47);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(46).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 48");
        mParent.setmSlideBgPath(R.drawable.img48);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        
        /***Child *
        mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img48_1.png");
        mChild.setmFrame("772,452,150,130");
        
        
        mChildArr.add(mChild);
        mChild = null;
        
        
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(47).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 49");
        mParent.setmSlideBgPath(R.drawable.img49);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(48).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 50");
        mParent.setmSlideBgPath(R.drawable.img50);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(49).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 51");
        mParent.setmSlideBgPath(R.drawable.img51);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(50).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 52");
        mParent.setmSlideBgPath(R.drawable.img52);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(51).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 53");
        mParent.setmSlideBgPath(R.drawable.img53);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(52).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 54");
        mParent.setmSlideBgPath(R.drawable.img54);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(53).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 55");
        mParent.setmSlideBgPath(R.drawable.img55);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        

        /***Child *
        mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img55_1.png");
        mChild.setmFrame("235,280,220,138");
        
        
        mChildArr.add(mChild);
        mChild = null;
        
        mChild = new Child();
        mChild.setmName("Child 2");
        mChild.setmType(0);
        mChild.setmFilePath("img55_2.png");
        mChild.setmFrame("548,280,220,138");
        
        
        mChildArr.add(mChild);
        mChild = null;
       
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(54).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 56");
        mParent.setmSlideBgPath(R.drawable.img56);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(55).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 57");
        mParent.setmSlideBgPath(R.drawable.img57);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(56).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 58");
        mParent.setmSlideBgPath(R.drawable.img58);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(57).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 59");
        mParent.setmSlideBgPath(R.drawable.img59);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(58).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 60");
        mParent.setmSlideBgPath(R.drawable.img60);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(59).getmChildArr().size());
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 61");
        mParent.setmSlideBgPath(R.drawable.img61);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img61_1.png");
        mChild.setmFrame("115,60,400,175");
        
        mChildArr.add(mChild);
        mChild = null;
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 2");
        mChild.setmType(0);
        mChild.setmFilePath("img61_2.png");
        mChild.setmFrame("510,60,400,175");
        
        
        mChildArr.add(mChild);
        mChild = null;
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 3");
        mChild.setmType(0);
        mChild.setmFilePath("img61_3.png");
        mChild.setmFrame("115,235,400,175");
        
        mChildArr.add(mChild);
        mChild = null;
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 4");
        mChild.setmType(0);
        mChild.setmFilePath("img61_4.png");
        mChild.setmFrame("510,235,400,175");
        
        mChildArr.add(mChild);
        mChild = null;
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 5");
        mChild.setmType(0);
        mChild.setmFilePath("img61_5.png");
        mChild.setmFrame("115,413,400,175");
        

        mChildArr.add(mChild);
        mChild = null;
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 6");
        mChild.setmType(0);
        mChild.setmFilePath("img61_6.png");
        mChild.setmFrame("510,413,400,175");
        

        mChildArr.add(mChild);
        mChild = null;
        
       
        
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(60).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 62");
        mParent.setmSlideBgPath(R.drawable.img62);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(61).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 63");
        mParent.setmSlideBgPath(R.drawable.img63);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(62).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 64");
        mParent.setmSlideBgPath(R.drawable.img64);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(63).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 65");
        mParent.setmSlideBgPath(R.drawable.img65);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        
         mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img65_1.png");
        mChild.setmFrame("160,250,430,220");
        
        
        mChildArr.add(mChild);
        mChild = null;
        
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(64).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 66");
        mParent.setmSlideBgPath(R.drawable.img66);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(65).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 67");
        mParent.setmSlideBgPath(R.drawable.img67);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(66).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 68");
        mParent.setmSlideBgPath(R.drawable.img68);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(67).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 69");
        mParent.setmSlideBgPath(R.drawable.img69);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(68).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 70");
        mParent.setmSlideBgPath(R.drawable.img70);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(69).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 71");
        mParent.setmSlideBgPath(R.drawable.img71);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        

        /***Child **
        mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img71_1.png");
        mChild.setmFrame("70,370,420,210");
        
        mChildArr.add(mChild);
        mChild = null;
        

        /***Child **
        mChild = new Child();
        mChild.setmName("Child 2");
        mChild.setmType(0);
        mChild.setmFilePath("img71_2.png");
        mChild.setmFrame("530,370,420,215");
        
        mChildArr.add(mChild);
        mChild = null;
        
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(70).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 72");
        mParent.setmSlideBgPath(R.drawable.img72);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(71).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 73");
        mParent.setmSlideBgPath(R.drawable.img73);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(72).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 74");
        mParent.setmSlideBgPath(R.drawable.img74);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(73).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 75");
        mParent.setmSlideBgPath(R.drawable.img75);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(74).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 76");
        mParent.setmSlideBgPath(R.drawable.img76);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(75).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 77");
        mParent.setmSlideBgPath(R.drawable.img77);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(76).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 78");
        mParent.setmSlideBgPath(R.drawable.img78);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img78_1.png");
        mChild.setmFrame("115,60,400,175");
        
        mChildArr.add(mChild);
        mChild = null;
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 2");
        mChild.setmType(0);
        mChild.setmFilePath("img78_2.png");
        mChild.setmFrame("510,60,400,175");
        
        
        mChildArr.add(mChild);
        mChild = null;
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 3");
        mChild.setmType(0);
        mChild.setmFilePath("img78_3.png");
        mChild.setmFrame("115,235,400,175");
        
        mChildArr.add(mChild);
        mChild = null;
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 4");
        mChild.setmType(0);
        mChild.setmFilePath("img78_4.png");
        mChild.setmFrame("510,235,400,175");
        
        mChildArr.add(mChild);
        mChild = null;
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 5");
        mChild.setmType(0);
        mChild.setmFilePath("img78_5.png");
        mChild.setmFrame("115,413,400,175");
        

        mChildArr.add(mChild);
        mChild = null;
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 6");
        mChild.setmType(0);
        mChild.setmFilePath("img78_6.png");
        mChild.setmFrame("510,413,400,175");
        

        mChildArr.add(mChild);
        mChild = null;
        
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(77).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 79");
        mParent.setmSlideBgPath(R.drawable.img79);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(78).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 80");
        mParent.setmSlideBgPath(R.drawable.img80);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(79).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 81");
        mParent.setmSlideBgPath(R.drawable.img81);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(80).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 82");
        mParent.setmSlideBgPath(R.drawable.img82);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(81).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 83");
        mParent.setmSlideBgPath(R.drawable.img83);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(82).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 84");
        mParent.setmSlideBgPath(R.drawable.img84);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(83).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 85");
        mParent.setmSlideBgPath(R.drawable.img85);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        
        /***Child **
        mChild = new Child();
        mChild.setmName("Child 1");
        mChild.setmType(0);
        mChild.setmFilePath("img85_1.png");
        mChild.setmFrame("142,365,430,255");
        
        mChildArr.add(mChild);
        mChild = null;
        
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        
        System.out.println(mParentArr.get(84).getmChildArr().size());
        
        
        /*** Parent *
        mParent = new Parent();
        mParent.setmName("Slide 86");
        mParent.setmSlideBgPath(R.drawable.img86);
        
        mChildArr = new ArrayList<Child>();
        mChildArr.clear();
        mParent.setmChildArr(mChildArr);
        mChildArr = null;
        
        mParentArr.add(mParent); // Adding a parent  to the array
        mParent = null;
        
        System.out.println(mParentArr.get(85).getmChildArr().size());
        
        */
        
       
        
        
        
       mContent.setmParentArr(mParentArr); //Adding the parent array to the content array or presentation array
        
        mContentArr.add(mContent); // Adding a content
        
        mBrand.setmContentArr(mContentArr); // Adding the array of contents or presentations to the brand
        mContentArr = null;
        
		//mIndicator= (LinePageIndicator) findViewById(R.id.indicator);
        
        mLinearLay = (LinearLayout) findViewById(R.id.superLayout);
        
		mPager = (ViewPager) findViewById(R.id.parentView);
		mAdapter = new ParentAdapter(this);
		mPager.setAdapter(mAdapter);
		
		/*
		DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics( dm );
        System.out.println("Height :"+dm.heightPixels);
        System.out.println("Width :"+dm.widthPixels);
        */

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
		
	}

	private class ParentAdapter extends PagerAdapter 
	{
      
		 GestureDetector gd = null;
		 int childId = 0;
		 View childWebView = null;
		 Context mContext = null;
		 boolean translate=true;
		 
		 
		 public ParentAdapter(Context context)
		 {
			mContext = context;
			//gd = new GestureDetector(this);
		 }
		 
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			//System.out.println(""+mBrand.getmContentArr().get(0).getmParentArr().size());
			return mBrand.getmContentArr().get(0).getmParentArr().size();
		
		}
		
		@Override
		public void destroyItem(View container, int position, Object view) {
			// TODO Auto-generated method stub
			((ViewPager) container).removeView((View) view);
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			// TODO Auto-generated method stub
			return view==object;
		}
		 
		
       
		@Override
        public Object instantiateItem(View container, int position) {
       
			
        	layoutInflater = getLayoutInflater();
        	View layout = layoutInflater.inflate(R.layout.page_viewer_item,null);
	          // TODO Auto-generated method stub
        	
        	RelativeLayout mainContainerRelLay = (RelativeLayout) layout.findViewById(R.id.slideContainerRL);
        	
            ImageView imgView = (ImageView) layout.findViewById(R.id.parentImgView);
            imgView.setBackgroundResource((int)mBrand.getmContentArr().get(0).getmParentArr().get(position).getmSlideBgPath());
            
            
            imgView.setOnLongClickListener(new OnLongClickListener() {
				
				@Override
				public boolean onLongClick(View v) {
					//finish();
					System.out.println("Display Exit!!");
					
					//****** Construct data model and switch to target application *******//
					
					
					
					return true;
				}
            });
            
            
            	
            System.out.println("Index :"+position+"Child Count :"+mBrand.getmContentArr().get(0).getmParentArr().get(position).getmChildArr().size());
            
            for(int i=0;i<(mBrand.getmContentArr().get(0).getmParentArr().get(position).getmChildArr().size());i++)
            {
            	
            	final Child aChild = mBrand.getmContentArr().get(0).getmParentArr().get(position).getmChildArr().get(i);
            	
            	
            	mWebView = new WebView(mContext);
            	int tempChilId = Integer.parseInt(""+position+""+i); // not used
           
            	mWebView.setId(Integer.parseInt(""+position+""+i));
            	String childFrame = aChild.getmFrame();
            	
            	String[] frameArr = childFrame.split(",");
            	
            	int xValue = Integer.parseInt(frameArr [0]);
            	int yValue = Integer.parseInt(frameArr [1]);
            	int width = Integer.parseInt(frameArr [2]);
            	int height = Integer.parseInt(frameArr [3]);
            	
                //mWebView.setScrollBarStyle(WebView.SCROLLBARS_INSIDE_OVERLAY);
                //mWebView.setScrollbarFadingEnabled(true);
                mWebView.setWebChromeClient(new WebChromeClient());
                
                
                mWebView.getSettings().setJavaScriptEnabled(true);
                //mWebView.getSettings().setDomStorageEnabled(true); 
                //mWebView.getSettings().setPluginState(PluginState.ON);
                //mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
                mWebView.getSettings().setLoadWithOverviewMode(true);
                mWebView.getSettings().setUseWideViewPort(true);
                //mWebView.getSettings().setBuiltInZoomControls(true);
                mWebView.getSettings().setAllowFileAccess(true);
                mWebView.setInitialScale(1);
                //mWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
                
               
                
               /* mWebView.setOnTouchListener(new OnTouchListener() {
					
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub
						
						if(event.getAction() == MotionEvent.ACTION_DOWN)
						{
							WebViewDialogFragment webViewDialog = new WebViewDialogFragment(aChild.getmFilePath());
							webViewDialog.show(getSupportFragmentManager(), "web dialog");
						}
						
						return false;
					}
				});*/
                
                
                //mWebView.getSettings().setSupportZoom(true);
                //System.out.println("Child Type testing :"+aChild.getmType());
                
                RelativeLayout.LayoutParams bparams = new RelativeLayout.LayoutParams(width,height);//RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);//
            	bparams.setMargins(xValue, yValue, 0, 0);
            		
                bparams.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);//imgView.getId());
                
                
                if(aChild.getmType()==1)
                {
                	System.out.println("Video inside");
                	//mWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
                	//mWebView.loadDataWithBaseURL("file:///android_asset/", "<html><body><h1>Video</h1><video width=\"320\" height=\"240\" controls autobuffer><source src=\"file:///mnt/sdcard/mylan_add.mp4\" type=\"video/mp4\"></video></body></html>", "text/html", "utf-8", null);
                	//mWebView.loadDataWithBaseURL("file:///sdcard/", "<html><body><video width=\""+width+"px\" height=\""+height+"px\" controls><source src=\"mylan_add.mp4\" type=\"video/mp4\"></video></body></html>", "text/html", "utf-8", null);
                	
                	//mWebView.setInitialScale(2);
                	//mWebView.loadDataWithBaseURL("file:///sdcard/", "<html><body><video width=\"100%\"  height=\"100%\"><source src=\"mylan_add.mp4\" type=\"video/mp4\"></video></body></html>", "text/html", "utf-8", null);
                	
                	VideoView video = new VideoView(mContext);
                	Uri vidUri = Uri.parse("android.resource://"+"com.karbens.myday"+"/"+R.raw.mylan_add);
                	//Uri vidUri = Uri.parse("android.resource://"+"mylan_add.mp4");
                	//video.setVideoPath("android.resource://com.karbens/raw/mylan_add");
                	video.setVideoURI(vidUri);
                	video.setVisibility(View.VISIBLE);
                	video.start();
                	
                	mainContainerRelLay.addView(video, bparams);
                }
                else
                {
                	// Image
                	mWebView.loadDataWithBaseURL("file:///android_res/drawable/", "<html><body><img src=\""+aChild.getmFilePath()+"\" width=100%\"/></body></html>", "text/html", "utf-8", null);
                	mainContainerRelLay.addView(mWebView, bparams);
                }
               
               
            	
            	
            }
            
            ((ViewPager) container).addView(layout);
             
        	return layout;
       
        }
		

		/*
		private void EnlargeChild(View view) {
	        // create set of animations
			AnimationSet replaceAnimation = new AnimationSet(false);
	        // animations should be applied on the finish line
	        replaceAnimation.setFillAfter(true);

	        TranslateAnimation trans = null;
	        ScaleAnimation scale = null;
	       
	        
	        int statusBarOffset = dm.heightPixels - mLinearLay.getMeasuredHeight();

	        int originalPos[] = new int[2];
	        view.getLocationOnScreen(originalPos);

	        int xDest = dm.widthPixels/2;
	        
	        xDest -= (view.getMeasuredWidth()*2/2);
	        
	        int yDest = dm.heightPixels/2 - (view.getMeasuredHeight()/2) - statusBarOffset;
	        
	        
	        trans = getTranslateAnim(0, xDest - originalPos[0] , 0, yDest - originalPos[1]);
	        scale = getScaleUpAnim();
	        
	        // add new animations to the set
	        replaceAnimation.addAnimation(scale);
	        replaceAnimation.addAnimation(trans);

	        // start our animation
	        view.startAnimation(replaceAnimation);
	    }
		
		
		private void ShrinkChild(View view) {
			
			// Shrink it back to original size
		}
		
		
		private TranslateAnimation getTranslateAnim(int fromX,int toX,int fromY,int toY)
		{
			// create translation animation
	        TranslateAnimation trans = new TranslateAnimation(fromX, toX , fromY, toY);
	        trans.setDuration(1000);
	        
	        return trans;
		}
		
		private ScaleAnimation getScaleUpAnim()
		{
			 // create scale animation
	        ScaleAnimation scale = new ScaleAnimation(1.0f,2.0f,1.0f,2.0f);//,
					//Animation.ABSOLUTE,0.5f,Animation.ABSOLUTE,0.5f);//(1.0f, xScale, 1.0f, yScale);
	        scale.setDuration(1000);
			
	        return scale;
		}
		
		
		private ScaleAnimation getScaleDwnAnim()
		{
			 // create scale animation
	        ScaleAnimation scale = new ScaleAnimation(1.0f,2.0f,1.0f,2.0f);//,
					//Animation.ABSOLUTE,0.5f,Animation.ABSOLUTE,0.5f);//(1.0f, xScale, 1.0f, yScale);
	        scale.setDuration(1000);
			
	        return scale;
		}
		*/
		
		public class WebViewDialogFragment extends DialogFragment implements OnDoubleTapListener, OnGestureListener {
			
			WebView mWebView = null;
			String mPath = "";
			Context mContext = null;
			GestureDetector gd = null;
			
			public WebViewDialogFragment (String path)
			{
				mPath = path;
				//mContext = context;
				gd = new GestureDetector(this);
			}
			
			@Override
			public Dialog onCreateDialog(Bundle savedInstanceState) {
				// TODO Auto-generated method stub
				
				AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
				
				// Get the layout inflater
			    LayoutInflater inflater = getActivity().getLayoutInflater();
			    
			    View dialogView = inflater.inflate(R.layout.webview_dialog, null);
			    
				builder.setView(dialogView);
				
				mWebView = (WebView) dialogView.findViewById(R.id.childWebView);
				
				
				
				//mWebView.loadDataWithBaseURL("file:///android_res/drawable/", "<html><body><img src=\""+mPath+"\" width=100%\"/></body></html>", "text/html", "utf-8", null);
				mWebView.loadUrl("file:///android_asset/video.html");
				builder.setCancelable(false);
				
				
				
				mWebView.setOnTouchListener(new OnTouchListener() {
					
					@Override
					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub
						
						return gd.onTouchEvent(event);
					}
				});
				
				AlertDialog dialog  = builder.create();
				dialog.setCanceledOnTouchOutside(false);
				
				return dialog;
			}

			@Override
			public boolean onDoubleTap(MotionEvent e) {
				// TODO Auto-generated method stub
				
				// dismiss dialog
				System.out.println("Dismiss dialog");
				this.dismiss();
				return false;
			}

			@Override
			public boolean onDoubleTapEvent(MotionEvent e) {
				// TODO Auto-generated method stub
				
				
				return false;
			}

			@Override
			public boolean onSingleTapConfirmed(MotionEvent e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean onDown(MotionEvent e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2,
					float velocityX, float velocityY) {
				// TODO Auto-generated method stub
				
				return false;
			}

			@Override
			public void onLongPress(MotionEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean onScroll(MotionEvent e1, MotionEvent e2,
					float distanceX, float distanceY) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void onShowPress(MotionEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				// TODO Auto-generated method stub
				return false;
			}

			
			
		}
		
		

	}
	
	 
	private void copyAssets() 
	{
	    AssetManager assetManager = getAssets();
	    String[] files = null;
	    try 
	    {
	        files = assetManager.list("");
	    } 
	    catch (IOException e) 
	    {
	        Log.e("tag", "Failed to get asset file list.", e);
	    }
	    
	    for(String filename : files) 
	    {
	        InputStream in = null;
	        OutputStream out = null;
	        try {
	          in = assetManager.open(filename);
	          File outFile = new File(Environment.getExternalStorageDirectory(), filename);
	          System.out.println(""+Environment.getExternalStorageDirectory()+"/"+filename);
	          
	          out = new FileOutputStream(outFile);
	          copyFile(in, out);
	          in.close();
	          in = null;
	          out.flush();
	          out.close();
	          out = null;
	        } 
	        catch(IOException e) 
	        {
	            Log.e("tag", "Failed to copy asset file: " + filename, e);
	        }       
	    }
	}
	
	private void copyFile(InputStream in, OutputStream out) throws IOException {
	    byte[] buffer = new byte[1024];
	    int read;
	    while((read = in.read(buffer)) != -1){
	      out.write(buffer, 0, read);
	    }
	}
	
}