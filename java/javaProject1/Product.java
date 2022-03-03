package javaProject1;

class Product {
    int prdNo;
    String prdName;
    int prdPrice;
    int prdYear;
    String prdMaker;

    Product() {}
    
    Product(int prdNo, String prdName, int prdPrice, int prdYear, String prdMaker) {
        this.prdNo = prdNo;
        this.prdName = prdName;
        this.prdPrice = prdPrice;
        this.prdYear = prdYear;
        this.prdMaker = prdMaker;
    }

    @Override
    public String toString(){ 
        return String.format("%03d", prdNo)+ "\t" + prdName + "\t" + prdPrice + "\t" + prdYear + "\t"  + prdMaker;
    }
}

