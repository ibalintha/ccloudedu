package com.ccloudedu.cms.action;

import java.util.HashMap;
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
import com.ccloudedu.base.utils.file.FreemarkUtils;
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

@Controller("cms.TempletAction")
@Scope("prototype")
public class TempletAction extends BaseCrudAction<CmsTemplet> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String parentId;
	private String parentName;
	private Page page = new Page(Constants.PAGE_SIZE);
	private CmsTemplet cmsTemplet;
	private List<CmsTemplet> templetList;
	
	private String fckContent;
	//private String fckContentPath="/WEB-INF/ftl/home/";
	
	@Autowired
	private TempletService templetService;
	@Autowired
	private ChannelService channelService;
	public CmsTemplet getModel() {
		return cmsTemplet;
	}
	@Override
	public void prepareModel() throws Exception {
		if(StringUtils.isBlank(id)){
			cmsTemplet = new CmsTemplet();
			cmsTemplet.setCreateTime(DateUtils.getCurrentDate());
			cmsTemplet.setCreateUser(Sessions.getSysUser());
			if(StringUtils.isNotEmpty(parentId)){
				//新增非一级模板
				cmsTemplet.setCmsTemplet(templetService.get(parentId));
			}
		}
		else{
			cmsTemplet = templetService.get(id);
			Servlets.getSession().setAttribute("templetId", cmsTemplet.getId());
		}
	}
	
	@Override
	public String detail() throws Exception {
		return DETAIL;
	}
	 public String update() throws Exception {
		 return UPDATE;
	 }
	 
	@Override
	public String save() throws Exception {
		/*Set<CmsChannel> channelSet = null;
		CmsChannel channel = null;
		//所属栏目id
		String channelIdStr = Servlets.getRequest().getParameter("channelIds");
		if(StringUtils.isNotEmpty(channelIdStr)){
			String[] channelIds = channelIdStr.split(",");
			if(channelIds!=null && channelIds.length>0){
				channelSet = new HashSet<CmsChannel>();
				for(int i=0;i<channelIds.length;i++){
				   channel = channelService.get(channelIds[i]);
				   channelSet.add(channel);
			   }	
			}
		}
		if(channelSet!=null && channelSet.size()>0){
			cmsTemplet.setCmsChannels(channelSet);
		}else{
			cmsTemplet.setCmsChannels(null);
		}*/
		if(StringUtils.isEmpty(id)){
			templetService.save(cmsTemplet);
			Renders.renderJson(new EasyUiResult("0","保存成功",Lists.newArrayList(cmsTemplet.getId())));
		}else{
			templetService.update(cmsTemplet);
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		
		//将模板内容写入文件
		if(StringUtils.isNotEmpty(fckContent)){
			String tp = cmsTemplet.getTempletPath();
			int li = tp.lastIndexOf("/");
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("content", fckContent);
			FreemarkUtils.createStaticContent("/WEB-INF/ftl/fckcontent.ftl",tp.substring(0, li+1), tp.substring(li+1), map);
		}
		return NONE;
	}
	
	
	public String add()throws Exception{
		try{
			cmsTemplet = templetService.get(id);
			setParentId(id);
			setParentName(cmsTemplet.getTempletName());
		}catch (Exception e) {
			addActionMessage("没有上级模板，请先选择上级模板色");
		}
		return ADD;
	}
	
	
	@Override
	public String list() throws Exception {
		if(StringUtils.isNotBlank(id)){
			Map<String,String> paramMap = new HashMap<String,String>();
			paramMap.put("parentId", id);
			page = templetService.findPage(page, "cmsfindTempletsByParentId",paramMap);
		}else{
			page = templetService.findPage(page, "cms.findTemplets",null);
		}
		return LIST;
	}
	@Override
	public String delete() throws Exception {
		String ids = Servlets.getRequest().getParameter("ids");
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
	}
	
	@Menu
	@SuppressWarnings("unchecked")
	public String tree() throws Exception {
		templetList = templetService.findList("cms.findTemplets",null);
		return TREE;
	}
	
	
	public String getChannels()throws Exception{
		String checkIds = "1";
		String templetId = Servlets.getRequest().getParameter("customerParam");
		if(StringUtils.isEmpty(templetId)){
			templetId = (String) Servlets.getSession().getAttribute("templetId");
			Servlets.getSession().removeAttribute("templetId");
		}
		if(StringUtils.isNotEmpty(templetId)){
			cmsTemplet = templetService.get(templetId);
			Set<CmsChannel> channelSet = cmsTemplet.getCmsChannels();
			if(channelSet!=null && channelSet.size()>0){
				for(CmsChannel cmsChannel : channelSet){
					checkIds+=","+cmsChannel.getId();
				}
			}
		}
		
		CmsChannel cmsChannel = null;
		id = Servlets.getRequest().getParameter("id");
		String sc = "";
		
		return NONE;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<CmsTemplet> getTempletList() {
		return templetList;
	}
	public void setTempletList(List<CmsTemplet> templetList) {
		this.templetList = templetList;
	}
	public void setTempletService(TempletService templetService) {
		this.templetService = templetService;
	}
	public void setChannelService(ChannelService channelService) {
		this.channelService = channelService;
	}
	public String getFckContent() {
		return fckContent;
	}
	public void setFckContent(String fckContent) {
		this.fckContent = fckContent;
	}
	/*public String getFckContentPath() {
		return fckContentPath;
	}
	public void setFckContentPath(String fckContentPath) {
		this.fckContentPath = fckContentPath;
	}*/
	
}
