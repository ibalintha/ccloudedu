package com.ccloudedu.base.web.fckeditor;

import javax.servlet.http.HttpServletRequest;

import net.fckeditor.requestcycle.UserPathBuilder;


public class UserPathBuilderImpl implements UserPathBuilder {

	public String getUserFilesPath(HttpServletRequest request) {
		
		return "/uploadfile/fckfile";
	}

}
