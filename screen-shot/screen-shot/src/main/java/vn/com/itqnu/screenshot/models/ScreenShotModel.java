package vn.com.itqnu.screenshot.models;

public class ScreenShotModel {

	private float time;
	private int space;

	public ScreenShotModel() {
	}

	public ScreenShotModel(float time, int space) {
		this.time = time;
		this.space = space;
	}

	public float getTime() {
		return time;
	}

	public void setTime(float time) {
		this.time = time;
	}

	public int getSpace() {
		return space;
	}

	public void setSpace(int space) {
		this.space = space;
	}

}
