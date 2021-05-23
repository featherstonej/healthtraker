package com.example.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.GlucoseReading;
import com.example.models.User;

/*
 * This annotation tells Spring that this class contains
 * methods that need to be setup as database transactions.
 */
@Transactional
@Repository("glucoseReadingDao")
/*
 * Extending the CrudRepository gives us access to some
 * basic generic methods for retrieving data from the 
 * database
 */
public interface GlucoseReadingDao extends CrudRepository<GlucoseReading, Integer> {
	// Generic methods for data retrieval
	public List<GlucoseReading> findAll();
	/*
	 * This method allows you to set the column to find a record.
	 * The syntax is findBy[field from model]
	 */
	public List<GlucoseReading> findByUserHolder(User user);
	
	// This method allow us to use a custom sql statement
	@Modifying
	// This is the query we want to use instead of a generic one
	@Query(value="with months as (\r\n" + 
			"	SELECT generate_series(1, 12) as month, :userid as fk_userid \r\n" + 
			")\r\n" + 
			"select case \r\n" + 
			"		when floor(avg(b2.glucosereading)) is null then 0 \r\n" + 
			"			else floor(avg(b2.glucosereading)) end as avg_sys, m.month\r\n" + 
			"from glucosereadings b2 right outer join months m on extract (month from b2.readingdate ) = m.month and b2.fk_userid = m.fk_userid\r\n" + 
			"group by m.month order by m.month;", nativeQuery=true)
	// Using the @Param annotation we can set any query parameters
	public List<Integer> monSugarAverage(@Param("userid") int userid);

}