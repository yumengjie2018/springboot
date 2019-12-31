package com.example.service.entity.response;

import com.github.pagehelper.Page;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * title：PageData
 * description:
 *
 * @author yumengjie
 * @date 2019/11/29 16:52
 */
@Data
public class PageData<T> {

    private int total = 0;

    private List<T> record=new ArrayList<>();

    public PageData(int total,List<T> record){
        this.record=record;
        this.total=total;
    }
    public PageData(long total,List<T> record){
        this.total=(int)total;
        this.record=record;
    }

    public static <T> PageData<T> creat(int total,List<T> record){
        return new PageData(total,record);
    }
    public static <T> PageData<T> creat(Long total,List<T> record){
        return new PageData<>(total,record);
    }


}