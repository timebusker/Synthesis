package aa.mine.superutil.thirdparty.gson;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.FieldNamingStrategy;

/**
 * Gson字段重命名
 * @author Goofy
 *
 */
public class GsonKeyRename implements FieldNamingStrategy {
	
	public Map<String,String> map;

	public GsonKeyRename(Map<String,String> map) {
		super();
		this.map = map;
	}

	public String translateName(Field f) {
		
		Iterator<Entry<String, String>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Entry<String,String> entry=it.next();
			if(entry.getKey().equalsIgnoreCase(f.getName()))
				return entry.getValue();
		}
		
		return f.getName();
	}
	
}
