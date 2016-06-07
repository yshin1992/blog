package blog.comparator;

import java.util.Comparator;
import java.util.Hashtable;

/**
 * 名称比较器
 * @author Administrator
 *
 */
public class NameComparator implements Comparator {
	
	public int compare(Object a, Object b) {
		Hashtable<String, Object> hashA = (Hashtable<String, Object>)a;
		Hashtable<String, Object> hashB = (Hashtable<String, Object>)b;
		if (((Boolean)hashA.get("is_dir")) && !((Boolean)hashB.get("is_dir"))) {
			return -1;
		} else if (!((Boolean)hashA.get("is_dir")) && ((Boolean)hashB.get("is_dir"))) {
			return 1;
		} else {
			return ((String)hashA.get("filename")).compareTo((String)hashB.get("filename"));
		}
	}
}
