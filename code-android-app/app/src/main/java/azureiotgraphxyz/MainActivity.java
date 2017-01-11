package azureiotgraphxyz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;

import azureiotgraphxyz.simplelinechart.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout mainLayout;
    private EventChart mChart;
    AlarmsTable alarmsTable;
    int eventTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // To make full screen layout
        getWindow().setFlags(LayoutParams.FLAG_FULLSCREEN,
                LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        initComponents();
    }
    public void initComponents () {
        // Set layouts for the views
        LinearLayout xl = (LinearLayout) findViewById(R.id.xLayout);
        LinearLayout yl = (LinearLayout) findViewById(R.id.yLayout);
        LinearLayout zl = (LinearLayout) findViewById(R.id.zLayout);

        // Views
        EventChart xChart = new EventChart(this, xl, "X Accelerometer", Color.RED);
        EventChart yChart = new EventChart(this, yl, "Y Accelerometer", Color.BLUE);
        EventChart zChart = new EventChart(this, zl, "Z Accelerometer", Color.BLACK);

        TableLayout alarmsLayout = (TableLayout) findViewById(R.id.alarmsLayout);
        alarmsTable = new AlarmsTable (this, alarmsLayout);
    }

    @Override
    public void onClick (View view) {
        EventChart chart = (EventChart) view;
        float value = getRandomValue();
        String strTime = "12:0" + Integer.toString (eventTime);
        eventTime += 2;
        chart.addEntry (strTime, value);
        alarmsTable.addRow (chart.chartLabel, strTime, getRandomValue());
    }

    private float getRandomValue () {
        return (float) (Math.random() * 10) + 20f;
    }
}
