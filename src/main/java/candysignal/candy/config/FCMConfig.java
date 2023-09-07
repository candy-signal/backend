package candysignal.candy.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Configuration
public class FCMConfig {

    @Bean
    FirebaseMessaging firebaseMessaging() throws IOException{
        ClassPathResource resource = new ClassPathResource("firebase/candysignal-29ef6-firebase-adminsdk-4jsii-bfa85f1578.json");

        InputStream refreshToken = resource.getInputStream();

        FirebaseApp firebaseApp = null;
        List<FirebaseApp> firebaseAppsList = FirebaseApp.getApps();

        if(firebaseAppsList != null && !firebaseAppsList.isEmpty()){
            for(FirebaseApp app : firebaseAppsList){
                if(app.getName().equals(firebaseApp.DEFAULT_APP_NAME)){
                    firebaseApp = app;
                }
            }
        }else{
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .build();
            firebaseApp = FirebaseApp.initializeApp(options);
        }
        return FirebaseMessaging.getInstance(firebaseApp);
    }


}
