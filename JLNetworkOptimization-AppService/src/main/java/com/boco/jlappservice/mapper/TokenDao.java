package com.boco.jlappservice.mapper;

import com.boco.jlappservice.entity.domainModel.TokenEntity;
import org.springframework.stereotype.Repository;

/**
 * token service
 * @author pangkang
 * 2018-1-25 14:14:44
 *
 */
@Repository
public interface TokenDao {
	void saveToken(TokenEntity tokenEntity);

	String getToken(String userId);

}
