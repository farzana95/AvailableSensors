package edu.sdmgap07.mumu.availablesensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager mSensorManager;

    TextView numberofSensors, availableSensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //my method
        getandprintSensors();
    }

    private void getandprintSensors(){

        //Get the texts fields of the layout and setup to invisible.
        numberofSensors = findViewById(R.id.numberofsensors);
        availableSensors = findViewById(R.id.availablesensors);

        //Get the SensorManager
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //List of senses available
        List<Sensor> deviceSensors = mSensorManager.getSensorList(Sensor.TYPE_ALL);

        //Print how many sensors are there
        numberofSensors.setText(deviceSensors.size() + " Sensors Available!");

        //Print each sensor available using sensorStringList as the strimg to be printed
        String sensorStringList = new String ("");

        Sensor temp;

        int i, serial;

        for(i=0; i < deviceSensors.size(); i++){
            temp = deviceSensors.get(i);
            serial = i+1;
            sensorStringList = sensorStringList + serial + ". " + temp.getName() + "\n\n"; //Add the
        }

        //if there are sensors available show the list
        if(i>0){
            sensorStringList = "Sensors:\n\n" + sensorStringList;
            availableSensors.setText(sensorStringList);
        }
    }
}
