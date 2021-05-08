package FormBuilderByHackers.Utilities;

/**
 * General response
 * 
 * @author akhil
 *
 */
public class GenericResponse {
	private Object data;
	private String error;
	private boolean status;
	
	public GenericResponse() {
		
	}
	
	public GenericResponse(boolean status) {
		this.setStatus(status);
	}
	
	public GenericResponse(Object data, boolean status) {
		this.setData(data);
		this.setStatus(status);
	}
	
	public GenericResponse(String error) {
		this.setError(error);
		this.setStatus(Boolean.FALSE);
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(final String error) {
		this.error = error;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
