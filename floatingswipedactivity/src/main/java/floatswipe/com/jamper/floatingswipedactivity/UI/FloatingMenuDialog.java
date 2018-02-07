package floatswipe.com.jamper.floatingswipedactivity.UI;

import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import floatswipe.com.jamper.floatingswipedactivity.Callbacks.OnMenuItemClickListener;
import floatswipe.com.jamper.floatingswipedactivity.R;

import static android.view.Gravity.BOTTOM;

public class FloatingMenuDialog extends Dialog implements View.OnClickListener {
    OnMenuItemClickListener onPositiveOnClick, onNegativeOnClick, onNeutralOnClick, onExtraOnClick;

    TextView title, positiveButtonText, neutralButtonText, extraButtonText, cancelText;
    LinearLayout cancelButton, extraButton, neutralButton;
    private boolean dismissDialog, cancelable;

    private String titleText, positiveText, neutralText, extraText, cancellingText;

    public FloatingMenuDialog(Activity context) {
        super(context);
        dismissDialog = true;
        cancelable = true;
        positiveText = null;
        neutralText = null;
        extraText = null;
    }

    private void initViews() {
        title = (TextView) findViewById(R.id.dg_Title_x);
        positiveButtonText = (TextView) findViewById(R.id.dg_PositiveButtonText_x);
        neutralButtonText = (TextView) findViewById(R.id.dg_NeutralButtonText_x);
        extraButtonText = (TextView) findViewById(R.id.dg_ExtraButtonText_x);
        cancelText = (TextView) findViewById(R.id.dg_cancelText_x);
        cancelButton = (LinearLayout) findViewById(R.id.dg_CancelButton_x);
        extraButton = (LinearLayout) findViewById(R.id.dg_ExtraButton_x);
        neutralButton = (LinearLayout) findViewById(R.id.dg_NeutralButton_x);

        positiveButtonText.setOnClickListener(this);
        neutralButton.setOnClickListener(this);
        extraButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

        //////////////////////////////////////////////////////////////////////
        /// Hide Some of the Views, the POSITIVE, EXTRA, and NEUTRAL BUTTONS
        /////////////////////////////////////////////////////////////////////
        positiveButtonText.setVisibility(View.GONE);
        neutralButton.setVisibility(View.GONE);
        extraButton.setVisibility(View.GONE);


        setUpViewAttributes();
    }

    private void setUpViewAttributes() {
        try {
            if (titleText != null && !TextUtils.isEmpty(titleText))
                this.title.setText(titleText);
            else
                this.title.setVisibility(View.GONE);


            this.setViewsText(positiveButtonText, positiveText);
            this.setViewsText(neutralButtonText, neutralText);
            this.setViewsText(extraButtonText, extraText);

            if (cancellingText != null && !TextUtils.isEmpty(cancellingText))
                this.setViewsText(cancelText, cancellingText);
            else
                this.setViewsText(cancelText, getContext().getResources().getString(R.string.cancel));


            //////////////////////////////////////////////////////////////////////
            /// Show the called Views, the POSITIVE, EXTRA, and NEUTRAL BUTTONS
            /////////////////////////////////////////////////////////////////////
            if (positiveText != null && !TextUtils.isEmpty(positiveText)) {
                positiveButtonText.setVisibility(View.VISIBLE);
            }

            if (neutralText != null && !TextUtils.isEmpty(neutralText)) {
                neutralButton.setVisibility(View.VISIBLE);
                neutralButtonText.setVisibility(View.VISIBLE);
            }

            if (extraText != null && !TextUtils.isEmpty(extraText)) {
                extraButton.setVisibility(View.VISIBLE);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_menu_layout);
        initViews();
    }


    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        final View view = this.getWindow().getDecorView();
        WindowManager.LayoutParams params = this.getWindow().getAttributes();
        params.gravity = BOTTOM;
        this.getWindow().setAttributes(params);

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                view.setBackground(getContext().getResources().getDrawable(R.drawable.dialog_inset_bg));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
           // this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND); //Clear background Dim
           // this.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            getWindow().setWindowAnimations(R.style.DialogDragDown);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getWindow().getWindowManager().updateViewLayout(view, params);

    }


