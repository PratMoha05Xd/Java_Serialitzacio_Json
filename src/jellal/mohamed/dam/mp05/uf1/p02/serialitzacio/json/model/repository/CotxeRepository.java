package jellal.mohamed.dam.mp05.uf1.p02.serialitzacio.json.model.repository;

import java.io.IOException;
import jellal.mohamed.dam.mp05.uf1.p02.serialitzacio.json.model.domain.Cotxe;

public class CotxeRepository {

    private static CotxeRepository instance = null;

    private CotxeRepository() {
    }

    public static CotxeRepository getInstance() {
        if (instance == null) {
            instance = new CotxeRepository();
        }
        return instance;
    }

    private CotxeJsonRepository cotxeJsonRepository = CotxeJsonRepository.getInstance();
    private PersistenciaFitxerTextRepository persistenciaFitxerTextRepository = PersistenciaFitxerTextRepository.getInstance();

    public void serialitzaUnCotxe(String fitxer, Cotxe cotxe) throws IOException {
        String jsonCotxe = cotxeJsonRepository.getJsonString(cotxe);
        persistenciaFitxerTextRepository.save(fitxer, jsonCotxe, false);
    }

    public Cotxe deserialitzaUnCotxe(String fitxer) throws IOException {
        String jsonCotxe = persistenciaFitxerTextRepository.read(fitxer);
        return cotxeJsonRepository.getCotxeFromJson(jsonCotxe);
    }

    public void serialitzaArrayCotxes(String fitxer, Cotxe[] cotxes) throws IOException {
        String jsonCotxes = cotxeJsonRepository.getJsonString(cotxes);
        persistenciaFitxerTextRepository.save(fitxer, jsonCotxes, false);
    }

    public Cotxe[] deserialitzaArrayCotxes(String fitxer) throws IOException {
        String jsonCotxes = persistenciaFitxerTextRepository.read(fitxer);
        return cotxeJsonRepository.getArrayCotxesFromJson(jsonCotxes);
    }
}
