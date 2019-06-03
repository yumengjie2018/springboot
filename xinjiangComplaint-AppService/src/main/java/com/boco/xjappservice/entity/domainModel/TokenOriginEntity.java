package com.boco.xjappservice.entity.domainModel;

import lombok.Data;

import java.io.Serializable;

/**
 * 参与生成token计算的属性
 * @author pangkang
 * 2018-1-23 14:48:39
 */
@Data
public class TokenOriginEntity implements Serializable {


	private static final long serialVersionUID = -4522408803603874173L;
	private String name;
	public String deviceId;
	private String date;

}
