
public class TestJson {
	
	public static void main(String[] args) {
		EjerciceJsonFormat ejerciceJsonFormat = new EjerciceJsonFormat();
		ejerciceJsonFormat.writeJson();
		ejerciceJsonFormat.listTransactions();
		ejerciceJsonFormat.sumAmount("1");
		ejerciceJsonFormat.searchUser("3");
	}

}
