package com.boco.jlappservice.entity.request;

import com.boco.jlappservice.enums.NETechnology;
import lombok.Data;

import java.util.ArrayList;

/**
 * title：GetAdjacentCellRequest
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 18:48
 */
@Data
public class GetAdjacentCellRequest {


    private NETechnology neTechnology;

    private String id;

    private ArrayList<NETechnology> nETechnologys;

    public NETechnology getNeTechnology() {
        return neTechnology;
    }

    public void setNeTechnology(NETechnology neTechnology) {
        this.neTechnology = neTechnology;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<NETechnology> getnETechnologys() {
        return nETechnologys;
    }

    public void setnETechnologys(ArrayList<NETechnology> nETechnologys) {
        this.nETechnologys = nETechnologys;
    }

}