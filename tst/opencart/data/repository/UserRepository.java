package opencart.data.repository;

public final class UserRepository {
	
	private static volatile UserRepository instance = null;

	private UserRepository() {
	}
	
	public static UserRepository get() {
		if(instance == null) {
			synchronized (UserRepository.class) {
				if(instance == null) {
					instance = new UserRepository();
				}
			}
		}
		return instance;
	}
	
	public IUser wrongCreds() {
		return User.getUser()
				.setEmail("wrongEmail")
				.setPassword("wrongPassword")
				.build();
	}	
	public IUser wrongEmail() {
		return User.getUser()
				.setEmail("wrongEmail")
				.setPassword("Asdfg12@")
				.build();
	}	
	public IUser wrongPassword() {
		return User.getUser()
				.setEmail("bomemailn@gmail.com")
				.setPassword("wrongPassword")
				.build();
	}	
	public IUser emptyCreds() {
		return User.getUser()
				.setEmail("")
				.setPassword("")
				.build();
	}	
	public IUser correctUser() {
		return User.getUser()
				.setEmail("bomemailn@gmail.com")
				.setPassword("Asdfg12@")
				.build();
	}
	public IUser dafault() {
		return wrongCreds();
	}
}
