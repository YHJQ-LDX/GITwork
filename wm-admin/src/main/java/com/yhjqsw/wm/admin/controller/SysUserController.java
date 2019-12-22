package com.yhjqsw.wm.admin.controller;

import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.yhjqsw.wm.admin.model.UserPassword;
import com.yhjqsw.wm.common.aspect.constants.SysConstants;
import com.yhjqsw.wm.admin.model.SysUser;
import com.yhjqsw.wm.admin.sevice.SysUserService;
import com.yhjqsw.wm.admin.util.PasswordUtils;
import com.yhjqsw.wm.core.http.HttpResult;
import com.yhjqsw.wm.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户控制器
 * @author Louis
 * @date Oct 29, 2018
 */
@RestController
@RequestMapping("user")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	
	@PreAuthorize("hasAuthority('sys:user:add') AND hasAuthority('sys:user:edit')")
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysUser record) {
		SysUser user = sysUserService.findById(record.getId());
		if(user != null) {
			if(SysConstants.ADMIN.equalsIgnoreCase(user.getName())) {
				return HttpResult.error("超级管理员不允许修改!");
			}
		}
		if(record.getPassword() != null) {
			String salt = PasswordUtils.getSalt();
			if(user == null) {
				// 新增用户
				if(sysUserService.findByName(record.getName()) != null) {
					return HttpResult.error("用户名已存在!");
				}
				String password = PasswordUtils.encode(record.getPassword(), salt);
				record.setSalt(salt);
				record.setPassword(password);
			} else {
				// 修改用户, 且修改了密码
				if(!record.getPassword().equals(user.getPassword())) {
					String password = PasswordUtils.encode(record.getPassword(), salt);
					record.setSalt(salt);
					record.setPassword(password);
				}
			}
		}
		try {
			return HttpResult.ok(sysUserService.save(record));
		} catch (Exception e) {
			e.printStackTrace();
			return HttpResult.error(e.getMessage());
		}
	}

	@PostMapping(value="/update")
	public HttpResult update(@RequestBody SysUser record) {
		SysUser user = sysUserService.findByName(record.getName());
		if(user != null) {
			if(SysConstants.ADMIN.equalsIgnoreCase(user.getName())) {
				return HttpResult.error("超级管理员不允许修改!");
			}
		}
		record.setId(user.getId());
		record.setLastUpdateBy(record.getName());
		record.setLastUpdateTime(new Date());
		try {
			return HttpResult.ok(sysUserService.update(record));
		} catch (Exception e) {
			e.printStackTrace();
			return HttpResult.error(e.getMessage());
		}
	}

	@PostMapping(value="/updatepass")
	public HttpResult updatepass(@RequestBody UserPassword record) {

		SysUser user = sysUserService.findByName(record.getUsername());
		String salt = PasswordUtils.getSalt();
		String oldpassword = record.getOldpassword();
		if (!PasswordUtils.matches(user.getSalt(), oldpassword, user.getPassword())) {
			return HttpResult.error("您输入的原密码不正确！");
		}else{
			String password = PasswordUtils.encode(record.getNewpassword(), salt);
			user.setSalt(salt);
			user.setPassword(password);
		}
		user.setLastUpdateBy(user.getName());
		user.setLastUpdateTime(new Date());
		try {
			return HttpResult.ok(sysUserService.update(user));
		} catch (Exception e) {
			e.printStackTrace();
			return HttpResult.error(e.getMessage());
		}
	}

	@PreAuthorize("hasAuthority('sys:user:delete')")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysUser> records) {
		for(SysUser record:records) {
			SysUser sysUser = sysUserService.findById(record.getId());
			if(sysUser != null && SysConstants.ADMIN.equalsIgnoreCase(sysUser.getName())) {
				return HttpResult.error("超级管理员不允许删除!");
			}
		}
		return HttpResult.ok(sysUserService.delete(records));
	}
	
//	@PreAuthorize("hasAuthority('sys:user:view')")
	@PostMapping(value="/findByName")
	public HttpResult findByUserName(@RequestParam String name) {
		return HttpResult.ok(sysUserService.findByName(name));
	}
	
//	@PreAuthorize("hasAuthority('sys:user:view')")
	@GetMapping(value="/findPermissions")
	public HttpResult findPermissions(@RequestParam String name) {
		return HttpResult.ok(sysUserService.findPermissions(name));
	}
	
//	@PreAuthorize("hasAuthority('sys:user:view')")
	@GetMapping(value="/findUserRoles")
	public HttpResult findUserRoles(@RequestParam Long userId) {
		return HttpResult.ok(sysUserService.findUserRoles(userId));
	}

//	@PreAuthorize("hasAuthority('sys:user:view')")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysUserService.findPage(pageRequest));
	}
	
}
