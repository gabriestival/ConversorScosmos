import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.JsonObject;
import com.google.gson.Gson;

public class Convertidor{
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";

    public double conversor(double cantidad, String divisaOrigen, String divisaDestino)
  {
        try {
            URL url = new URL(API_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) 
            {
                response.append(line);
            }
          
            reader.close();
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(response.toString(), JsonObject.class);
            JsonObject rates = jsonObject.getAsJsonObject("rates");
            double sourceToTargetRate = rates.get(divisaDestino).getAsDouble();
            double convertedAmount = cantidad * sourceToTargetRate;            
            return convertedAmount; 
        }
        catch (IOException e) 
          {           
            e.printStackTrace();
            return -1; 
        } 
        catch (Exception e) 
          {            
            e.printStackTrace();
            return -1; 
        }
    }
}
