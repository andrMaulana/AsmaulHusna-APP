package com.example.asmaulhusna_app;

import java.util.List;

public class MainModel {

    private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public class Data {

        private int id;
        private String latin;
        private String arabic;
        private String terjemahan;
        private String keterangan;
        private String amalan;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLatin() {
            return latin;
        }

        public void setLatin(String latin) {
            this.latin = latin;
        }

        public String getArabic() {
            return arabic;
        }

        public void setArabic(String arabic) {
            this.arabic = arabic;
        }

        public String getTerjemahan() {
            return terjemahan;
        }

        public void setTerjemahan(String terjemahan) {
            this.terjemahan = terjemahan;
        }

        public String getKeterangan() {
            return keterangan;
        }

        public void setKeterangan(String keterangan) {
            this.keterangan = keterangan;
        }

        public String getAmalan() {
            return amalan;
        }

        public void setAmalan(String amalan) {
            this.amalan = amalan;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id=" + id +
                    ", latin='" + latin + '\'' +
                    ", arabic='" + arabic + '\'' +
                    ", terjemahan='" + terjemahan + '\'' +
                    ", keterangan='" + keterangan + '\'' +
                    ", amalan='" + amalan + '\'' +
                    '}';
        }
    }
}
