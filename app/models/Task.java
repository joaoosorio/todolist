package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.data.validation.Constraints.Required;
import play.db.ebean.*;

@Entity
public class Task extends Model{
	
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;
	
	@Required
	public String label;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Finder<Long,Task> find = new Finder(Long.class, Task.class);

	public static List<Task> all(){
		return find.all();
	}
	
	public static void create(Task task){
		task.save();
	}
	
	public static void delete(Long id){
		find.ref(id).delete();
	}
}
