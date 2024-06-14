import java.util.List;

public interface ImportPolygons {
    List<Polygon> importIt(String filename) throws ToFewPointsForPolygonException;
}
