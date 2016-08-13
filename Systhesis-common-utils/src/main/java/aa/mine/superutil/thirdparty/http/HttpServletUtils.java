/**
 * 
 */
package aa.mine.superutil.thirdparty.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Goofy 
 * Http下载工具类
 */
public class HttpServletUtils {
	
	/**
	 * 获取项目网络路径
	 * @param request
	 * @return
	 */
	public static String getContentpath(HttpServletRequest request){
		return request.getContextPath();
	}
	
	/**
     * 获取项目磁盘绝对路径
     */
    public static String getRealPath(HttpServletRequest request){
        return request.getSession().getServletContext().getRealPath("/");
    }
    
    /**
     * 使用了代理服务器的，无法获取正确地址的，使用这个方法获取访问者的IP地址
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

	/**
	 * 下载多个文件
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param files
	 *            File
	 */
	public void download(HttpServletResponse response, File... files) {

		for (File file : files) {
			download(response, file, file.getName());
		}

	}

	/**
	 * 下载文件
	 * 
	 * @param response
	 *            HttpServletResponse
	 * @param file
	 *            文件
	 * @param fileName
	 *            下载的输出文件名
	 */
	public void download(HttpServletResponse response, File file, String fileName) {
		InputStream is = null;
		String _fileName = null;
		try {
			is = new FileInputStream(file);
			_fileName = fileName == null ? file.getName() : fileName;
			download(response, is, _fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 下载文件
	 * 
	 * @param is
	 *            输入流
	 * @param fileName
	 *            文件名
	 * @param response
	 */
	public void download(HttpServletResponse response, InputStream is, String fileName) {

		OutputStream os = null;

		try {
			response.reset();
			response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

			os = response.getOutputStream();

			byte buffer[] = new byte[1024];
			int len = 0;

			while ((len = is.read(buffer)) > 0) {
				os.write(buffer, 0, len);
			}

			os.flush();
			os.close();

			is.close();

		} catch (Exception e) {
			try {
				if (os != null)
					os.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			try {
				if (is != null)
					is.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

	}

}
