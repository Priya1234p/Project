package in.ashokit.service;

import in.ashokit.binding.LoginForm;
import in.ashokit.binding.SignUpForm;
import in.ashokit.binding.UnlockForm;
import in.ashokit.utils.PwdUtils;

public class UserServiceImpl implements UserService {

	@Override
	public String login(LoginForm form) {
	
		return null;
	}

	@Override
	public boolean signUp(SignUpForm form) {
		String tempPwd = PwdUtils.generateRandomPwd();
		return false;
	}

	@Override
	public boolean unlockAccount(UnlockForm form) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String forgetPassword(String email) {
		// TODO Auto-generated method stub
		return null;
	}

}
