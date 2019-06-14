package com.example.Restaurant.domain;

public class WhiteSpaceReport {

    private int cellIni = 0;
    private int cellEnd = 1;
    private int lineIni = 0;
    private int lineEnd = 1;

    public int getCellIni() {
        return cellIni;
    }

    public void setCellIni(int cellIni) {
        this.cellIni = cellIni;
    }

    public int getCellEnd() {
        return cellEnd;
    }

    public void setCellEnd(int cellEnd) {
        this.cellEnd = cellEnd;
    }

    public int getLineIni() {
        return lineIni;
    }

    public void setLineIni(int lineIni) {
        this.lineIni = lineIni;
    }

    public int getLineEnd() {
        return lineEnd;
    }

    public void setLineEnd(int lineEnd) {
        this.lineEnd = lineEnd;
    }

    private WhiteSpaceReport(){ }

    public static class Build{

        private WhiteSpaceReport whiteSpaceReport = new WhiteSpaceReport();

        public Build setCellIni(int cellIni) {
            this.whiteSpaceReport.cellIni = cellIni;
            return this;
        }

        public Build setCellEnd(int cellEnd) {
            this.whiteSpaceReport.cellEnd = cellEnd;
            return this;
        }

        public Build setLineIni(int lineIni) {
            this.whiteSpaceReport.lineIni = lineIni;
            return this;
        }

        public Build setLineEnd(int lineEnd) {
            this.whiteSpaceReport.lineEnd = lineEnd;
            return this;
        }

        public WhiteSpaceReport create(){
            return this.whiteSpaceReport;
        }
    }

}
