package com.ccloudedu.base.web.fckeditor;

import javax.servlet.http.HttpServletRequest;

import net.fckeditor.requestcycle.UserAction;


public class UserActionImpl implements UserAction {
	public boolean isEnabledForFileBrowsing(HttpServletRequest request) {
		return true;
	}

	public boolean isEnabledForFileUpload(HttpServletRequest request) {
		return true;
	}
}
