package com.ccloudedu.oa.msg.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.annotation.LoginValidation;
import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.constants.enums.YN;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseUploadFileAction;
import com.ccloudedu.oa.msg.entity.OaIntenalMessage;
import com.ccloudedu.oa.msg.service.IntenalMessageService;
import com.ccloudedu.system.entity.SysUser;
import com.ccloudedu.system.service.UserService;

@Controller("oa.msg.action.IntenalMessageAction")
@Scope("prototype")
public class IntenalMessageAction extends BaseUploadFileAction<OaIntenalMessage> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private SysUser receiver;
	private String receiverId;
	
	private OaIntenalMessage intenalMessage;
	private List<OaIntenalMessage> iMsgList = new ArrayList<OaIntenalMessage>(0);
	private Page page = new Page(Constants.PAGE_SIZE);
	@Autowired
	private IntenalMessageService intenalMessageService;
	@Autowired
	private UserService userService;
	
	private String receiverIds;
	private String sendTime;
	private String msgContent;
	private String msgTitle;
	
	private String fromMsgtip;
	
	//查询参数
    private String queryType;
	private String receiverName;
	private String senderName;
	private String isRead;
	
	
	public OaIntenalMessage getModel() {
		return intenalMessage;
	}
	
	public void prepareModel() throws Exception {
		//新增
		if(StringUtils.isEmpty(id)){
			String[] receiverIdsa = receiverIds.split(",");
			if(receiverIdsa!=null && receiverIdsa.length>0){
				SysUser receiver = null;
				for(String receiverId : receiverIdsa){
					if(StringUtils.isNotEmpty(receiverId)){
						receiver = userService.get(receiverId);
						intenalMessage = new OaIntenalMessage();
						intenalMessage.setIsRead("0");//0:未阅读，1：已阅读
						intenalMessage.setCreateTime(DateUtils.getCurrentDate());
						intenalMessage.setCreateUser(Sessions.getSysUser());
						intenalMessage.setSender(Sessions.getSysUser());
						intenalMessage.setSendTime(DateUtils.getCurrentDate());
						intenalMessage.setMsgTitle(msgTitle);
						intenalMessage.setMsgContent(msgContent);
						intenalMessage.setReceiver(receiver);
					
						iMsgList.add(intenalMessage);
					}
				}
			}
		}else{//修改/查看
			intenalMessage = intenalMessageService.get(id);
			if("2".equals(queryType) && "0".equals(intenalMessage.getIsRead())){
				intenalMessage.setIsRead("1");//已阅读
				intenalMessage.setReadTime(DateUtils.getCurrentDate());
				intenalMessageService.update(intenalMessage);
			}
			
			//获得附件
			setUploadFileList(getUploadFileService().findByOwnerId(intenalMessage.getId()));
		}
	}
	@Override
	public String detail() throws Exception {
		return DETAIL;
	}
    public String add() throws Exception {
    	if(StringUtils.isNotEmpty(receiverId)){
    		receiver = userService.get(receiverId);
    	}
		return ADD;
	}
    
    public String update() throws Exception {
    	setFromMsgtip(fromMsgtip);
		return UPDATE;
	}
    
    public void prepareRead() throws Exception{
    	intenalMessage = intenalMessageService.get(id);
    	
    	//获得附件
		setUploadFileList(getUploadFileService().findByOwnerId(intenalMessage.getId()));
		
        if("0".equals(intenalMessage.getIsRead())){
    		intenalMessage.setIsRead("1");//已阅读
    		intenalMessage.setReadTime(DateUtils.getCurrentDate());
    		intenalMessageService.update(intenalMessage);
    	}
    }
    /**
     * 查看消息
     * @return
     * @throws Exception
     */
    public String read() throws Exception {
		return "read";
	}

	public String save() throws Exception {
    	String uploadPath = "uploadfile/oa/message";
		if(StringUtils.isEmpty(id)){
			if(iMsgList!=null && iMsgList.size()>0){
				intenalMessageService.save(iMsgList,uploadPath,getUpload(),getUploadFileName(),getUploadContentType());
			}
			Renders.renderJson(Renders.SAVE_SUCCESS);
		}else{
			intenalMessageService.update(intenalMessage,uploadPath,getUpload(),getUploadFileName(),getUploadContentType());
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}

	public String delete() throws Exception {
		String ids = Servlets.getRequest().getParameter("ids");
		String[] arrayIds = ids.split(",");
		int updateCount = intenalMessageService.batchUpdateOrDelete(arrayIds);
		if(updateCount==arrayIds.length){
			Renders.renderJson(Renders.DELETE_SUCCESS);
		}
		return NONE;
	}

	public String list() throws Exception {
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("msgTitle", msgTitle);
		paramMap.put("receiverName", receiverName);
		paramMap.put("senderName", senderName);
		paramMap.put("isRead", isRead);
		if("1".equals(queryType)){
			paramMap.put("senderId", Sessions.getSysUser().getId());
		}else{
			paramMap.put("receiverId", Sessions.getSysUser().getId());
		}
		page = intenalMessageService.findPage(page, paramMap);
		return LIST;
	}
	
	/**
	 * 定时检查是否有新消息
	 * @return
	 * @throws Exception
	 */
	@LoginValidation(validate=YN.N)
	public String getNewMessage()throws Exception{
		Map<String,String> paramMap = new HashMap<String,String>();
		paramMap.put("receiverId", Sessions.getSysUser().getId());
		paramMap.put("isRead", "0");
		List<OaIntenalMessage> list = intenalMessageService.findList(paramMap);
		if(list!=null && list.size()>0){
			OaIntenalMessage omsg = list.get(0);
			Renders.renderJson(omsg.getId()+"|"+omsg.getMsgTitle());
		}else{
			Renders.renderJson("");
		}
		return NONE;
	}
	//----------------------------------------以下是getter/setter方法-------------------------------
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public void setIntenalMessageService(IntenalMessageService intenalMessageService) {
		this.intenalMessageService = intenalMessageService;
	}
	public List<OaIntenalMessage> getiMsgList() {
		return iMsgList;
	}

	public void setiMsgList(List<OaIntenalMessage> iMsgList) {
		this.iMsgList = iMsgList;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public SysUser getReceiver() {
		return receiver;
	}

	public void setReceiver(SysUser receiver) {
		this.receiver = receiver;
	}

	public String getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(String receiverId) {
		this.receiverId = receiverId;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getIsRead() {
		return isRead;
	}

	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	public String getFromMsgtip() {
		return fromMsgtip;
	}

	public void setFromMsgtip(String fromMsgtip) {
		this.fromMsgtip = fromMsgtip;
	}

	public String getReceiverIds() {
		return receiverIds;
	}

	public void setReceiverIds(String receiverIds) {
		this.receiverIds = receiverIds;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public UserService getUserService() {
		return userService;
	}
}
