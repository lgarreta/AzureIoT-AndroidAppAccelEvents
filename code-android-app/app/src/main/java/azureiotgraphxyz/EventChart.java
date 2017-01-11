package azureiotgraphxyz;

import android.content.Context;
import android.graphics.Color;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

/**
 * Created by lg on 11/12/16.
 */

public class EventChart extends LineChart {
    int lineColor;
    String chartLabel;
    public EventChart(Context ctx, LinearLayout layout, String chartLabel, int lineColor) {
        super (ctx);
        this.lineColor = lineColor;
        this.chartLabel = chartLabel;
        initParams();
        setOnClickListener ((OnClickListener) ctx);

        LinearLayout.LayoutParams params1 = new LinearLayout.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT, 0.25f);

        layout.addView(this, params1);
    }
    public void initParams () {
        //setLayoutParams(new WindowManager.LayoutParams(WindowManager.LayoutParams.));
        // Enable touch gesture and enable scaling and dragging
        setTouchEnabled (true);
        setDragEnabled(true);
        setScaleEnabled(true);

        // add empty data
        LineData data = new LineData();
        data.setValueTextColor(Color.WHITE);
        setData(data);
    }

    public void addEntry (String timeStamp, float value) {
        LineData data = this.getData();
        if (data != null) {
            ILineDataSet set = data.getDataSetByIndex(0);
            // set.addEntry(...); // can be called as well
            if (set == null) {
                set = createSet(null, chartLabel, lineColor);
                data.addDataSet(set);
            }
            data.addXValue(timeStamp);
            Entry entry = new Entry (value, set.getEntryCount());
            System.out.println ("Point:" + set.getEntryCount() + ", " + value);

            data.addEntry(entry, 0);
            data.notifyDataChanged();
            // let the chart know it's data has changed
            this.notifyDataSetChanged();
            // limit the number of visible entries
            this.setVisibleXRange (1,10);
            //mChart.setVisibleYRangeMaximum (10, AxisDependency.LEFT);

            // move to the latest entry
            this.moveViewToX(data.getXValCount()-9);

            // this automatically rehttps://github.com/PhilJay/MPAndroidChart/blob/master/MPChartExample/src/com/xxmassdeveloper/mpchartexample/DynamicalAddingActivity.javafreshes the chart (calls invalidate())
            // mChart.moveViewTo(data.getXValCount()-7, 55f,
            // AxisDependency.LEFT);
        }
    }
    private LineDataSet createSet(ArrayList<Entry> values, String label, int color) {
        LineDataSet set = new LineDataSet(values, label);
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setColor(color);
        set.setCircleColor(color);
        set.setLineWidth(1f);
        set.setCircleRadius(3f);
        set.setDrawCircleHole(false);
        set.setValueTextSize(9f);
        Legend legend = getLegend();
        legend.setEnabled(true);
        legend.setPosition(Legend.LegendPosition.ABOVE_CHART_CENTER);
        return set;
    }
}
