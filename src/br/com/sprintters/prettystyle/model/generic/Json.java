package br.com.sprintters.prettystyle.model.generic;

import java.util.ArrayList;

public class Json {
	private boolean success;
	private String message;
	private ArrayList<Object> data;
	
	public Json() {
		this.success = false;
		this.message = "";
		this.data = null;
	}
	
	public Json(boolean success, String message, Object data) {
		this.success = success;
		this.message = message;
		this.data = new ArrayList<Object>();
		this.data.add(data);
	}
	
	public Json(boolean success, String message, ArrayList<Object> data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ArrayList<Object> getData() {
		return data;
	}
	
	public void setData(ArrayList<Object> data) {
		this.data = data;
	}
}
