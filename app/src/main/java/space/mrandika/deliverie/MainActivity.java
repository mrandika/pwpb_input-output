package space.mrandika.deliverie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input_nama, input_deskripsi, input_catatan, input_address;
    private Button btn_send;
    private TextView summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidget();

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nama = convert(input_nama);
                String deskripsi = convert(input_deskripsi);
                String catatan = convert(input_catatan);
                String address = convert(input_address);

                validateData(nama, deskripsi, catatan, address);

                // PrintOut
                if (!isInputEmpty(nama, deskripsi, catatan, address)) {
                    summary.setText(String.format("%s\n%s\n%s\n%s", nama, deskripsi, catatan, address));
                } else {
                    summary.setText("Ada data kosong isi dulu ya");
                }
            }
        });
    }

    private void initWidget() {
        input_nama = findViewById(R.id.input_nama);
        input_deskripsi = findViewById(R.id.input_deskripsi);
        input_catatan = findViewById(R.id.input_catatan);
        input_address = findViewById(R.id.input_address);
        btn_send = findViewById(R.id.btn_send);
        summary = findViewById(R.id.summary);
    }

    private boolean isInputEmpty(String nama, String deskripsi, String catatan, String address) {
        return nama.isEmpty() && deskripsi.isEmpty() && catatan.isEmpty() && address.isEmpty();
    }

    private void validateData(String nama, String deskripsi, String catatan, String address) {
        if (nama.isEmpty()) {
            input_nama.setError("Error");
        }

        if (deskripsi.isEmpty()) {
            input_deskripsi.setError("Error");
        }

        if (catatan.isEmpty()) {
            input_catatan.setError("Error");
        }

        if (address.isEmpty()) {
            input_address.setError("Error");
        }
    }

    String convert(EditText editText) {
        return editText.getText().toString().trim();
    }

}
