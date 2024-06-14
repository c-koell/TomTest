import java.util.List;

public class PolygonExample {

	public static void main(String[] args) {
		PolygonReader polygonReader = new PolygonReader();
		try {
			List<Polygon> list = polygonReader.importIt("daten.txt");
			System.out.println(list);
			SvgWriter svgWriter = new SvgWriter();
			//svgWriter.exportIt(list, "dummy.html");
		} catch (ToFewPointsForPolygonException e) {
			e.printStackTrace();
		}

	}

}
