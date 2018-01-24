package com.yidian.buyer.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yidian.buyer.R;

/**
 * Created by miao on 2017/7/12.
 * 分享的dialog
 */

public class ShareDialog extends Dialog {

    private ImageView QRCode;
    private LinearLayout wechat;
    private LinearLayout wechatcircle;
    private LinearLayout weibo;
    private LinearLayout savepicture;
    private TextView cancle;
    private View view;
    private Context context;

    public ShareDialog(Context context) {
        super(context,R.style.ShareDialog);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_dialog);
        //初始化数据
        initView();
        //设置位置和大小
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = getContext().getResources().getDisplayMetrics(); // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 0.95); // 宽度设置为屏幕的0.8
        lp.y = (int) (d.heightPixels * 1);//设置宽度
        dialogWindow.setAttributes(lp);
        dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL);
        //设置监听
        initListener();
    }

    private void initView() {
        QRCode = (ImageView) findViewById(R.id.QRCode);
        wechat = (LinearLayout) findViewById(R.id.wechat);
        wechatcircle = (LinearLayout) findViewById(R.id.wechatcircle);
        weibo = (LinearLayout) findViewById(R.id.weibo);
        savepicture = (LinearLayout) findViewById(R.id.savepicture);
        cancle = (TextView) findViewById(R.id.cancle);
        view = findViewById(R.id.view);

        view.getBackground().setAlpha(100);
        view.setBackgroundColor(Color.TRANSPARENT);
    }

    public void setImageVisible(){
        if(QRCode!=null) {
            QRCode.setVisibility(View.VISIBLE);
        }
    }

    public void setImageGone(){
        if(QRCode!=null) {
            QRCode.setVisibility(View.GONE);
        }
    }

    public void setVisible() {
        if (savepicture != null) {
            savepicture.setVisibility(View.VISIBLE);
        }
    }

    public void setViewGone() {
        if (savepicture != null) {
            savepicture.setVisibility(View.GONE);
        }
    }

    public void setImageView(String url){
        if(QRCode!=null) {
            Glide.with(context).load(url).into(QRCode);
        }
    }

    private void initListener() {
        QRCode.setVisibility(View.VISIBLE);
        QRCode.setVisibility(View.GONE);
        QRCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickShareListener != null) {
                    onClickShareListener.onClickQrCode();
                }
            }
        });
        wechat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickShareListener != null) {
                    onClickShareListener.onClickWechat();
                }
            }
        });
        wechatcircle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickShareListener != null) {
                    onClickShareListener.onClickWechatCircle();
                }
            }
        });
        weibo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickShareListener != null) {
                    onClickShareListener.onClickWeibo();
                }
            }
        });
        savepicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickShareListener != null) {
                    onClickShareListener.onClickSavePicture();
                }
            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickShareListener != null) {
                    onClickShareListener.onClickCancle();
                }
            }
        });
    }

    public interface onClickShareListener {
        void onClickQrCode();

        void onClickWechat();

        void onClickWechatCircle();

        void onClickWeibo();

        void onClickSavePicture();

        void onClickCancle();
    }

    public onClickShareListener onClickShareListener;

    public void setOnClickShareListener(ShareDialog.onClickShareListener onClickShareListener) {
        this.onClickShareListener = onClickShareListener;
    }
}
