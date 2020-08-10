public class Faculty {
	private String name;
	private Cathedra[] cathedras = {};

	public Faculty(String name) {
		super();
		this.name = name;
	}

	public Cathedra[] getCathedras() {
		return cathedras;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addCathedra(Cathedra cathedra) {
		for (Cathedra c : cathedras) {
			if (c.getName().equals(cathedra.getName())) {
				System.out.println("Cathedra with name" + c.getName() + " already exist");
				return;
			}
		}
		Cathedra[] temp = new Cathedra[cathedras.length + 1];
		System.arraycopy(cathedras, 0, temp, 0, cathedras.length);
		temp[cathedras.length] = cathedra;
		cathedras = temp;
	}

	public void editCathedra(String cathedraName) {
		Cathedra cathedra = findCathedraByName(cathedraName);
		if (cathedra == null) {
			System.out.println("Cathedra " + cathedraName + " was not found");
			return;
		}
		String result = DataInput.getStr("Change name: ");
		cathedra.setName(result);
		System.out.println("Cathedra " + cathedraName + " was succesfully changed to " + result);
	}

	public void deleteCathedra(String cathedraName) {
		Cathedra cathedra = findCathedraByName(cathedraName);
		if (cathedra == null) {
			System.out.println("Cathedra " + cathedraName + " was not found");
			return;
		}
		Cathedra[] temp = new Cathedra[cathedras.length - 1];
		for (int i = 0, k = 0; i < cathedras.length; i++) {

			if (cathedras[i].equals(cathedra)) {
				System.out.println("Cathedra " + cathedraName + " was succesfully deleted");
				continue;

			}
			temp[k++] = cathedras[i];
		}
		cathedras = temp;

	}

	public Cathedra findCathedraByName(String cathedraName) {
		for (int i = 0; i < cathedras.length; i++) {
			if (cathedras[i].getName().equals(cathedraName)) {
				return cathedras[i];
			}
		}
		return null;
	}

	public boolean printAllCathedras() {
		if (cathedras.length != 0) {
			System.out.println("Cathedras: ");
		}
		for (int i = 0; i < cathedras.length; i++) {
			System.out.println(i + 1 + ". " + cathedras[i].getName());
		}
		return cathedras.length > 0;
	}

}
