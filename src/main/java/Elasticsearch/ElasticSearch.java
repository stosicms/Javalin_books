package Elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import io.javalin.http.Context;

public class ElasticSearch {
    ElasticsearchClient client = ElasticClient.getClientInstance();

    public void searchForBook (Context context) {

    }
}
