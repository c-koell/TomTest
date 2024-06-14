import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolygonReader implements ImportPolygons {

	@Override
	public List<Polygon> importIt(String filename) throws ToFewPointsForPolygonException {
		List<Polygon> polygons = new ArrayList<Polygon>();
		try {
			List<String> allLines = Files.readAllLines(Path.of(filename));
			int zeile = 1;
			for (String line : allLines) {
				List<Point> points = new ArrayList<Point>();
				String[] values = line.split(",");
				List<String> valuesList = new ArrayList<String>(Arrays.asList(values));
				if (values.length < 6) {
					throw new ToFewPointsForPolygonException("In Zeile " + zeile
							+ " aus der Importdatei sind zu wenige Punkte angegeben. Für ein Polygon müssen mindestens 3 Punkte vorhanden sein");
				}
				do {
					String xCoordinate = valuesList.remove(0);
					String yCoordinate = valuesList.remove(0);
					points.add(new Point(Integer.valueOf(xCoordinate), Integer.valueOf(yCoordinate)));
				} while (!valuesList.isEmpty());
				Polygon polygon = new Polygon(points);
				polygons.add(polygon);
				zeile++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return polygons;
	}

}
