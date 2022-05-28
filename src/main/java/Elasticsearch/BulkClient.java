package Elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.indices.*;

import java.io.IOException;


public class BulkClient {
    ElasticsearchClient client = ElasticClient.getClientInstance();

    private boolean checkIfIndexExists (String index) throws IOException {
        var result = client.indices().exists(ExistsRequest.of(e->e.index(index)));
        return result.value();
    }
    void makeIndex (String index) throws IOException {
        if (!checkIfIndexExists(index)) {
            client.indices().create(i->i.index(index));
        }
    }
    void setMapping (String index) throws IOException {
        PutMappingRequest mappingRequest = new PutMappingRequest.Builder().index(index).build();
        mappingRequest.source().serialize("{\n" +
                " \"properties\": {\n" +
                "  \"id\": {\n" +
                "   \"type\":\"integer\"\n" +
                "  \"book_name\": {\n" +
                "   \"type\":\"text\"\n" +
                "  \"author\": {\n" +
                "   \"type\":\"text\"\n" +
                "  }\n" +
                " }\n" +
                "}", );


    }
    public void bulkIndex (String index) throws IOException {
        makeIndex(index);
    }
}
