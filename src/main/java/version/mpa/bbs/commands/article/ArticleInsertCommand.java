package version.mpa.bbs.commands.article;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import version.mpa.bbs.commands.Command;
import version.mpa.bbs.util.StringUtil;
import version.mpa.bbs.vo.FileVO;

public class ArticleInsertCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fileDirectory = new StringUtil().getProperties(request, "multipart.saveDirectory");
		File directoryExists = new File(fileDirectory);
		if (!directoryExists.exists()){
			directoryExists.mkdirs();
		}
		int maxFileSize = 1024 * 1024 * 5;
		FileRenamePolicy fileRenamePolicy = new DefaultFileRenamePolicy();
		MultipartRequest multipartRequest = new MultipartRequest(request, fileDirectory, maxFileSize, "UTF-8", fileRenamePolicy);
		Enumeration files = multipartRequest.getFileNames();
		while (files.hasMoreElements()) {
			String file = (String) files.nextElement();
			String fileNameOnServer = multipartRequest.getFilesystemName(file);
			String fileNameOriginal = multipartRequest.getOriginalFileName(file);
			if (fileNameOriginal == null)
				continue;
			System.out.println(file);
			System.out.println(fileNameOnServer);
			System.out.println(fileNameOriginal);
			String fileExtension = fileNameOriginal.substring(fileNameOriginal.lastIndexOf(".") + 1);
			File f = multipartRequest.getFile(file);

			FileVO newFile = FileVO.builder().nameOnServer(fileNameOnServer).nameOriginal(fileNameOriginal).size(
							(int) f.length()).path(fileDirectory)
					.extension(fileExtension).build();
			System.out.println("file build OK");
		}
	}
}
