package dalSerializable;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.List;
import DTO.UserDTO;
import exceptions.DALException;
import interfacesDAO.IUserDAO;

public class SerUserDAO implements IUserDAO{
	
	private List<UserDTO> users  = new ArrayList<UserDTO>();
	private final String pathName;
	
	public SerUserDAO(){
		pathName="UserDB.ser";
	}
	
	public SerUserDAO(int i){
		pathName="TestUserDB.ser";
	}
	@Override
	public UserDTO getUser(int oprId) throws DALException {
		loadInfo();
		if (users.size() == 0)
			throw new DALException("The database is empty.");
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getUserId() == oprId) {
				return users.get(i);
			}
		}
		throw new DALException("No user has been found with id: " + oprId);
	}

	@Override
	public List<UserDTO> getUserList() throws DALException {
		loadInfo();
		if (users.size() == 0)
			throw new DALException("There are no users in the database.");
		return users;
	}

	@Override
	public void createUser(UserDTO user) throws DALException {

		loadInfo();

//		user.setPassword(pwg());

		if (users.size() == 88) {
			throw new DALException("Database is full");
		}
//		checkUser(user);
		users.add(user);
		saveInfo();
	}

	@Override
	public void updateUser(UserDTO user) throws DALException {
//		checkUpdatedUser(user);
		loadInfo();
		for (int i = 0; i < users.size(); i++) {
			if (user.getUserId() == users.get(i).getUserId()) {
				users.remove(i);
				users.add(user);
			}
		}
		saveInfo();
	}

	@Override
	public void deleteUser(int userId) throws DALException {
		loadInfo();
		boolean found = false;
		int index = 0;
		for (int i = 0; i < users.size(); i++) {
			if (userId == users.get(i).getUserId()) {
				found = true;
				index = i;
			}
		}
		if (found == true) {
			users.remove(index);
			saveInfo();
		} else
			throw new DALException("No user was found with id: " + userId);
	}
	
	@SuppressWarnings("unchecked")
	public void loadInfo() {

		try {
			InputStream file = new FileInputStream(pathName);
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
			users = (ArrayList<UserDTO>) input.readObject();
			if (users.equals(null))
				users = new ArrayList<UserDTO>();
			input.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (EOFException e) {
			users = new ArrayList<UserDTO>();
		} catch (StreamCorruptedException e) {
			System.out.println("The file is currupted.");
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void saveInfo() {
		try {
			OutputStream file = new FileOutputStream(pathName);
			OutputStream buffer = new BufferedOutputStream(file);
			ObjectOutput output = new ObjectOutputStream(buffer);
			// ObjectOutputStream oos = new ObjectOutputStream(new
			// FileOutputStream(new File("UserInfo.ser")));
			output.writeObject(users);
			// close the writing.
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
