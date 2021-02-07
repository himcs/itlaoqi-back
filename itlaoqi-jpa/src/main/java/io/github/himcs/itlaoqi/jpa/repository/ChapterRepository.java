package io.github.himcs.itlaoqi.jpa.repository;

import io.github.himcs.itlaoqi.jpa.entity.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ChapterRepository extends JpaRepository<Chapter, Integer>,
    JpaSpecificationExecutor<Chapter> {

}