import java.util.List;

public abstract class PolygonConverter
{
    private final ImportPolygons importer;
    private final ExportPolygons exporter;
    private final List<Polygon> polygons;
    public PolygonConverter(List<Polygon> polygons, ImportPolygons importer, ExportPolygons exporter){
        this.polygons = polygons;
        this.importer = importer;
        this.exporter = exporter;
    }
    public final void convert(String fromFilename, String toFilename){
        try {
            exporter.exportIt(transform(filter(importer.importIt(fromFilename))),toFilename);
        }
        catch(ToFewPointsForPolygonException exception){
            System.out.println(exception.getMessage());
        }
    }
    public abstract List<Polygon> filter(List<Polygon> unfilteredList);
    public abstract List<Polygon> transform(List<Polygon> unfilteredList);
}

