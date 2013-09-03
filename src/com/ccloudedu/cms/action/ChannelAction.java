package com.ccloudedu.cms.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.Menu;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.EasyUiResult;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.cms.entity.CmsChannel;
import com.ccloudedu.cms.entity.CmsTemplet;
import com.ccloudedu.cms.service.ChannelService;
import com.ccloudedu.cms.service.TempletService;
import com.google.common.collect.Lists;

@Controller("cms.ChannelAction")
@Scope("prototype")
public class ChannelAction extends BaseCrudAction<CmsChannel>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CmsChannel channel;
	private String id;
	private String parentId;
	private String parentName;
	private String channelModelId;
	private Page page = new Page(Constants.PAGE_SIZE);
	private List<CmsChannel> channelList;
	private List<CmsTemplet> templeteList;
	private List<String> templeteIds;
	
	private String fckContent;
	private String fckContentPath="/WEB-INF/ftl/home/";
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private TempletService templetService;
	
	public CmsChannel getModel() {
		return channel;
	}
	
	@Override
	public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			channel = new CmsChannel();
			channel.setCreateTime(DateUtils.getCurrentDate());
			channel.setCreateUser(Sessions.getSysUser());
			this.setParentChannelAndModel();
		}
		else{
			channel = channelService.get(id);
		}
		
	}
	@Override
	public String detail() throws Exception {
		return DETAIL;
	}
	public String add() throws Exception {
		try{
			 channel = channelService.get(id);
			 setParentId(id);
			 setParentName(channel.getChannelName());
			 templeteList = templetService.findListExclude("公共页模板");
		}catch (Exception e) {
			addActionMessage("没有上级栏目，请先选择上级栏目");
		}
		return ADD;
	}

   public String update() throws Exception {
	    templeteList = templetService.findListExclude("公共页模板");
		return UPDATE;
   }
	@Override
	public String save() throws Exception {
		//channel.setCmsChannelModel(channelModelService.get(channelModelId));
		if(templeteIds!=null && templeteIds.size()>0){
			Set<CmsTemplet> templetSet = new HashSet<CmsTemplet>();
			CmsTemplet templet = null;
			for(String templetId : templeteIds){
				if(StringUtils.isNotBlank(templetId)){
					templet = new CmsTemplet();
					templet.setId(templetId);
					templetSet.add(templet);
				}
			}
			if(templetSet.size()>0){
				channel.setCmsTemplets(templetSet);
			}
		}
		if(StringUtils.isBlank(id)){
			channelService.save(channel);
			Renders.renderJson(new EasyUiResult("0","保存成功",Lists.newArrayList(channel.getId())));
		}
		else{
			channelService.update(channel);
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}
    public String delete() throws Exception {
		String ids = Servlets.getRequest().getParameter("ids");
		channelService.deleteByIds(ids.split(","));
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
	}

	@Override
	public String list() throws Exception {
		if(StringUtils.isNotBlank(id)){
			Map<String,String> paramMap = new HashMap<String,String>();
			paramMap.put("parentId", id);
			page = channelService.findPage(page, "cms.findChannelsByParentId",paramMap);
		}else{
			page = channelService.findPage(page, "cms.findChannels",null);
		}
		
		return LIST;
	}
	@Menu
	@SuppressWarnings("unchecked")
	public String tree() throws Exception {
		channelList = channelService.findList("cms.findChannels",null);
		return TREE;
	}
	
	@SuppressWarnings("unchecked")
	public String generateChannelTree() throws Exception {
		channelList = channelService.findList("cms.findChannels",null);
		return "left";
	}
	
	public void setParentChannelAndModel() throws Exception{
		if(StringUtils.isNotBlank(parentId)){
			  CmsChannel parentChannel = channelService.get(parentId);
			  channel.setCmsChannel(parentChannel);
		   }
		   if(StringUtils.isNotBlank(channelModelId)){
			   //CmsChannelModel channelModel = channelModelService.get(channelModelId);
			  // channel.setCmsChannelModel(channelModel);
		   }
	}
	//--------------------getter/setter方法-------------------------
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setChannelService(ChannelService channelService) {
		this.channelService = channelService;
	}
	public List<CmsChannel> getChannelList() {
		return channelList;
	}
	public void setChannelList(List<CmsChannel> channelList) {
		this.channelList = channelList;
	}
	public String getChannelModelId() {
		return channelModelId;
	}
	public void setChannelModelId(String channelModelId) {
		this.channelModelId = channelModelId;
	}
	
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getFckContent() {
		return fckContent;
	}
	public void setFckContent(String fckContent) {
		this.fckContent = fckContent;
	}
	public String getFckContentPath() {
		return fckContentPath;
	}
	public void setFckContentPath(String fckContentPath) {
		this.fckContentPath = fckContentPath;
	}
	public void setTempletService(TempletService templetService) {
		this.templetService = templetService;
	}
	public List<CmsTemplet> getTempleteList() {
		return templeteList;
	}
	public void setTempleteList(List<CmsTemplet> templeteList) {
		this.templeteList = templeteList;
	}
	public List<String> getTempleteIds() {
		return templeteIds;
	}
	public void setTempleteIds(List<String> templeteIds) {
		this.templeteIds = templeteIds;
	}
}
