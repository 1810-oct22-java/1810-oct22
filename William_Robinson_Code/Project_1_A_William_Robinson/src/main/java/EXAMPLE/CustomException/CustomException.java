package EXAMPLE.CustomException;


	public class CustomException  extends Exception{
		public CustomException() {
			super("An Unexpected Error Occurred. Please log in again.");
		}
	}