    public FloatingMenuDialog setOnPositiveButtonOnClick(OnMenuItemClickListener onMenuItemClickListener) {
        this.onPositiveOnClick = onMenuItemClickListener;
        return this;
    }

    public FloatingMenuDialog setOnExtraButtonOnClick(OnMenuItemClickListener onMenuItemClickListener) {
        this.onExtraOnClick = onMenuItemClickListener;
        return this;
    }

    public FloatingMenuDialog setOnNeutralButtonOnClick(OnMenuItemClickListener onMenuItemClickListener) {
        this.onNeutralOnClick = onMenuItemClickListener;
        return this;
    }

    public FloatingMenuDialog setOnNegativeButtonOnClick(OnMenuItemClickListener onMenuItemClickListener) {
        this.onNegativeOnClick = onMenuItemClickListener;
        return this;
    }


    ///////////////////////////////////////////////////////////
    ////////  SET-UP DIALOG VIEW ATTRIBUTES
    //////////////////////////////////////////////////////////


    @Override
    public void setTitle(int titleId) {
        try {
            this.titleText = getContext().getResources().getString(titleId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setTitle(@Nullable CharSequence title) {
        try {
            this.titleText = String.valueOf(title);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public FloatingMenuDialog setDialogTitle(int titleId) {
        this.setTitle(titleId);
        return this;
    }


    public FloatingMenuDialog setDialogTitle(@Nullable CharSequence title) {
        this.setTitle(title);
        return this;
    }


    /**
     * Default metthod to be called
     **/
    @Deprecated
    private void setDefaultText(TextView textView, CharSequence titleText, int titleId) {
        try {
            if (titleText != null && TextUtils.isEmpty(titleText))
                textView.setText(titleText);
            else if (titleId != -1)
                textView.setText(titleId);
            else textView.setText(R.string.default_text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Default method to be called
     **/
    private void setViewsText(TextView textView, String text) {
        try {
            if (text != null && !TextUtils.isEmpty(text))
                textView.setText(text);
            else textView.setText(R.string.default_text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public FloatingMenuDialog setPositveButtonText(@Nullable CharSequence charSequence) {
        try {
            this.positiveText = String.valueOf(charSequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public FloatingMenuDialog setPositveButtonText(int textId) {
        try {
            this.positiveText = getContext().getResources().getString(textId);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }


    public FloatingMenuDialog setNeutralButtonText(@Nullable CharSequence charSequence) {
        try {
            this.neutralText = String.valueOf(charSequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public FloatingMenuDialog setNeutralButtonText(int textId) {
        try {
            this.neutralText = getContext().getResources().getString(textId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public FloatingMenuDialog setExtraButtonText(@Nullable CharSequence charSequence) {
        try {
            this.extraText = String.valueOf(charSequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public FloatingMenuDialog setExtraButtonText(int textId) {
        try {
            this.extraText = getContext().getResources().getString(textId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public FloatingMenuDialog setNegativeButtonText(@Nullable CharSequence charSequence) {
        try {
            this.cancellingText = String.valueOf(charSequence);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public FloatingMenuDialog setNegativeButtonText(int textId) {
        try {
            //   this.setDefaultText(cancelText, null, textId);
            this.cancellingText = getContext().getResources().getString(textId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }


    public FloatingMenuDialog setDismissDialogOnMenuOnClick(boolean dismissDialog) {
        this.dismissDialog = dismissDialog;
        return this;
    }

    public FloatingMenuDialog setDialogCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        setCancelable(this.cancelable);
        return this;
    }


    @Override
    public void setCancelable(boolean flag) {
        super.setCancelable(flag);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.dg_PositiveButtonText_x) {
            if (onPositiveOnClick != null)
                onPositiveOnClick.onClick();
        }

        if (v.getId() == R.id.dg_NeutralButton_x) {
            if (onNeutralOnClick != null)
                onNeutralOnClick.onClick();
        }

        if (v.getId() == R.id.dg_CancelButton_x) {
            if (onNegativeOnClick != null)
                onNegativeOnClick.onClick();
            dismissDialog();
        }

        if (v.getId() == R.id.dg_ExtraButton_x) {
            if (onExtraOnClick != null)
                onExtraOnClick.onClick();
        }

        if (dismissDialog)
            dismissDialog();

    }


    private void dismissDialog() {
        this.dismiss();
        this.cancel();
    }


}
