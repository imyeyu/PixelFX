package net.imyeyu.px.service;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * 快速构造稍后执行
 * <br>示例:
 * <pre>
 * RunLater.time(1000).event(() -> {
 *     // TODO somthing
 * })
 * </pre>
 * 
 * @author 夜雨
 * @createdAt 2021-01-18 23:23:19
 *
 */
public class RunLater extends Service<Void> {
	
	private long delay = 0;
	
	protected Task<Void> createTask() {
		return new Task<Void>() {
			protected Void call() throws Exception {
				Thread.sleep(delay);
				return null;
			}
		};
	}
	
	/**
	 * 延时（毫秒）
	 * 
	 * @param delay
	 */
	public void setDelay(long delay) {
		this.delay = delay;
	}
	
	public void event(Event event) {
		this.setOnSucceeded(e -> event.handle());
		this.start();
	}
	
	public static RunLater time(long delay) {
		RunLater r = new RunLater();
		r.setDelay(delay);
		return r;
	}
	
	public static interface Event {
		void handle();
	}
}