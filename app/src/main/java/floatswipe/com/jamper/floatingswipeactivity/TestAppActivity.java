package floatswipe.com.jamper.floatingswipeactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import floatswipe.com.jamper.floatingswipedactivity.Callbacks.OnMenuItemClickListener;
import floatswipe.com.jamper.floatingswipedactivity.UI.FloatingMenuDialog;

public class TestAppActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_app);
        button = findViewById(R.id.click);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new FloatingMenuDialog(TestAppActivity.this)
                .setDialogTitle("Add Picture")
                .setPositveButtonText("From Camera")
                .setNeutralButtonText("From Gallery")
                .setExtraButtonText("From Google Drive")
                .setNegativeButtonText("Close Dialog")
                .setDismissDialogOnMenuOnClick(false)
                .setDialogCancelable(true)

                .setPositiveTextColor("#FF86BF71")
                .setNeutralTextColor(R.color.colorAccent)
                .setNegativeTextColor("#FF86BF71")
                .setExtraTextColor("#FFFFE640")
                .setTitleTextColor("#FEEFE640")

                .setFontPath("GothamRnd-Bold.otf")


                .setOnPositiveButtonOnClick(new OnMenuItemClickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(TestAppActivity.this, "Positive", Toast.LENGTH_SHORT).show();
                    }
                })
                .setOnNegativeButtonOnClick(new OnMenuItemClickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(TestAppActivity.this, "Negative", Toast.LENGTH_SHORT).show();
                    }
                })
                .setOnNeutralButtonOnClick(new OnMenuItemClickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(TestAppActivity.this, "Neutral", Toast.LENGTH_SHORT).show();

                    }
                })
                .setOnExtraButtonOnClick(new OnMenuItemClickListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(TestAppActivity.this, "Extra", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }



}
