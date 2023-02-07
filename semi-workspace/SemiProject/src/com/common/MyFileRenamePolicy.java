package com.common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File originFile) {
		// TODO Auto-generated method stub

		String originName = originFile.getName();
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		int ranNum = (int) (Math.random() * 90000 + 10000);
		String ext = originName.substring(originName.lastIndexOf('.'));
		String changName = currentTime + ranNum + ext;
		File f = new File(originFile.getParent(), changName);
		return f;
	}
}
