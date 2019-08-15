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

	@Query("SELECT c FROM CD c where c.cdPrice between ?1 and ?2") 
	List<CD> findByPriceRange(Double startingPrice, Double endingPrice);

	@Query("SELECT c FROM CD c where c.cdPrice between :sPrice and :ePrice") 
	List<CD> findByPriceRangeNamedParams(@Param("sPrice") Double startingPrice,
			@Param("ePrice") Double endingPrice);

	@Query("SELECT c FROM CD c where c.cdTitle like %:title%")
	List<CD> findByTitleMatch(@Param("title") String title);

	@Query(value = "SELECT * FROM cd c where c.cd_title like %:title%", nativeQuery = true)
	List<CD> findByTitleMatchNative(@Param("title") String title);

	@Query(value = "SELECT * FROM cd c ORDER BY c.cd_title ASC, c.cd_price DESC", nativeQuery = true) 
	List<CD> findAllSorted();

	List<CD> findByCdPrice(@Param("price") Double price);

	int countByCdPrice(@Param("price") Double price);

}
