package Elasticsearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.RestHighLevelClientBuilder;

public class ElasticClient {

    public static ElasticsearchClient getClientInstance () {
        RestClient restClient = RestClient.builder(
                new HttpHost("localhost", 9200)).build();

        RestHighLevelClient hlrc = new RestHighLevelClientBuilder(restClient).setApiCompatibilityMode(true).build();

        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        ElasticsearchClient client = new ElasticsearchClient(transport);
        return client;
    }
}
