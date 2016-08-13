package aa.mine.superutil.j2se;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class RunTimeUtils {

	/**
	 * cmd array,这个方法用来导入数据库
	 * 
	 * @param cmd
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void run(String cmd[]) throws IOException {
		// 首先获得一个进程
		Process ps = getProcess(cmd[0]);

		// 获取进程的输出流
		OutputStream os = ps.getOutputStream();
		// 写输出流的方法
		OutputStreamWriter osw = new OutputStreamWriter(os);

		String _cmd = "";
		for (int i = 0; i < cmd.length; i++) {
			// 跳过第一个命令
			if (i == 0)
				continue;
			_cmd += cmd[i] + "\r\n";
		}

		osw.write(_cmd);
		osw.flush();
		osw.close();
		os.close();
		// 等待进程结束
		waitForComplete(ps);
	}

	/**
	 * 这个方法用来导出数据库
	 * 
	 * @param cmd
	 * @throws IOException
	 */
	public static void run(String cmd) throws IOException {
		Process ps = Runtime.getRuntime().exec(cmd);
		// 等待返回，让这个方法阻塞，否则提前返回，文件或者想要的结果没有生成，下一步操作会产生异常
		waitForComplete(ps);
	}

	public static Process getProcess(String cmd) throws IOException {
		return Runtime.getRuntime().exec(cmd);
	}
	
	/**
	 * 等待进程操作结束
	 * @param process
	 * @throws IOException
	 */
	public static void waitForComplete(Process process) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream(), "UTF-8"));
		input.readLine();
		input.close();
		process.destroy();
	}

}
