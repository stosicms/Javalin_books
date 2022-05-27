package Elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import co.elastic.clients.elasticsearch.indices.ExistsRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.xcontent.XContentBuilder;

import java.io.IOException;

public class BulkClient {
    ElasticsearchClient client = ElasticClient.getClientInstance();

    private boolean checkIfIndexExists (String index) throws IOException {
        var result = client.indices().exists(ExistsRequest.of(e->e.index(index)));
        return result.value();
    }
    void makeIndex (String index) throws IOException {
        if (!checkIfIndexExists(index)) {
            CreateIndexRequest indexRequest = new CreateIndexRequest(index);

            CreateIndexResponse createIndexResponse = this.client.indices().create(indexRequest, RequestOptions.DEFAULT);
        }
    }
}
