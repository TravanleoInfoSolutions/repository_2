package FormBuilderByHackers.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.ExclusionStrategy;
import com.google.gson.Gson;

import java.util.List;

/**
 * JSON converter
 * 
 * @author bhavesh
 */
public interface JsonConverter {

	/**
	 * Converts an Json to Object with the use of {@link ObjectMapper} of
	 * Jackson Api.
	 * 
	 * @param json
	 *            : json needs to be converted into a Class object.
	 * @param clazz
	 *            : Class object that need to be converted by the
	 *            {@link ObjectMapper}
	 *
	 * @return : Class Object that was asked to be converted from provided json.
	 * @see : ObjectMapper
	 * 
	 */

	public <T> T convertJsonToEntity(String json, Class<T> clazz);

	public <T> List<T> convertJsonToEntityList(String json, Class<T> clazz);
	/**
	 * Converts an Object to Json with the use of {@link ObjectMapper} of
	 * Jackson Api.
	 * 
	 * @param object
	 *            : Object needs to be converted into json.
	 *
	 * @return : Json created string for the givin object.
	 * @see : ObjectMapper
	 * 
	 */
	public <T> String convertEntityToJson(T object);

	/**
	 * Converts an Object to Json with the use of {@link Gson} Api.
	 * 
	 * @param object
	 *            : Object needs to be converted into json.
	 * @param strategy
	 *            : {@link ExclusionStrategy} that will help to create a proper
	 *            strategy for producing desired json formatted data.
	 * @return : Json created string for the givin object.
	 * @see : Gson
	 * @see : GsonBuilder
	 */
	public <T> String convertEntityToJson(T object, ExclusionStrategy strategy);

	/**
	 * 
	 * @param object
	 * @return
	 */
	public <T> String ignoreExcludeFields(T object);

	/**
	 * Converts an  Object(proxy) to Json with the use of {@link Gson} Api
	 * 
	 * @param object
	 *            : Object needs to be converted into json.
	 * @param strategy
	 *            : {@link ExclusionStrategy} that will help to create a proper
	 *            strategy for producing desired json formatted data.
	 * @return : Json created string for the givin object.
	 * @see : Gson
	 * @see : GsonBuilder
	 */
	public <T> String convertEntityToJsonProxy(T object, ExclusionStrategy strategy);
}
