package com.ui.fragment;

import android.content.Context;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lifecycle.launchmode.R;


/**
 * 通用，切换tab栏
 */
public class FooterViewMenu extends LinearLayout {
    //菜单文案id
    private int[] itemStrsDef = {
            R.string.str_bottom_a,
            R.string.str_bottom_b,
            R.string.str_bottom_c,
            R.string.str_bottom_d,
    };

    //菜单的图标id(普通状态);
    private int[] itemIconNormalDef = {
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
            R.mipmap.ic_launcher,
    };

    //菜单的图标id(选中状态)
    private int[] itemIconSelectedDef = {
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
    };

    private FooterViewMenuItem[] itemViews;

    private OnMenuItemListener itemListener;

    private int POSITION_DEFAULT = 0;//初始显示位置
    private int POSITION_INVALID = -1;//无效位置


    private int mCurrentItem = POSITION_INVALID;//记录当前所展示的item的位置索引
    private int mPreItem = POSITION_INVALID;//记录上一次所展示的item的位置索引

    public FooterViewMenu(Context context) {
        this(context, null);
    }

    public FooterViewMenu(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FooterViewMenu(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    private void initLayout(Context context) {
        setOrientation(HORIZONTAL);
        setBackgroundColor(context.getResources().getColor(R.color.white));
        initFooterVews(true);
    }

    /**
     * 初始化菜单
     *
     * @param defValue 菜单项是否是内部默认值
     */
    public void initFooterVews(boolean defValue) {
        if (!defValue) {
            removeAllViews();
        }
        final int count = itemStrsDef.length;
        itemViews = new FooterViewMenuItem[count];
        for (int i = 0; i < count; i++) {
            final int position = i;
            FooterViewMenuItem itemView = new FooterViewMenuItem(getContext());
            itemView.setText(itemStrsDef[i]);

            itemView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    showCurrentItem(position, count);
                    if (itemListener != null) {
                        itemListener.onItemClickListener(FooterViewMenu.this.itemStrsDef[position]);
                    }
                }
            });
            itemViews[i] = itemView;
            addView(itemView);
        }
    }

    private void showCurrentItem(int position, int count) {
        if (mCurrentItem != position) {
            mPreItem = mCurrentItem;
            mCurrentItem = position;

            itemViews[mCurrentItem].setTextColor(R.color.colorPrimary);
            itemViews[mCurrentItem].setIconRes(this.itemIconSelectedDef[mCurrentItem]);


            if (mPreItem != POSITION_INVALID) {
                itemViews[mPreItem].setTextColor(R.color.colorAccent);
                itemViews[mPreItem].setIconRes(this.itemIconNormalDef[mPreItem]);
            }
        }
    }

    private void initAllItem(int count) {
        for (int i = 0; i < count; i++) {
            itemViews[i].setTextColor(R.color.colorAccent);
            itemViews[i].setIconRes(this.itemIconNormalDef[i]);
        }
    }

    public void setOnMenuItemListener(OnMenuItemListener listener) {
        this.itemListener = listener;
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (itemViews != null) {
            //初始位置
            if (POSITION_DEFAULT >= itemViews.length || POSITION_DEFAULT < 0) {
                POSITION_DEFAULT = 0;
            }

            //初始化Item现实内容
            initAllItem(itemViews.length);
            //初始化选中内容
            showCurrentItem(POSITION_DEFAULT, itemViews.length);

        }
    }

    /**
     * 菜单切换监听
     **/
    public interface OnMenuItemListener {
        /**
         * 点击item
         *
         * @param itemStrId 当前菜单的标题id
         */
        void onItemClickListener(int itemStrId);
    }

    //内部Item类
    class FooterViewMenuItem extends LinearLayout {
        ImageView ivMenuItem;
        TextView tvMenuItem;
        int padding;

        public FooterViewMenuItem(Context context) {
            this(context, null);
        }

        public FooterViewMenuItem(Context context, @Nullable AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public FooterViewMenuItem(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            initLayout(context);
        }

        private void initLayout(Context context) {
            LayoutInflater.from(context).inflate(R.layout.item_view_bottom_menu_footer, this);
            ivMenuItem = findViewById(R.id.iv_menu_item);
            tvMenuItem = findViewById(R.id.tv_menu_item);

            setGravity(Gravity.CENTER);
            setOrientation(VERTICAL);
            setPadding(padding, padding, padding, padding);
            setLayoutParams(new LayoutParams(0, LayoutParams.WRAP_CONTENT, 1));
        }

        public void setText(@StringRes int strId) {
            tvMenuItem.setText(strId);
        }

        @SuppressWarnings("deprecation")
        public void setTextColor(@ColorRes int colorId) {
            tvMenuItem.setTextColor(getContext().getResources().getColor(colorId));
        }

        public void setIconRes(@DrawableRes int drawableId) {
            ivMenuItem.setImageResource(drawableId);
        }


    }

}
