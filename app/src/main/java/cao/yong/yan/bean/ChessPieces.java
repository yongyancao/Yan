package cao.yong.yan.bean;

/**
 * Created by Administrator on 2017/10/26.
 * 棋子类
 */

public class ChessPieces {
    private int x;//x坐标
    private int y;//y坐标
    private int status;//0表示和尚，1表示兵

    public ChessPieces(int x, int y, int status) {
        this.x = x;
        this.y = y;
        this.status = status;
    }


    public ChessPieces() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
