abstract class User{
  private String name;
	private String email; //доступны только из этого класса
  public User(String name){
  	this.name = name;
  }
	public User(String name, String email){  // доступен отовсюду
		this(name);
		this.email = email;
	}
	final protected String getName(){ //доступен только из дочерних
		return this.name;
	}
  final protected String getEmail(){
    return this.email;
  }
}

