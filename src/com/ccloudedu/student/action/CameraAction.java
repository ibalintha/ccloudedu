package com.ccloudedu.student.action;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.apache.commons.codec.binary.Base64;

import com.ccloudedu.base.utils.ImageCompress;
import com.ccloudedu.base.utils.OperateImage;
import com.ccloudedu.base.utils.ParseString;
import com.ccloudedu.base.utils.ReadProperties;
import com.ccloudedu.base.web.struts2.action.BaseUploadFileAction;
import com.ccloudedu.common.entity.ChSchoolroll;
import com.ccloudedu.student.service.SchoolRollService;
/**
 * 学籍管理action
 * @author Pescadito
 * 2013-07-22 17:28
 */
@Controller("student.action.CameraAction")
@Scope("prototype")
public class CameraAction extends BaseUploadFileAction<ChSchoolroll> {

	private static final long serialVersionUID = 1L;
	private String id;//学籍信息id
	
	@Autowired
	private SchoolRollService SchoolRollService;
	/**
	 * 打开照相页面
	 * @return
	 */
	public String openDialog(){
		//通过url传递学生的学籍id
		id = ServletActionContext.getRequest().getParameter("id");
		System.out.println(id);
		return "open";
	}
	/**
	 * 保存照相机拍摄的图片
	 * @return
	 * @throws IOException 
	 */
	public @ResponseBody void saveBigPic(String msg) throws IOException{
		//HttpServletRequest req = ServletActionContext.getRequest();
		//从配置文件读取头像的保存路径
		String savePath = ReadProperties.read("iconDir");
//		String savePath="F:\\pics\\";

		File tmp_path=new File(savePath);
		tmp_path.mkdirs();
		System.out.println("照片数据保存路径:"+savePath);

		//String msg = req.getParameter("msg");
		String[] strs = ParseString.parseBindApps(msg,"@");
		String shooRollId = strs[0];
		String picData1 = strs[1];
		String picExt1 = strs[2];
		System.out.println("picData1="+picData1);
		System.out.println("picExt1="+picExt1);

		String pic_base_64_data=picData1;
		System.out.println("数据为空="+null==pic_base_64_data);
		System.out.println("base64 string length:"+pic_base_64_data.length());
		String fileFormat=picExt1;

		byte[] datas = Base64.decodeBase64(pic_base_64_data);
		
		String filename=shooRollId+fileFormat;
//		String filename=String.valueOf("1")+fileFormat;
		File file=new File(savePath+filename);
		OutputStream fos=new FileOutputStream(file);
		System.out.println("图片文件名称:"+filename);
		fos.write(datas);
		fos.close();
		//sendMsg("ok");
	}
	/**
	 * 保存照相机拍摄的图片
	 * @return
	 * @throws Exception 
	 */
	public @ResponseBody void saveCutPic() throws Exception{
		HttpServletRequest req = ServletActionContext.getRequest();
		String savePath = ReadProperties.read("iconDir");
		String msg = req.getParameter("msg");
		String msg1 = req.getParameter("msg1");
		saveBigPic(msg1);
		String[] strs = ParseString.parseBindApps(msg,"@");
		String id = strs[0];
		String imgx = strs[1];
		String imgy = strs[2];
		String imgw = strs[3];
		String imgh = strs[4];
		float imageX = Float.parseFloat(imgx);
		float imageY = Float.parseFloat(imgy);
		float imageW = Float.parseFloat(imgw);
		float imageH = Float.parseFloat(imgh);
		int X = Math.round(imageX);
		int Y = Math.round(imageY);
		int W = Math.round(imageW);
		int H = Math.round(imageH);

		System.out.println("imageX="+imageX);
		System.out.println("imageY="+imageY);
		System.out.println("imageW="+imageW);
		System.out.println("imageH="+imageH);
		
		OperateImage cutImage = new OperateImage(X, Y, W, H);
		cutImage.setSrcpath(savePath+id+".jpeg");
		cutImage.setSubpath(savePath+id+"_small"+".jpeg");
		cutImage.setLastdir("jpeg");
		cutImage.cut();
		
		//压缩图片
		String smallImgNmae = ImageCompress.doCompress(savePath+id+"_small"+".jpeg", 120, 160, 1, "", false);
		System.out.println("Compressed Image name:"+ smallImgNmae);
		
		String urlPath = ReadProperties.read("sysiconDir");
		String imgUrl = urlPath+id+"_small"+".jpeg";
		ChSchoolroll sl = SchoolRollService.get(id);
		if(sl != null){
			sl.setChScroImage(imgUrl);
			ChSchoolroll updateReturn = SchoolRollService.update(sl);
			if(updateReturn != null){
				sendMsg(imgUrl);
			}else{
				sendMsg("error");
			}
		}
		
	}	
	
	
	/**
	 * 使用ajax批量删除记录
	 * @throws Exception
	 */
	public @ResponseBody void deleteIds() throws Exception{		
		String ids = ServletActionContext.getRequest().getParameter("ids");
		String[] idStrs = ParseString.parseBindApps(ids,",");
		
	}
	public void sendMsg(String content){      
	    HttpServletResponse response = ServletActionContext.getResponse();      
	    response.setCharacterEncoding("UTF-8");      
	    try {
	    	response.getWriter().write(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
	}
	
	/**
	 * 根据id查询到一个实体
	 * @return
	 * @throws Exception 
	 */
	public String findOneId() throws Exception{	 	
		String id = ServletActionContext.getRequest().getParameter("familyId");
		
		return "edit";
	}
	
	/**
	 * 更新用户家庭信息
	 * @return
	 */
	public String editFamily(){
		
		return "update";
	}


	@Override
	public ChSchoolroll getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void prepareModel() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String add() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String detail() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
