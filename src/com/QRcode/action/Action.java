package com.QRcode.action;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.QRcode.zxing.QRCodeFactory;
import com.google.zxing.WriterException;

public class Action extends DispatchAction{
	public static void main(String[] args) {
	    String content="https://fedemo.top";
		String logUri="D:\\timg.jpg";
		String outFileUri="D:\\img.jpg";
		int[]  size=new int[]{430,430};
		String format = "jpg";  
		try {
		    new QRCodeFactory().CreatQrImage(content, format, outFileUri, logUri,size);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (WriterException e) {
		    e.printStackTrace();
		}   
	}
	/**
	* 获得二维码
	* @param mapping
	* @param form
	* @param request
	* @param response
	* @throws Exception
	*/
	public void img(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
	 String content="https://fedemo.top";
	 int[]  size=new int[]{300,300};
	 String format = "jpg"; 
	 BufferedImage img=null;
	 try {
		 img=new QRCodeFactory().CreatImg(content, format, size);
	 } catch (WriterException e) {
	    e.printStackTrace();
	 }
	 ImageIO.write(img , "jpg", response.getOutputStream());
	}
}
