package aa.mine.superutil.thirdparty.freemarker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Locale;

import aa.mine.superutil.j2se.StringUtils;
import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

/**
 * Freemarker生成Html工具类
 * @author Goofy <a href="http://www.xdemo.org">http://www.xdemo.org</a>
 *
 */
@SuppressWarnings("deprecation")
public class FreemarkerUtils {
	
	private static Configuration getFreemarkerConfig(String templatePath) throws IOException{
		Configuration config=new Configuration();
		config.setDirectoryForTemplateLoading(new File(templatePath));
		config.setEncoding(Locale.CHINA, "utf-8");
		return config;
	}
	
	/**
	 * 用FTL模板生成HTML，并返回HTML内容
	 * @param ftlPath ftl模板文件的路径（不含文件名）
	 * @param ftlName ftl模板文件的名称（不含路径）
	 * @param outputFile 输出文件（全路径名称）
	 * @param data 数据Map类型，key-value
	 * @param charset 编码
	 * @throws TemplateNotFoundException
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static void generateToFile(String ftlPath,String ftlName,String outputFile,Object data,String charset) throws IOException {
		
		
		FileOutputStream fos=new FileOutputStream(outputFile); 
		Writer out=new OutputStreamWriter(fos, charset);
		try {
			charset=StringUtils.isBlank(charset)?"UTF-8":charset;
			
			Template tpl=getFreemarkerConfig(ftlPath).getTemplate(ftlName);
			tpl.setEncoding(charset);
			
			tpl.process(data, out);
			out.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			fos.close();
			out.close();
		}
	}
	
	/**
	 * 用FTL模板生成HTML，并返回HTML内容
	 * @param ftlPath ftl模板文件的路径（不含文件名）
	 * @param ftlName ftl模板文件的名称（不含路径）
	 * @param o 数据 Map类型，key-value
	 * @param charset 编码 
	 * @return
	 * @throws TemplateNotFoundException
	 * @throws MalformedTemplateNameException
	 * @throws ParseException
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static String generateToString(String ftlPath,String ftlName,Object o,String charset) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException{
		
		charset=StringUtils.isBlank(charset)?"UTF-8":charset;
		
		String html=null;
		
		Template tpl=getFreemarkerConfig(ftlPath).getTemplate(ftlName);
		tpl.setEncoding(charset);
		
		StringWriter writer=new StringWriter();
		tpl.process(o, writer);
		writer.flush();
		html=writer.toString();
		return html;
	}

}
