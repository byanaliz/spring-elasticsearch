package com.elasticSearch.Elastic.Search.respository;

import com.elasticSearch.Elastic.Search.entity.Product;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<Product> getByCustomQuery(String search);

    List<Product>  findByNameLikeOrCodeLike(String name, String code);
}
