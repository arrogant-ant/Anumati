package inc.iris.anumati;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import inc.iris.anumati.models.AnumatiDescription;

public class ApprovalActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approval);
        AnumatiDescription desc = new AnumatiDescription();
        desc = getDescription();
        if (desc == null) {
            return;
        }
        TextView username = findViewById(R.id.username_tx);
        TextView ticketNo = findViewById(R.id.ticket_et);
        TextView appName = findViewById(R.id.app_et);
        TextView description = findViewById(R.id.description_et);
        TextView status = findViewById(R.id.status_et);
        username.setText(desc.getUsername());
        ticketNo.setText(desc.getTicketID());
        appName.setText(desc.getAppName());
        description.setText(desc.getDescription());
        status.setText(desc.getStatus());
    }

    public void approve(View view) {
    }

    public void reject(View view) {
    }

    /*
    return AnumatiDescription based on API response
     */
    public AnumatiDescription getDescription() {
        AnumatiDescription desc = new AnumatiDescription();
        String response = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            desc = mapper.readValue(response, AnumatiDescription.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return desc;
    }
}
