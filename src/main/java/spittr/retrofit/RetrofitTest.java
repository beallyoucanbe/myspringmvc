package spittr.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

/**
 * Created by zhaosy-c on 2017/7/31.
 */
public class RetrofitTest {

    public static void main(String[] args) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8088/myspringmvc/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyInterface myInterface = retrofit.create(MyInterface.class);
        Call<String> call = myInterface.userInfo("123");
        printResponseBody(call);
    }
    public static void printResponseBody(Call<String> call) {
        try {
            Response<String> response = call.execute();
            if (response.isSuccessful()) {
                System.out.println(response.body());
            } else {
                System.err.println("HttpCode:" + response.code());
                System.err.println("Message:" + response.message());
                System.err.println(response.errorBody().string());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
