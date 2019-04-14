package b31_l12_maps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class MapPhoneDirectory implements PhoneDirectory, Serializable {
	static final int MAX_DIRECTORY_SIZE = 20;
	private Map<Name, String> map;
	int directorySize;
	String filename;
	
	public MapPhoneDirectory() {
		super();
		map = new HashMap<Name, String>(MAX_DIRECTORY_SIZE);
		filename = "phoneDirectory.ser";
		directorySize = 0;
		loadData();
	}

	@Override
	public void loadData() {
		try {
			FileInputStream file = new FileInputStream(filename);
			ObjectInputStream read = new ObjectInputStream(file);
			
			MapPhoneDirectory temp = (MapPhoneDirectory) read.readObject();
			map = temp.getMap();
			
			read.close();
			file.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
		catch (IOException e) {
			System.out.println("Read IOException");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("Class not found");
		}
	}
	
	public Map<Name,String> getMap() {
		return map;
	}

	@Override
	public String lookupEntry(String first, String last) {
		return lookupEntry(new Name(first, last));
	}
	
	public String lookupEntry(Name name) {
		for (Name curr : map.keySet())
			if (curr.equals(name))
				return map.get(curr);
		return null;
	}

	@Override
	public boolean addEntry(String first, String last, String number) {
		if (lookupEntry(new Name(first, last)) == null) {
			map.put(new Name(first, last), number);
			directorySize--;
			return true;
		}
		return false;
	}

	@Override
	public String changeEntry(String first, String last, String number) {
		String oldPhone = lookupEntry(first, last);
		if (oldPhone != null) {
			for (Name curr : map.keySet())
				if (curr.equals(new Name(first, last)))
					map.put(curr, number);
		}
		return oldPhone;
	}

	@Override
	public String removeEntry(String first, String last) {
		System.out.println(first + last);
		return map.remove(new Name(first, last));
	}

	@Override
	public void save() {
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream write = new ObjectOutputStream(file);
			
			write.writeObject(this);
			
			write.close();
			file.close();
		}
		catch (IOException e) {
			System.out.println("Write IOException");
		}
	}
}