package tck.cn.news.model;

/**
 * Description :
 * <p>
 * Created by tck on 2016/10/22.
 */

public class ArrayBean {

    /**
     * dailyTime : 2014-09-05 13:50:43
     * id : 77
     * lastUpdateTime : 2014-09-05 14:23:56
     * reviewNum : 0
     */

    private String dailyTime;
    private int id;
    private String lastUpdateTime;
    private int reviewNum;

    public String getDailyTime() {
        return dailyTime;
    }

    public void setDailyTime(String dailyTime) {
        this.dailyTime = dailyTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public int getReviewNum() {
        return reviewNum;
    }

    public void setReviewNum(int reviewNum) {
        this.reviewNum = reviewNum;
    }
}
