package com.ccloudedu.quartz.test.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.quartz.test.TestOneJob;
/**
 * 一个定时任务
 * @author wade
 *
 */
@Service
@Transactional
public class TestOneJobImpl implements TestOneJob{

	private String dd;
	
	public String getDd() {
		return dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	public void aMethodInThisJob() {
//		System.out.println(dd);
//		System.out.println("我是一个任务，我启动啦！我是十秒钟启动一次吗？");
	}

}
