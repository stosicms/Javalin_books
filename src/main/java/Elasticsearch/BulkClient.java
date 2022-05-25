package Elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.ExistsRequest;
import co.elastic.clients.transport.endpoints.BooleanResponse;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class BulkClient {
    ElasticsearchClient client = ElasticClient.getClientInstance();

    private RestHighLevelClient checkIfIndexExists () throws IOException {
         result = client.indices().exists(ExistsRequest.of(e->e.index("books")));
        return result;
    }
    private void makeIndex() throws IOException {
        if (checkIfIndexExists()) {
    }
}
