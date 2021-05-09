package FormBuilderByHackers.ServiceImplementation;

import FormBuilderByHackers.Configuration.HibernateProxyTypeAdapter;
import FormBuilderByHackers.Service.JsonConverter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * JSON converter implementation
 * 
 * @author bhavesh
 */

@Service
public class JsonConverterImpl implements JsonConverter {

	private final Logger logger = LoggerFactory.getLogger(JsonConverterImpl.class);
	@Override
	public <T> T convertJsonToEntity(String json, Class<T> clazz) {

		ObjectMapper mapper = null;
		T object = null;
		try {
			if (json == null)
				return null;
			mapper = new ObjectMapper();
			object = mapper.readValue(json, clazz);
		} catch (Exception e) {
			logger.error("ERROR : " , e);
		}
		return (T) object;
	}

	@Override
	public <T> String convertEntityToJson(T object) {

		ObjectMapper mapper = null;
		String json = null;
		try {
			mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
			json = mapper.writeValueAsString(object);
		} catch (Exception e) {
			logger.error("ERROR : " , e);
		}
		return json;
	}

	@Override
	public <T> String convertEntityToJson(T object, ExclusionStrategy strategy) {

		Gson gson = null;
		try {
			gson = new GsonBuilder().addSerializationExclusionStrategy(strategy).serializeNulls().create();
			return gson.toJson(object);
		} catch (Exception ex) {
			logger.error("ERROR : " , ex);
		}
		return null;
	}

	@Override
	public <T> String ignoreExcludeFields(T object) {

		Gson gson = null;
		try {
			gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			return gson.toJson(object);
		} catch (Exception ex) {
			logger.error("ERROR : " , ex);
		}
		return null;
	}

	@Override
	public <T> String convertEntityToJsonProxy(T object, ExclusionStrategy strategy) {
		Gson gson = null;
		try {
			GsonBuilder b = new GsonBuilder();
			b.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);
			b.addSerializationExclusionStrategy(strategy);
			gson = b.serializeNulls().create();
			return gson.toJson(object);
		} catch (Exception ex) {
			logger.error("ERROR : " , ex);
		}
		return null;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public <T> List<T> convertJsonToEntityList(String json, Class<T> clazz) {
		ObjectMapper mapper = null;
		List<T> object = new ArrayList<>();
		;
		try {
		if (json == null)
		return null;
		mapper = new ObjectMapper();
		object = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, clazz));

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return (List<T>) object;
	}

}
