package car.exmple.bean;

public class MyBean {
	
	private String message;
	private String name;

	public void setName(String name) {
		this.name = name;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void showMessage() {
		System.out.println("Message:"+ message);
	}
	

	@Override
	public String toString() {
		return "MyBean [message=" + message + ", name=" + name + "]";
	}
	
	

}
