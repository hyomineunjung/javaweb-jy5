package com.itdr.pojo;

public class Order {
    private String spid;
    private String zfje;
    private String zfzt;
    private String zffs;
    private String ddzt;


    public String getSpid() {
        return spid;
    }

    public void setSpid(String spid) {
        this.spid = spid;
    }

    public String getZfje() {
        return zfje;
    }

    public void setZfje(String zfje) {
        this.zfje = zfje;
    }

    public String getZfzt() {
        return zfzt;
    }

    public void setZfzt(String zfzt) {
        this.zfzt = zfzt;
    }

    public String getZffs() {
        return zffs;
    }

    public void setZffs(String zffs) {
        this.zffs = zffs;
    }

    public String getDdzt() {
        return ddzt;
    }

    public void setDdzt(String ddzt) {
        this.ddzt = ddzt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "spid='" + spid + '\'' +
                ", zfje='" + zfje + '\'' +
                ", zfzt='" + zfzt + '\'' +
                ", zffs='" + zffs + '\'' +
                ", ddzt='" + ddzt + '\'' +
                '}';
    }
}
