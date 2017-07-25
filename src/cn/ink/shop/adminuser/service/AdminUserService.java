package cn.ink.shop.adminuser.service;

import org.springframework.transaction.annotation.Transactional;

import cn.ink.shop.adminuser.dao.AdminUserDao;
import cn.ink.shop.adminuser.vo.AdminUser;

@Transactional
public class AdminUserService {
	// ×¢ÈëDao
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
}
