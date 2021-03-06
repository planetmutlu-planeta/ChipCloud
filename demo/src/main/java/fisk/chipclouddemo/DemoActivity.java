package fisk.chipclouddemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.flexbox.FlexboxLayout;

import fisk.chipcloud.ChipCloud;
import fisk.chipcloud.ChipCloudConfig;
import fisk.chipcloud.ChipListener;
import fisk.chipclouddemo.demo.R;

public class DemoActivity extends AppCompatActivity {

  private static final String TAG = "DemoActivity";

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_demo);

    FlexboxLayout flexbox = (FlexboxLayout) findViewById(R.id.flexbox);

    ChipCloudConfig config = new ChipCloudConfig()
        .selectMode(ChipCloud.SelectMode.multi)
        .checkedChipColor(Color.parseColor("#ddaa00"))
        .checkedTextColor(Color.parseColor("#ffffff"))
        .uncheckedChipColor(Color.parseColor("#efefef"))
        .uncheckedTextColor(Color.parseColor("#666666"));

    ChipCloud chipCloud = new ChipCloud(this, flexbox, config);

    chipCloud.addChip("HelloWorld!");

    String[] demoArray = getResources().getStringArray(R.array.demo_array);
    chipCloud.addChips(demoArray);

    chipCloud.setChecked(2);

    String label = chipCloud.getLabel(2);
    Log.d(TAG, "Label at index 2: " + label);

    chipCloud.setListener(new ChipListener() {
      @Override
      public void chipCheckedChange(int index, boolean checked, boolean userClick) {
        if(userClick) {
          Log.d(TAG, String.format("chipCheckedChange Label at index: %d checked: %s", index, checked));
        }
      }
    });
  }
}
