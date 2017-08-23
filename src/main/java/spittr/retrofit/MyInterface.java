package spittr.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by zhaosy-c on 2017/7/31.
 */
public interface MyInterface {

    @GET("users/{user}")
    Call<String> userInfo(@Path("user") String user);
}
