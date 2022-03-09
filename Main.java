package aa;

public class Main {

	public static void main(String[] args) {
		Vernoi vn = new Vernoi(1000,100);

		vn.render();
		
		vn.save("Vernoi.png");
	}

}
