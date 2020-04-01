package com.boco.jlappservice.utility;

import com.boco.jlappservice.entity.domainModel.Cell;
import com.boco.jlappservice.entity.domainModel.GeoCell;


import java.util.ArrayList;

/**
 * title：BaiduOffsetUtil
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 17:02
 */

public class BaiduOffsetUtil {


    public ArrayList<GeoCell> SetBaiduOffset(ArrayList<GeoCell> list) {
//		BocoPoint2D baidu = null;
//
//		for (int i = 0; i < list.size(); i++) {
//
//			try {
//				ServiceUtils.initClient();
//				baidu = ServiceUtils.getBO(IBaiduTransformBO.class)
//						.gpsToBaiduComplex(list.get(i).getBaiduLongitude(), list.get(
//										i).getBaiduLatitude());
//				System.out.println("gps---------------->"+baidu.getX()+","+baidu.getY());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			BigDecimal y = new BigDecimal(baidu.getY());
//			double y1 = y.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
//			BigDecimal x = new BigDecimal(baidu.getX());
//			double x1 = x.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
//
//			list.get(i).setBaiduLatitude(y1);
//			list.get(i).setBaiduLongitude(x1);
//		}
        return list;
    }

    public ArrayList<Cell> SetBaiduOffset1(ArrayList<Cell> list) {
//		BocoPoint2D baidu = null;
//
//		for (int i = 0; i < list.size(); i++) {
//
//			try {
//				ServiceUtils.initClient();
//
//				baidu = ServiceUtils.getBO(IBaiduTransformBO.class)
//						.gpsToBaiduComplex(list.get(i).getBaiduLongitude(), list.get(
//										i).getBaiduLatitude());
//
//				//System.out.println("gps---------------->"+baidu.getX()+","+baidu.getY());
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			BigDecimal y = new BigDecimal(baidu.getY());
//			double y1 = y.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
//			BigDecimal x = new BigDecimal(baidu.getX());
//			double x1 = x.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
//
//			list.get(i).setBaiduLatitude(y1);
//			list.get(i).setBaiduLongitude(x1);
//		}
        return list;
    }

    public GeoCell SetBaiduOffsetByLonLat(GeoCell geoCell) {
//		BocoPoint2D baidu = null;
//
//		try {
//			ServiceUtils.initClient();
//
//			baidu = ServiceUtils.getBO(IBaiduTransformBO.class)
//					.gpsToBaiduComplex(geoCell.getBaiduLongitude(), geoCell.getBaiduLatitude());
//
//			//System.out.println("gps---------------->"+baidu.getX()+","+baidu.getY());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		BigDecimal y = new BigDecimal(baidu.getY());
//		double y1 = y.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
//		BigDecimal x = new BigDecimal(baidu.getX());
//		double x1 = x.setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
//
//		geoCell.setBaiduLatitude(y1);
//		geoCell.setBaiduLongitude(x1);

        return geoCell;
    }
}