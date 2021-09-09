package android.com.jumpco.io.clearscore;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.AlertDialog;
import android.com.jumpco.io.clearscore.pojo.ClearScoreModel;
import android.com.jumpco.io.clearscore.utils.RetrofitClient;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 3000;

    public int scoreValue;
    public int maxScoreValue;

    AlertDialog.Builder dialog;
    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        context=this;

        getClearScoreInformation();

        if (checkInternetConnectivity()){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                  //  performAPIService();

                    Intent i = new Intent(SplashActivity.this, MainActivity.class);
                    i.putExtra("score", scoreValue);
                    i.putExtra("maxScore", maxScoreValue);
                    startActivity(i);
                    finish();

                }
            },SPLASH_DISPLAY_LENGTH);

        }
        else {
            showNoInternetDailog();
        }
    }


    //check internet connection for both MOBILE and WIFI
    private boolean checkInternetConnectivity(){
        boolean haveConnectionWifi = false;
        boolean haveConnectedMobile = false;
        ConnectivityManager cm =((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo[] networkInfos = cm.getAllNetworkInfo();

        for (NetworkInfo in : networkInfos){
            if(in.getTypeName().equalsIgnoreCase("WIFI"))
                if(in.isConnected())
                    haveConnectionWifi = true;
            if(in.getTypeName().equalsIgnoreCase("MOBILE"))
                if(in.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectionWifi || haveConnectedMobile;
    }

    //show dialog if there is no internet connection
    private void showNoInternetDailog(){
        dialog = new AlertDialog.Builder(SplashActivity.this);
        dialog.setMessage("No Internet connection!");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                finish();
                dialog.dismiss();
            }
        });
        AlertDialog alert = dialog.create();
        alert.show();
    }


    // perform api call
    public void getClearScoreInformation(){

        Call<ClearScoreModel> call = RetrofitClient.getInstance().getMyApi().getClearScoreInfo();


        call.enqueue(new Callback<ClearScoreModel>() {
            /**
             * Invoked for a received HTTP response.
             * <p>
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call {@link Response#isSuccessful()} to determine if the response indicates success.
             *
             * @param call
             * @param response
             */
            @Override
            public void onResponse(Call<ClearScoreModel> call, Response<ClearScoreModel> response) {

                if (response.isSuccessful()) {
                    String passValue = response.body().accountIDVStatus;
                    scoreValue = response.body().scoremodel.score;
                    maxScoreValue = response.body().scoremodel.maxScoreValue;


                    Toast.makeText(context, " The response: " + passValue, Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(context, " The response: " + response.raw(), Toast.LENGTH_LONG).show();

                    System.out.println("The response: " + response.raw());

                }
            }
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected
             * exception occurred creating the request or processing the response.
             *
             * @param call
             * @param t
             */
            @Override
            public void onFailure(Call<ClearScoreModel> call, Throwable t) {
                Toast.makeText(context," Error..." ,Toast.LENGTH_LONG).show();
            }
        });
    }
}