package abak.tr.com.boxedverticalseekbar;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private BoxedVertical bv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView valueTextView = (TextView)findViewById(R.id.valueTextView);

        bv = (BoxedVertical)findViewById(R.id.boxed_vertical);

        bv.setOnBoxedPointsChangeListener(new BoxedVertical.OnValuesChangeListener() {
            @Override
            public void onPointsChanged(BoxedVertical boxedPoints, final int points) {
                valueTextView.setText("Current Value is " + String.valueOf(points));
            }

            @Override
            public void onStartTrackingTouch(BoxedVertical boxedPoints) {
                Toast.makeText(MainActivity.this, "onStartTrackingTouch", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(BoxedVertical boxedPoints) {
                Toast.makeText(MainActivity.this, "onStopTrackingTouch", Toast.LENGTH_SHORT).show();
            }
        });

        bv.setValue(40);


    }

    public void setBorder(View v) {
        int val = Integer.valueOf(v.getTag().toString());
        bv.setCornerRadius(val);
        Toast.makeText(MainActivity.this, "New corner radius is " + String.valueOf(val), Toast.LENGTH_SHORT).show();
    }

    public void setMax(View v) {
        int val = Integer.valueOf(v.getTag().toString());
        bv.setMax(val);
        Toast.makeText(MainActivity.this, "New max value is " + String.valueOf(val), Toast.LENGTH_SHORT).show();
    }

}
