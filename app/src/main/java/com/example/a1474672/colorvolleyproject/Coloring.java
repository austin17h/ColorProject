package com.example.a1474672.colorvolleyproject;

public class Coloring {

        private int number;
        private int idnum;
        private String color;

        /* ------------------- */
    /*  CONSTRUCTOR
    /* ------------------- */

        public Coloring() {
        }

        public String getMyColor() {
            return color;
        }

        public void setMyColor(String myColor) {
            this.color = myColor;
        }

        public int getIdNum() {
            return idnum;
        }

        public void setIdNum(int idNum) {
            this.idnum = idNum;
        }

        public String getIdNumString() {
            return String.valueOf(idnum);
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getNumberString() {
            return String.valueOf(number);
        }
    }
