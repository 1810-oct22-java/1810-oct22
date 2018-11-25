package EXAMPLE.service;
//https://howtodoinjava.com/security/how-to-generate-secure-password-hash-md5-sha-pbkdf2-bcrypt-examples/
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {
	  private String passwordToHash = "";
	  private String generatedPassword = null;
	  public Hash() {
		  
	  }
	  public Hash(String passwordToHash) {
		  this.passwordToHash = passwordToHash;
	  }
	  
	  public String getgeneratedPassword() {
		  return generatedPassword;
	  }
	  public void setgeneratedPassword(String generatedPassword) {
		  this.generatedPassword = generatedPassword;
	  }
	  public String getpasswordToHash(){
		  return passwordToHash;
	  }
	  public void setpasswordToHash(String passwordToHash){
		  this.passwordToHash= passwordToHash;
	  }
	  public String hashed(String passwordToHash){
			Hash hash = new Hash(passwordToHash);
			hash.setpasswordToHash(passwordToHash);
			try {
		        // Create MessageDigest instance for MD5
		        MessageDigest md = MessageDigest.getInstance("MD5");
		        //Add password bytes to digest
		        md.update(hash.getpasswordToHash().getBytes());
		        //Get the hash's bytes
		        byte[] bytes = md.digest();
		        //This bytes[] has bytes in decimal format;
		        //Convert it to hexadecimal format
		        StringBuilder sb = new StringBuilder();
		        for(int i=0; i< bytes.length ;i++)
		        {
		            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		        }
		        //Get complete hashed password in hex format
		        generatedPassword = sb.toString();
		        hash.setgeneratedPassword(generatedPassword);
		    }
		    catch (NoSuchAlgorithmException e)
		    {
		        e.printStackTrace();
		    }
		  return hash.getgeneratedPassword();
	  }

}

