package com.office.library.admin.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {

	@Autowired
	AdminMemberService adminMemberService;

	// 회원가입
	@RequestMapping(value = "/createAccountForm", method = RequestMethod.GET)
	public String createAccountForm() {
		System.out.println("[AdminMembrController] createAccountForm()");
		String nextPage = "admin/member/create_account_form";

		return nextPage;
	}

	// 회원가입 확인
	@RequestMapping(value = "/createAccountConfirm", method = RequestMethod.POST)
	public String createAccountConfirm(AdminMemberVo adminMemberVo) {
		System.out.println("[AdminMemberController] createAccountConfirm()");

		String nextPage = "admin/member/create_account_ok";

		int result = adminMemberService.createAccountConfirm(adminMemberVo);

		if (result <= 0)
			nextPage = "admin/member/create_account_ng";

		return nextPage;
	}

	// 로그인
	@GetMapping("/loginForm")
	public String loginForm() {
		System.out.println("[AdminMemberController] loginForm()");

		String nextPage = "admin/member/login_form";

		return nextPage;
	}

	@PostMapping("/loginConfirm")
	public String loginConfirm(AdminMemberVo adminMemberVo) {
		System.out.println("[AdminMemberController] loginConfirm()");

		String nextPage = "admin/member/login_ok";

		AdminMemberVo loginedAdminMemberVo = adminMemberService.loginConfirm(adminMemberVo);

		if (loginedAdminMemberVo == null) {
			nextPage = "admin/member/login_ng";
		}

		return nextPage;

	}
}
