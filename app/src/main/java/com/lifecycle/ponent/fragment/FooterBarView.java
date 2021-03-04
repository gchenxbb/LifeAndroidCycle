package com.lifecycle.ponent.fragment;

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

import com.lifecycle.ponent.R;

import java.util.ArrayList;
import java.util.List;


/**
 * 通用，切换tab栏
 */
public class FooterBarView extends LinearLayout {
    //菜单文案id
    private String[] itemStrsDef = {
            "home",
            "page",
            "find",
            "mine",
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
    private List<BottomBarEntity> bottomBarEntities;

    private OnMenuItemListener itemListener;

    private int POSITION_DEFAULT = 0;//初始显示位置
    private int POSITION_INVALID = -1;//无效位置


    private int mCurrentItem = POSITION_INVALID;//记录当前所展示的item的位置索引
    private int mPreItem = POSITION_INVALID;//记录上一次所展示的item的位置索引

    public FooterBarView(Context context) {
        this(context, null);
    }

    public FooterBarView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FooterBarView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    private void initLayout(Context context) {
        setOrientation(HORIZONTAL);
        setBackgroundColor(context.getResources().getColor(R.color.white));

        BottomBarEntity entity1 = new BottomBarEntity(0, itemIconNormalDef[0], itemIconSelectedDef[0], itemStrsDef[0]);
        BottomBarEntity entity2 = new BottomBarEntity(1, itemIconNormalDef[1], itemIconSelectedDef[1], itemStrsDef[1]);
        BottomBarEntity entity3 = new BottomBarEntity(2, itemIconNormalDef[2], itemIconSelectedDef[2], itemStrsDef[2]);
        BottomBarEntity entity4 = new BottomBarEntity(3, itemIconNormalDef[3], itemIconSelectedDef[3], itemStrsDef[3]);

        bottomBarEntities = new ArrayList<>();
        bottomBarEntities.add(entity1);
        bottomBarEntities.add(entity2);
        bottomBarEntities.add(entity3);
        bottomBarEntities.add(entity4);

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
        final int count = bottomBarEntities.size();
        itemViews = new FooterViewMenuItem[count];
        for (int i = 0; i < count; i++) {
            final int position = i;
            FooterViewMenuItem itemView = new FooterViewMenuItem(getContext());
            itemView.setText(bottomBarEntities.get(i).title);

            itemView.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    showCurrentItem(position);
                    if (itemListener != null) {
                        itemListener.onItemClickListener(bottomBarEntities.get(position));
                    }
                }
            });
            itemViews[i] = itemView;
            addView(itemView);
        }
    }

    private void showCurrentItem(int position) {
        if (mCurrentItem != position) {
            mPreItem = mCurrentItem;
            mCurrentItem = position;

            selectItem(position);

            if (mPreItem != POSITION_INVALID) {
                unSelectItem(mPreItem);
            }
        }
    }

    public void selectItem(int position) {
        itemViews[position].setTextColor(R.color.colorPrimary);
        itemViews[position].setIconRes(this.bottomBarEntities.get(position).iconSelcet);
    }

    public void unSelectItem(int position) {
        itemViews[position].setTextColor(R.color.colorAccent);
        itemViews[position].setIconRes(this.bottomBarEntities.get(position).iconNormal);
    }

    private void initAllItem(int count) {
        for (int i = 0; i < count; i++) {
            unSelectItem(i);
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
            showCurrentItem(POSITION_DEFAULT);

        }
    }

    /**
     * 菜单切换监听
     **/
    public interface OnMenuItemListener {
        /**
         * 点击item
         */
        void onItemClickListener(BottomBarEntity entity);
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

        public void setText(String str) {
            tvMenuItem.setText(str);
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
