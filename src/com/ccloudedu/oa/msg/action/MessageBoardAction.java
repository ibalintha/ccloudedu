package com.ccloudedu.oa.msg.action;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.ccloudedu.base.constants.Constants;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.web.Servlets;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.base.web.render.Renders;
import com.ccloudedu.base.web.struts2.action.BaseCrudAction;
import com.ccloudedu.oa.msg.entity.OaMessageBoard;
import com.ccloudedu.oa.msg.service.MessageBoardService;
/**
 * 留言板
 * @author wade
 */
@Scope("prototype")
@Controller("oa.msg.action.MessageBoardAction")
public class MessageBoardAction extends BaseCrudAction<OaMessageBoard> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private OaMessageBoard messageBoard;
	private Page page = new Page(Constants.PAGE_SIZE);
	@Autowired
	private MessageBoardService messageBoardService;
	
	public OaMessageBoard getModel() {
		return messageBoard;
	}
	
	public void prepareModel() throws Exception {
		//新增
		if(StringUtils.isEmpty(id)){
			messageBoard = new OaMessageBoard();
			messageBoard.setCreateTime(DateUtils.getCurrentDate("yyyy-MM-dd"));
			messageBoard.setMessager(Sessions.getSysUser());
		}else{//修改/查看
			messageBoard = messageBoardService.get(id);
		}
	}
	@Override
	public String detail() throws Exception {
		return DETAIL;
	}
    public String add() throws Exception {
		return ADD;
	}
    
    public String update() throws Exception {
		return UPDATE;
	}

	public String save() throws Exception {
		if(StringUtils.isEmpty(id)){
			messageBoardService.save(messageBoard);
			Renders.renderJson(Renders.SAVE_SUCCESS);
		}else{
			messageBoardService.update(messageBoard);
			Renders.renderJson(Renders.UPDATE_SUCCESS);
		}
		return NONE;
	}

	public String delete() throws Exception {
		String ids = Servlets.getRequest().getParameter("ids");
		messageBoardService.deleteByIds(ids.split(","));
		Renders.renderJson(Renders.DELETE_SUCCESS);
		return NONE;
	}

	public String list() throws Exception {
		page = messageBoardService.findPage(page);
		return LIST;
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

}
