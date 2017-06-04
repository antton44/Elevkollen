package factory;

import entities.Entity;
import entities.Parent;
import entities.Student;
import entities.Teacher;

public class EntityFactory implements Entities{
	
	public EntityFactory()
	{
		
	}
	//Exempel: f.getEntity(Entities.STUDENT, dto.name, dto.personnummer, dto.email));
	public Entity getEntity(String type, String name, String personnummer, String email){
	      if(type == null){
	         return null;
	      }		
	      if(type.equals("student")){
	         return new Student(name, personnummer, email);
	         
	      } else if(type.equalsIgnoreCase("teacher")){
	         return new Teacher(name, personnummer, email);
	         
	      } else if(type.equalsIgnoreCase("parent")){
	         return new Parent(name, personnummer, email);
	      }
	      return null;
	   }
}
