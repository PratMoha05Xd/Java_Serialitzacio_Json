package jellal.mohamed.dam.mp05.uf1.p02.serialitzacio.json.model.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jellal.mohamed.dam.mp05.uf1.p02.serialitzacio.json.model.configuration.Settings;
import jellal.mohamed.dam.mp05.uf1.p02.serialitzacio.json.model.domain.Cotxe;
import jellal.mohamed.dam.mp05.uf1.p02.serialitzacio.json.model.repository.CotxeRepository;

public class CotxeSerialitzacioJsonService {

	private CotxeSerialitzacioJsonService() {

	}

	public static CotxeSerialitzacioJsonService getInstance() {
		if (instance == null) {
			instance = new CotxeSerialitzacioJsonService();
		}

		return instance;
	}

	private static CotxeSerialitzacioJsonService instance = null;

	private CotxeRepository cotxeRepository = CotxeRepository.getInstance();

	public void serialitzaUnCotxe(Cotxe cotxe) throws IOException {
		cotxeRepository.serialitzaUnCotxe(Settings.FITXER_COTXE_INDIVIDUAL, cotxe);
	}

	public Cotxe deserialitzaUnCotxe() throws IOException {
		return cotxeRepository.deserialitzaUnCotxe(Settings.FITXER_COTXE_INDIVIDUAL);
	}

	public void serialitzaArrayCotxes(List<Cotxe> llistaCotxes) throws IOException {

		Cotxe[] arrayCotxes = null;

		if (llistaCotxes != null) {
			arrayCotxes = new Cotxe[llistaCotxes.size()];
			int comptador = 0;
			for (Cotxe a : llistaCotxes) {
				arrayCotxes[comptador] = a;
				comptador++;
			}
		}

		cotxeRepository.serialitzaArrayCotxes(Settings.FITXER_LLISTA_COTXES, arrayCotxes);
	}

	public List<Cotxe> deserialitzaArrayCotxes() throws IOException {
		Cotxe[] arrayCotxes = cotxeRepository.deserialitzaArrayCotxes(Settings.FITXER_LLISTA_COTXES);
		ArrayList<Cotxe> llista = null;
		if (arrayCotxes != null && arrayCotxes.length > 0) {
			llista = new ArrayList<Cotxe>();
			for (Cotxe a : arrayCotxes) {
				llista.add(a);
			}
		}

		return llista;
	}

}
