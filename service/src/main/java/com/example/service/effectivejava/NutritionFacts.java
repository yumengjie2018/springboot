package com.example.service.effectivejava;

/**
 * title：NutritionFacts
 * description:
 *
 * @author yumengjie
 * @date 2019/2/19 11:07
 */

public class NutritionFacts {

//    private final int servingSize;
//
//    private final int servings;
//
//    private final int calories;
//
//    private final int fat;
//
//    private final int sodium;
//
//    private final int catbohydrate;

    public static class Builder{
        private final int servingSize;

        private final int servings;

        private  int calories=0;

        private  int fat=0;

        private  int sodium=0;

        private  int catbohydrate=0;

        public  Builder(int servingSize,int servings){
            this.servings=servings;
            this.servingSize=servingSize;
        }
        public Builder colories(int val){
//            colories=val;
            return this;
        }
    }

}