package sg.edu.rp.c346.id20002369.oursingapore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etDesc, etArea;
    Button btnInsert, btnShowList;
    RatingBar rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(getTitle().toString() + " ~ " + getResources().getText(R.string.title_activity_main));

        etName = findViewById(R.id.etName);
        etDesc = findViewById(R.id.etDesc);
        etArea = findViewById(R.id.etArea);
        btnInsert = findViewById(R.id.btnInsertSong);
        btnShowList = findViewById(R.id.btnShowList);
        rb = findViewById(R.id.ratingBarInput);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = etName.getText().toString().trim();
                String desc = etDesc.getText().toString().trim();
                if (name.length() == 0 || desc.length() == 0) {
                    Toast.makeText(MainActivity.this, "Incomplete data", Toast.LENGTH_SHORT).show();
                    return;
                }

                String area_str = etArea.getText().toString().trim();
                int area = Integer.valueOf(area_str);
                int stars = (int) rb.getRating();

                DBHelper dbh = new DBHelper(MainActivity.this);
                long result = dbh.insertIsland(name, desc, area, stars);

                if (result != -1) {
                    Toast.makeText(MainActivity.this, "Island inserted", Toast.LENGTH_LONG).show();
                    etName.setText("");
                    etDesc.setText("");
                    etArea.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Insert failed", Toast.LENGTH_LONG).show();
                }


            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }
}
//    private int getStars() {
//        int stars = 1;
//        switch (rb.getCheckedRadioButtonId()) {
//            case R.id.radio1:
//                stars = 1;
//                break;
//            case R.id.radio2:
//                stars = 2;
//                break;
//            case R.id.radio3:
//                stars = 3;
//                break;
//            case R.id.radio4:
//                stars = 4;
//                break;
//            case R.id.radio5:
//                stars = 5;
//                break;
//        }
//        return stars;
//    }
//}
