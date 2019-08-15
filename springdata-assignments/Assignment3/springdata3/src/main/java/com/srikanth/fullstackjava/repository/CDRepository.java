package com.srikanth.fullstackjava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.srikanth.fullstackjava.model.CD;

@Repository
public interface CDRepository extends JpaRepository<CD, Long> {

	List<CD> findByCdTitle(String cdTitle);
	List<CD> findByCdPublisher(String cdPublisher);

	@Modifying
	@Query("UPDATE CD c SET c.cdTitle = :cdTitle, c.cdPrice = :cdPrice, "
			+ "c.cdPublisher = :cdPublisher WHERE c.cdId = :cdId")
	int updateCD(@Param("cdId") Long cdId, @Param("cdTitle") String cdTitle, 
			@Param("cdPrice") Double cdPrice, @Param("cdPublisher") String cdPublisher);

}
