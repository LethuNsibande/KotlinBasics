package com.nsibandelh.readcalllog;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.loader.content.CursorLoader;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    final private int REQUEST_READ_CAL_LOG = 1;
    TextView txtCalls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCalls = findViewById(R.id.txtCalls);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG}, REQUEST_READ_CAL_LOG);
        else {
            txtCalls = findViewById(R.id.txtCalls);
            txtCalls.setText(ListCallLog());
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_CAL_LOG:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    txtCalls = findViewById(R.id.txtCalls);
                    txtCalls.setText(ListCallLog());
                }
                else
                    Toast.makeText(MainActivity.this, "Permission Denied", Toast.LENGTH_SHORT).show();
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    protected String ListCallLog() {
        Uri allCalls = Uri.parse("content://call_log/calls");

        String strResults = "";

        Cursor cursor;

        CursorLoader cursorLoader = new CursorLoader(this, allCalls, null, null);
        cursor = cursorLoader.loadInBackground();

        StringBuffer	stringBuffer	=	new	StringBuffer();
        int	iNumber	=	cursor.getColumnIndex(CallLog.Calls.NUMBER);
        int	iType	=	cursor.getColumnIndex(CallLog.Calls.TYPE);

        int	iDate	=	cursor.getColumnIndex(CallLog.Calls.DATE);
        int	iDuration	=	cursor.getColumnIndex(CallLog.Calls.DURATION);

        while	(cursor.moveToNext())
        {
            String	phNumber	=	cursor.getString(iNumber);
            String	callType	=	cursor.getString(iType);
            String	callDate	=	cursor.getString(iDate);
            Date dtCallDayTime	=	new	Date(Long.valueOf(callDate));
            String	sCallDuration	=	cursor.getString(iDuration);
            String	sDir	=	null;
            int	iDircode	=	Integer.parseInt(callType);

            switch	(iDircode)
            {
                case	CallLog.Calls.OUTGOING_TYPE:
                    sDir	=	"OUTGOING";
                    break;
                case	CallLog.Calls.INCOMING_TYPE:
                    sDir	=	"INCOMING";
                    break;
                case	CallLog.Calls.MISSED_TYPE:
                    sDir	=	"MISSED";
                    break;
            }

            stringBuffer.append("\nPhone	Number:--- "	+	phNumber	+	"	\nCall Type:--- "
                +	sDir	+	"	\nCall	Date:--- "	+	sCallDuration
                +	"	\nCall	duration	in	sec	:--- "	+	sCallDuration);
            stringBuffer.append("\n----------------------------------");
        }
        cursor.close();
        return	stringBuffer.toString();

    }
}