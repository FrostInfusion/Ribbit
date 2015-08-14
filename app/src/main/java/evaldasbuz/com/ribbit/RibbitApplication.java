package evaldasbuz.com.ribbit;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by Evaldas on 2015-08-11.
 */
public class RibbitApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "2wvi4C0cViZqoGZsbqpRsOTmAIZ2h65admpvNfFL", "yibEdpZsEizVUWtvxbDwXQnhWKAx6eDDOwh1Ank2");



    }
}














