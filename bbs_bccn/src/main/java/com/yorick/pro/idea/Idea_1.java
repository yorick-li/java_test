package com.yorick.pro.idea;

import com.yorick.pro.java_test.java_base.reflection.util.FieldUtils;

public class Idea_1 {

    private String test = "$GPRMC,024813.640,A,3158.4608,N,11848.3737,E,10.05,324.27,150706,,,A*50";
    static String[] fieldName = {"first", "utcTime", "status", "weidu", "weiduFangXiang", "jingdu", "jingduFangXiang", "speed",
            "fangweiJiao", "utcDate", "cipianjiao", "cipianjiaoFX", "jiaoyanzhi"};

    public static void main(String[] args) {

    }

    public static boolean verify(GPRMC grc) {
        Long verifyNum = null;
        for (int idx = 0; idx < fieldName.length; idx++) {

        }
        return false;
    }

    private static GPRMC pack(String cprmc) {
        String[] split = cprmc.split(",");
        GPRMC grc = new GPRMC();
        for (int idx = 0; idx < split.length; idx ++) {
            String value = split[0];
            FieldUtils.setFieldVal(grc, fieldName[idx], value);
        }
        return grc;
    }

}

class GPRMC {

    /**
     * 字段0：$GPRMC，语句ID，
     * 表明该语句为Recommended Minimum Specific GPS/TRANSIT Data（RMC）
     * 推荐最小定位信息
     */
    private String first = "$GPRMC";
    /**
     * UTC时间，hhmmss.sss格式
     */
    private String utcTime;

    /**
     * 状态，A=定位，V=未定位
     */
    private String status;
    /**
     * 纬度ddmm.mmmm，度分格式（前导位数不足则补0）
     */
    private String weidu;
    /**
     * 纬度N（北纬）或S（南纬）
     */
    private String weiduFangXiang;
    /**
     * 经度dddmm.mmmm，度分格式（前导位数不足则补0）
     */
    private String jingdu;
    /**
     * 经度E（东经）或W（西经）
     */
    private String jingduFangXiang;
    /**
     * 速度，节，Knots
     */
    private String speed;
    /**
     * 方位角，度
     */
    private String fangweiJiao;
    /**
     * UTC日期，DDMMYY格式
     */
    private String utcDate;
    /**
     * 磁偏角，（000 - 180）度（前导位数不足则补0）
     */
    private String cipianjiao;
    /**
     * 磁偏角方向，E=东W=西
     */
    private String cipianjiaoFX;
    /**
     * 校验值
     */
    private String jiaoyanzhi;

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getUtcTime() {
        return utcTime;
    }

    public void setUtcTime(String utcTime) {
        this.utcTime = utcTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWeidu() {
        return weidu;
    }

    public void setWeidu(String weidu) {
        this.weidu = weidu;
    }

    public String getWeiduFangXiang() {
        return weiduFangXiang;
    }

    public void setWeiduFangXiang(String weiduFangXiang) {
        this.weiduFangXiang = weiduFangXiang;
    }

    public String getJingdu() {
        return jingdu;
    }

    public void setJingdu(String jingdu) {
        this.jingdu = jingdu;
    }

    public String getJingduFangXiang() {
        return jingduFangXiang;
    }

    public void setJingduFangXiang(String jingduFangXiang) {
        this.jingduFangXiang = jingduFangXiang;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getFangweiJiao() {
        return fangweiJiao;
    }

    public void setFangweiJiao(String fangweiJiao) {
        this.fangweiJiao = fangweiJiao;
    }

    public String getUtcDate() {
        return utcDate;
    }

    public void setUtcDate(String utcDate) {
        this.utcDate = utcDate;
    }

    public String getCipianjiao() {
        return cipianjiao;
    }

    public void setCipianjiao(String cipianjiao) {
        this.cipianjiao = cipianjiao;
    }

    public String getCipianjiaoFX() {
        return cipianjiaoFX;
    }

    public void setCipianjiaoFX(String cipianjiaoFX) {
        this.cipianjiaoFX = cipianjiaoFX;
    }

    public String getJiaoyanzhi() {
        return jiaoyanzhi;
    }

    public void setJiaoyanzhi(String jiaoyanzhi) {
        this.jiaoyanzhi = jiaoyanzhi;
    }
}
