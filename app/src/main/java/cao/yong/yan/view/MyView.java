package cao.yong.yan.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import cao.yong.yan.R;
import cao.yong.yan.bean.ChessPieces;

/**
 * Created by Administrator on 2017/10/26.
 */

public class MyView extends View {

    //定义一个画笔对象
    private Paint paint;
    //设置棋谱内边距
    private int padding=50;
    private String TAG="cyy";
    //棋子对象集合
    List<ChessPieces> chessPiecesList=new ArrayList<>();
    private int cnw;
    private int cnh;


    public MyView(Context context) {
        super(context);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //定义一个初始化方法
    public void init(){
        //创建一个画笔对象
        paint=new Paint();
        //设置画笔样式
        paint.setStyle(Paint.Style.STROKE);
        //设置抗锯齿
        paint.setAntiAlias(true);
        //设置画笔宽度
        paint.setStrokeWidth(15);
        //设置画笔颜色
        paint.setColor(getResources().getColor(R.color.colorPrimaryDark));
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawChessManual(canvas);
        initChessPieces();
        drawChessPieces(canvas);
    }


    //绘制棋谱
    private void drawChessManual(Canvas canvas) {
        //棋谱宽度
        int w=getWidth();
        //计算棋谱高度
        int h=(w/4)*6;

        //计算绘制宽度
        cnw = w-(padding*2);
        //计算绘制高度
        cnh = h-(padding*2);

        Log.i(TAG, "drawChessManual: 宽度："+(cnw /4)+"\t高度："+(cnh /6));
        int lineWidth=(cnw /4);
        int lineHeight=(cnh /6);

        //绘制棋谱的边框
        canvas.drawRect(padding,padding, cnw +padding, cnh +padding,paint);


        //设置棋谱内的线条宽度
        paint.setStrokeWidth(5);

        //绘制棋谱横线
        for (int i=0;i<6;i++) {
            if (i<2){
                continue;
            }
            canvas.drawLine(padding,(cnh /6)*i+padding, cnw +padding,(cnh /6)*i+padding,paint);
        }

        //绘制棋谱竖线
        for (int i=0;i<4;i++){
            canvas.drawLine((cnw /4)*i+padding,(cnh /6)*2+padding,(cnw /4)*i+padding, cnh +padding,paint);
        }

        //获取棋谱中心
        canvas.drawLine(padding,padding+(cnh /6)*2,padding+ cnw, cnh +padding,paint);
        canvas.drawLine(padding+ cnw,(cnh /6)*2+padding,padding, cnh +padding,paint);

        //绘制棋谱中心斜线
        canvas.drawLine(padding+(cnw /2),(cnh /6)*2+padding,padding,(cnh /6)*4+padding,paint);
        canvas.drawLine(padding+(cnw /2),(cnh /6)*2+padding,padding+ cnw,(cnh /6)*4+padding,paint);
        canvas.drawLine(padding,(cnh /6)*4+padding,padding+(cnw /2),padding+ cnh,paint);
        canvas.drawLine(padding+ cnw,(cnh /6)*4+padding,padding+(cnw /2),padding+ cnh,paint);

        //绘制庙
        canvas.drawLine(padding+(cnw /2),padding,(cnw /4)+padding,(cnh /6)*1+padding,paint);
        canvas.drawLine(padding+(cnw /2),padding,(cnw /4)*3+padding,(cnh /6)*1+padding,paint);
        canvas.drawLine(padding+(cnw /4),padding+(cnh /6),padding+(cnw /2),(cnh /6)*2+padding,paint);
        canvas.drawLine((cnw /4)*3+padding,padding+(cnh /6),padding+(cnw /2),(cnh /6)*2+padding,paint);
        canvas.drawLine((cnw /2)+padding,padding,padding+(cnw /2),(cnh /6)*2+padding,paint);
        canvas.drawLine((cnw /4)+padding,padding+(cnh /6),(cnw /4)*3+padding,padding+(cnh /6),paint);
    }

    //初始化棋子信息
    public void initChessPieces(){
        chessPiecesList.add(new ChessPieces((cnw/2)+padding,padding+(cnh)/6,0));
        for (int i=0;i<5;i++){
            if(i==0){
                for (int j=0;j<5;j++){
                    chessPiecesList.add(new ChessPieces((cnw/4)*j+padding,(cnh/6)*2+padding,1));
                }
                continue;
            }

            if(i==4){
                for (int j=0;j<5;j++){
                    chessPiecesList.add(new ChessPieces((cnw/4)*j+padding,(cnh)+padding,1));
                }
                continue;
            }

            for (int j=0;j<3;j++){
                for (int z=0;z<5;z++){
                    if (z==0||z==4) {
                        chessPiecesList.add(new ChessPieces((cnw / 4) * z + padding, (cnh / 6) * (j + 3) + padding, 1));
                    }
                }
            }
        }
    }

    //绘制棋子
    private void drawChessPieces(Canvas canvas){
        for (int i=0;i<chessPiecesList.size();i++){
            //获取一个棋子对象
            ChessPieces cp=chessPiecesList.get(i);
            Log.i(TAG, "drawChessPieces: "+cp.getX()+"\t"+cp.getY());
            //验证数据完整性
            if (cp!=null){
                if (cp.getStatus()==0){
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.BLACK);
                }else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(Color.RED);
                }
                canvas.drawCircle(cp.getX(),cp.getY(),30,paint);
            }
        }
    }



}
