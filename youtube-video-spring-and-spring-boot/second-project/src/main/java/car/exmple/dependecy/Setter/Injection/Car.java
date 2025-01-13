package car.exmple.dependecy.Setter.Injection;

public class Car {
	
	private Specification specification;
	
//	public Car(Specification specification) {
//		super();
//		this.specification = specification;
//	}
	
	public void setSpecification(Specification specification) {
		this.specification = specification;
	}
	
	public void displayDetails() {
		System.out.println("Car details:"+ specification.toString());
	}

}
