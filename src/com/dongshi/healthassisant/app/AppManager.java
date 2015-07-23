package com.dongshi.healthassisant.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.dongshi.healthassisant.ui.MainActivity;
import com.dongshi.healthassisant.ui.MyBaseActivity;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
/**
 * @author Yun
 */
public class AppManager {
	private static AppManager instance = new AppManager();
	private static Stack<Activity> activityStack;

	private AppManager() {
	}

	/**
	 * 单一实例
	 */
	public static AppManager getAppManager() {
		return instance;
	}

	public void AppExit(Context context) {
		finishAllActivity();
		ActivityManager activityMgr = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		activityMgr.killBackgroundProcesses(context.getPackageName());
	}

	private void finishAllActivity() {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)) {
				activityStack.get(i).finish();
			}
		}
		activityStack.clear();
	}

	/**
	 * 添加Activity到堆栈
	 */
	public void addActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
	}

	/**
	 * 获取当前Activity（堆栈中最后一个压入的）
	 */
	public Activity currentActivity() {
		Activity activity = activityStack.lastElement();
		return activity;
	}

	/**
	 * 结束当前Activity（堆栈中最后一个压入的）
	 */
	public void finishActivity() {
		Activity activity = activityStack.lastElement();
		finishActivity(activity);
	}

	/**
	 * 结束指定的Activity
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			activityStack.remove(activity);
			activity.finish();
			activity = null;
		}
	}

	/**
	 * 结束指定类名的Activity
	 */
	public void finishActivity(Class<?> cls) {
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				finishActivity(activity);
			}
		}
	}

	/**
	 * 获得所有IdeaCodeActivity
	 * 
	 * @return
	 */
	public List<MyBaseActivity> getAllActivity() {
		ArrayList<MyBaseActivity> listActivity = new ArrayList<MyBaseActivity>();
		for (Activity activity : activityStack) {
			listActivity.add((MyBaseActivity) activity);
		}
		return listActivity;
	}

	/**
	 * 根据Activity名称返回指定的Activity
	 * 
	 * @param name
	 * @return
	 */
	public MyBaseActivity getActivityByName(String name) {
		for (Activity ia : activityStack) {
			if (ia.getClass().getName().indexOf(name) >= 0) {
				return (MyBaseActivity) ia;
			}
		}
		return null;
	}
}
