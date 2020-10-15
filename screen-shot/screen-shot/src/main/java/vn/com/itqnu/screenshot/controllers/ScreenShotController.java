package vn.com.itqnu.screenshot.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.com.itqnu.screenshot.models.ScreenShotModel;
import vn.com.itqnu.screenshot.utils.Screen2Image;

@RestController
@RequestMapping("/api/v1/screen-shot")
public class ScreenShotController {

//	@GetMapping
//	public ResponseEntity<?> getScreenShot() {
//		return ResponseEntity.ok("Hihi");
//	}

	@GetMapping
	public ResponseEntity<?> screenShot(
			@RequestBody ScreenShotModel screenShotModel, HttpStatus status) {
		try {
			Screen2Image.screenShot(screenShotModel);
			return ResponseEntity.ok("Success!");
		} catch (Exception e) {
			return ResponseEntity.status(status.BAD_REQUEST).body(e.getMessage());
		}
	}
}
