package vn.com.itqnu.screenshot.utils;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

import com.github.sarxos.webcam.Webcam;

import vn.com.itqnu.screenshot.models.ScreenShotModel;

public class Screen2Image {

	static SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd hh mm ss a");

	public static void robo() throws Exception {
		System.setProperty("java.awt.headless", "false");
		String rootPath = System.getProperty("user.dir");
		Calendar now = Calendar.getInstance();
		Robot robot = new Robot();
		BufferedImage screenShot = robot
				.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		ImageIO.write(screenShot, "JPG",
				new File(rootPath + "\\src\\main\\resources\\images\\" + formatter.format(now.getTime()) + ".jpg"));
		System.out.println(formatter.format(now.getTime()));
	}

	public static void screenShot(ScreenShotModel screenShotModel) {
		Date dateFrom = new Date();
		Date dateTo = new Date(dateFrom.getTime() + (int) (screenShotModel.getTime() * 3600 * 1000));

		while (dateFrom.compareTo(dateTo) <= 0) {
			try {
				Screen2Image.robo();
				Screen2Image.takePicture();
				dateFrom = new Date();
				Thread.sleep(screenShotModel.getSpace() * 1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void takePicture() {
		Webcam webcam = Webcam.getDefault();
		webcam.open();
		try {
			String name = String.format("test-%d.jpg", System.currentTimeMillis());
			ImageIO.write(webcam.getImage(), "JPG", new File(name));
			System.out.format("File %s has been saved\n", name);
			webcam.close();
		} catch (IOException t) {
			t.printStackTrace();
		}
	}
}
