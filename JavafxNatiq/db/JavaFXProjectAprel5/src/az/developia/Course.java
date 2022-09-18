package az.developia;

public class Course {
	private Integer id;
	private String name;
	private Integer length;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Course(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	@Override
	public String toString() {
		 
		return name;
	}
}
