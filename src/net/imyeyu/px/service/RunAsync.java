package net.imyeyu.px.service;

import javafx.concurrent.Service;
import javafx.concurrent.Task;

/**
 * 异步执行
 * <br>示例:
 * <pre>
 * new RunAsync<String> {
 * 
 *     public String todo() throws Exception {
 *         // 这里不是 FX 线程，可以执行一些长时间的事情
 *     }
 *     
 *     public void onFinish(String t) {
 *         // 参数是 todo() 执行的返回结果，这里是 FX 线程，可以操作 UI
 *     }
 * }.start();
 * </pre>
 * 
 * @author 夜雨
 * @createdAt 2021-02-06 13:26:25
 *
 * @param <T>
 */
public abstract class RunAsync<T> extends Service<T> {
	
	public RunAsync() {
		valueProperty().addListener((obs, o, t) -> onFinish(t));
	}
	
	protected Task<T> createTask() {
		return new Task<T>() {
			protected T call() throws Exception {
				return todo();
			}
		};
	}

	/**
	 * 执行事件（非 FX 线程）
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract T todo() throws Exception;
	
	/**
	 * 完成事件（FX 线程）
	 * 
	 * @param t 执行事件返回值
	 */
	public abstract void onFinish(T t);
}