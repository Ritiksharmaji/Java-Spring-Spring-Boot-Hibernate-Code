package car.exmple.dependecy.constructor.injection;

public class Car {
	
	private Specification specification;
	
	public Car(Specification specification) {
		super();
		this.specification = specification;
	}

	public void displayDetails() {
		System.out.println("Car details:"+ specification.toString());
	}

}
