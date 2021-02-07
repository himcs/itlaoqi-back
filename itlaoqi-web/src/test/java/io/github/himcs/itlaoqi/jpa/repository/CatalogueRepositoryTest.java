package io.github.himcs.itlaoqi.jpa.repository;

import io.github.himcs.itlaoqi.jpa.entity.Catalogue;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author mcs [787632628@qq.com]
 */
@SpringBootTest
class CatalogueRepositoryTest {

  @Resource
  CatalogueRepository catalogueRepository;

  @Test
  void contextLoads() {
    Catalogue catalogue = new Catalogue();
    catalogue.setName("test");
    catalogue.setUrl("url");
    catalogueRepository.save(catalogue);
  }


}