
public class PolygonExample {

	public static void main(String[] args) {
		PolygonReader polygonReader = new PolygonReader();
		try {
			System.out.println(polygonReader.importIt("daten.txt"));
		} catch (ToFewPointsForPolygonException e) {
			e.printStackTrace();
		}

	}

}
