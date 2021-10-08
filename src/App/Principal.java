package App;

public class Principal {

	public static void main(String[] args) {
		Vista v = new Vista();
		Model m = new Model();
		Controlador c = new Controlador(m, v);
	}

}
