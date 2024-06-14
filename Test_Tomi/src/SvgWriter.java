import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class SvgWriter implements ExportPolygons {

	@Override
	public void exportIt(List<Polygon> listToExport, String filename) {
		try {
			String header = """
					<!DOCTYPE html>
					<html>
					<body>
					<h1>SVG Export</h1>
					<svg width="300" height="300" axmlns="http://www.w3.org/2000/svg">
					""";
			Path path = Files.writeString(Path.of(filename), header, StandardOpenOption.CREATE_NEW);
			listToExport.stream().forEach(p0 -> {
				try {
					StringBuilder polygon = new StringBuilder("<polygon stroke=\"black\" points=\"");
					List<Point> points = p0.getPoints();
					points.stream().forEach(p -> {
						polygon.append(p.getX()).append(",").append(p.getY()).append(" ");
					});
					polygon.append("\" />");
					Files.writeString(path, polygon, StandardOpenOption.APPEND);
				} catch (Exception e) {
				}
			});
			String end = """
					Sorry, your browser does not support inline svg.
					</svg>
					</body>
					</html>
					""";
			Files.writeString(path, end, StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
