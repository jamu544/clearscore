package android.com.jumpco.io.clearscore.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ClearScoreModel {
    @SerializedName("accountIDVStatus")
    public String accountIDVStatus;
    @SerializedName("creditReportInfo")
    @Expose
    public Score scoremodel;

    public class Score {
        @SerializedName("score")
        public int score;
        @SerializedName("maxScoreValue")
        public int maxScoreValue;
    }

//    public boolean isAccountIDStatus() {
//        return accountIDStatus;
//    }
//
//    public void setAccountIDStatus(boolean accountIDStatus) {
//        this.accountIDStatus = accountIDStatus;
//    }
//
//    private boolean accountIDStatus;
//
//
//    public int getScore() {
//        return score;
//    }
//
//    public void setScore(int score) {
//        this.score = score;
//    }
//
//    public int getMaxScoreValue() {
//        return maxScoreValue;
//    }
//
//    public void setMaxScoreValue(int maxScoreValue) {
//        this.maxScoreValue = maxScoreValue;
//    }
}
