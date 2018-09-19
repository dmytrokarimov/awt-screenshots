package net.util.screenshot;

import java.awt.Component;
import java.awt.Window;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ScreenshotUtils {
	
	/**
	 * Get screenshots for all active windows of current application
	 */
	public static List<BufferedImage> captureAllActiveWindows() {
		return Arrays.stream(Window.getWindows())
			.filter(Window::isShowing)
			.map(w -> capture(w))
			.collect(Collectors.toList());
	}
	
	/**
	 * Capture screenshot of specific component, such as Window or some panel
	 */
	public static BufferedImage capture(Component component) {
		BufferedImage image = new BufferedImage(component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
		component.paintAll(image.getGraphics());
		return image;
	}
}
