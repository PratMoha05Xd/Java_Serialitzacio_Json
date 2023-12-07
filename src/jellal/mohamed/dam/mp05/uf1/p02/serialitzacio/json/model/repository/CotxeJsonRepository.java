package jellal.mohamed.dam.mp05.uf1.p02.serialitzacio.json.model.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import jellal.mohamed.dam.mp05.uf1.p02.serialitzacio.json.model.domain.Cotxe;

public class CotxeJsonRepository {

    private static CotxeJsonRepository instance = null;

    private CotxeJsonRepository() {
    }

    public static CotxeJsonRepository getInstance() {
        if (instance == null) {
            instance = new CotxeJsonRepository();
        }
        return instance;
    }

    // Un cotxe
    public String getJsonString(Cotxe cotxe) {
        Gson gson = new Gson();
        return gson.toJson(cotxe);
    }

    public Cotxe getCotxeFromJson(String contingutJson) {
        Gson gson = new Gson();
        return gson.fromJson(contingutJson, Cotxe.class);
    }

    // Array de cotxes
    public String getJsonString(Cotxe[] cotxes) {
        Gson gson = new Gson();
        return gson.toJson(cotxes);
    }

    public Cotxe[] getArrayCotxesFromJson(String contingutJson) {
        Type arrayCotxesType = new TypeToken<Cotxe[]>() {}.getType();
        Gson gson = new Gson();
        return gson.fromJson(contingutJson, arrayCotxesType);
    }
}
