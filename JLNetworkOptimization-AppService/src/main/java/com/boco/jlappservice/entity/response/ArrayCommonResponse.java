package com.boco.jlappservice.entity.response;

import java.util.ArrayList;

/**
 * title：ArrayCommonResponse
 * description:
 *
 * @author yumengjie
 * @date 2020/3/7 19:48
 */

public class ArrayCommonResponse<T> {


    private ArrayList<T> resultAll;

    //室分小区集合
    private ArrayList<T> resultRoomCells;

    //室外站
    private ArrayList<T> resultOutdoorCells;

    private ArrayList<T> result;


    public ArrayList<T> getResultAll() {
        return resultAll;
    }

    public void setResultAll(ArrayList<T> resultAll) {
        this.resultAll = resultAll;
    }

    public ArrayList<T> getResultRoomCells() {
        return resultRoomCells;
    }

    public void setResultRoomCells(ArrayList<T> resultRoomCells) {
        this.resultRoomCells = resultRoomCells;
    }

    public ArrayList<T> getResultOutdoorCells() {
        return resultOutdoorCells;
    }

    public void setResultOutdoorCells(ArrayList<T> resultOutdoorCells) {
        this.resultOutdoorCells = resultOutdoorCells;
    }

    public ArrayList<T> getResult() {
        return result;
    }

    public void setResult(ArrayList<T> result) {
        this.result = result;
    }

}