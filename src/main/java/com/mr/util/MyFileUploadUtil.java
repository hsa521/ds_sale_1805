package com.mr.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传
 */
public class MyFileUploadUtil {

	public static List<String> upload_image(MultipartFile[] files) {
		List<String> imgs = new ArrayList<String>();
		for (MultipartFile file : files) {
			if(!file.isEmpty()) {
				//获取存放的路径
				String path =
						MyPropertiesUtil.getPropertiesVal("myUploadImg.properties","url");

				//获取文件的名称 , 拼接文件名，确保唯一性
				String originalFilename = System.currentTimeMillis() + file.getOriginalFilename();
				
				//拼接路径
				String name = path + "/" + originalFilename;
				
				try {
					//传输文件
					file.transferTo(new File(name));
					//将文件名存放在list中，等待返回
					imgs.add(System.currentTimeMillis()+originalFilename);
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return imgs;
	}
	
}
