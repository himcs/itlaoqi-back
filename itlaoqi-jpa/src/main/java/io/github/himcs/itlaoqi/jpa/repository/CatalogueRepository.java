package io.github.himcs.itlaoqi.jpa.repository;

import io.github.himcs.itlaoqi.jpa.entity.Catalogue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CatalogueRepository extends JpaRepository<Catalogue, Integer>,
    JpaSpecificationExecutor<Catalogue> {

}