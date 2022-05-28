import Elasticsearch.BulkClient;
import Elasticsearch.ElasticClient;
import io.javalin.Javalin;

public class Application {
    public static void main(String[] args) {
        Javalin app = Javalin.create().start(3000);

        app.get("/test", ctx->{new BulkClient().bulkIndex("test");});
    }
}
