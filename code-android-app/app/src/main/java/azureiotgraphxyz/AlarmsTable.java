package azureiotgraphxyz;


import android.content.Context;
import android.graphics.Color;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * Created by lg on 12/12/16.
 */

public class AlarmsTable extends TableLayout {
    Context context;
    TableLayout layout;
    public AlarmsTable (Context context, TableLayout layout) {
        super (context);
        this.context = context;
        this.layout = layout;
        initHeader ();
    }
    void initHeader () {
        TableRow trHead = new TableRow (context);
        //setId (10);
        trHead.setBackgroundColor(Color.GRAY);
        trHead.setLayoutParams(new LayoutParams(
              LayoutParams.MATCH_PARENT,
              LayoutParams.WRAP_CONTENT));

        TextView labelType = new TextView (context);
        //labelType.setId(20);
        labelType.setText("ALARM TYPE");
        labelType.setTextColor(Color.WHITE);
        labelType.setPadding(5, 5, 5, 5);
        trHead.addView(labelType);// add the column to the table row here

        TextView labelTime = new TextView (context);
        //labelTime.setId(21);// define id that must be unique
        labelTime.setText("TIME"); // set the text for the header
        labelTime.setTextColor(Color.WHITE); // set the color
        labelTime.setPadding(5, 5, 5, 5); // set the padding (if required)
        trHead.addView(labelTime); // add the column to the table row here

        TextView labelValue = new TextView (context);
        //labelTime.setId(21);// define id that must be unique
        labelValue.setText("VALUE"); // set the text for the header
        labelValue.setTextColor(Color.WHITE); // set the color
        labelValue.setPadding(5, 5, 5, 5); // set the padding (if required)
        trHead.addView(labelValue); // add the column to the table row here

        layout.addView(trHead, new TableLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
    }
    void addRow (String type, String time, float value) {
        TableRow tr = new TableRow(context);
        //if(count%2!=0) tr.setBackgroundColor(Color.GRAY);
        //tr.setId(100+count);
        tr.setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));


//Create two columns to add as table data
        // Create a TextView to add date
        TextView labelType = new TextView(context);
        //labelDATE.setId(200+count);
        labelType.setText(type);
        labelType.setPadding(5, 0, 60, 0);
        labelType.setTextColor(Color.BLUE);
        tr.addView(labelType);

        TextView labelTime = new TextView(context);
        //labelTime.setId(200+count);
        labelTime.setText(time);
        labelTime.setPadding(5, 0, 60, 0);
        labelTime.setTextColor(Color.BLUE);
        tr.addView(labelTime);

        TextView labelValue = new TextView(context);
        //labelTime.setId(200+count);
        labelValue.setText(""+value);
        labelValue.setTextColor(Color.BLUE);
        tr.addView(labelValue);

        // finally add this to the table row
        layout.addView(tr, new TableLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));

    }

}
