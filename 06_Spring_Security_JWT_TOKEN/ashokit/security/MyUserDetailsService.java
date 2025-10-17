package in.ashokit.security;

@Service
public class MyUserDetailsService implements UserDetailsService{
	@Override
	public UserDetails loadUserByUsername(String s) {
		return new user("admin","$2a$12$/zvza0MkB1zp2B42kuZ5p./8xFFeTLdU4PHXmcLAHxlOU30v0pOv.",new ArrayList<>());
	}

}
