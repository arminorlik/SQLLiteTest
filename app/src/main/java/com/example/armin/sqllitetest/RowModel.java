package com.example.armin.sqllitetest;

/**
 * Created by Armin on 2017-04-12.
 */

class RowModel {
    public RowModel(String one, String two, String three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    String one;
    String two;

    public String getOne() {
        return one;
    }

    public void setOne(String one) {
        this.one = one;
    }

    public String getTwo() {
        return two;
    }

    public void setTwo(String two) {
        this.two = two;
    }

    public String getThree() {
        return three;
    }

    public void setThree(String three) {
        this.three = three;
    }

    String three;
}
